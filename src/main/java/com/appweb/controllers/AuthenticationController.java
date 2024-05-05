package com.appweb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appweb.models.User;
import com.appweb.request_dtos.UsuarioDtoRequest;
import com.appweb.services.AuthService;

import feign.FeignException;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	@Autowired
	private AuthService authService;

	/**
	 * Método que muestra el formulario para que se registren nuevos usuarios.
	 * 
	 * @param usuario
	 * @return
	 */
	@GetMapping("/get-form-register")
	public String registrarse() {

		return "formRegistro";
	}

	/**
	 * Método que resibira al usuario y lo enviara a una api de registro de usuarios
	 * que es una api gateway para registrar usuarios
	 * 
	 * @param usuario
	 * @param attributes
	 * @return
	 */
	@PostMapping("/register")
	public String processRegistrationForm(User user, Model model, HttpServletResponse response) {
	    UsuarioDtoRequest usrDto = new UsuarioDtoRequest();
	    usrDto.setName(user.getName());
	    usrDto.setApellido(user.getApellido());
	    usrDto.setUsername(user.getEmail());
	    usrDto.setEmail(user.getEmail());
	    usrDto.setTelefono(user.getTelefono());
	    usrDto.setPassword(user.getPassword());

	    try {
	        ResponseEntity<?> response1 = authService.registerUser(usrDto);

	        if (response1.getStatusCode() == HttpStatus.CREATED) {
	            return "redirect:/home"; // Redirige a una página de registro exitoso
	        } else if (response1.getStatusCode() == HttpStatus.CONFLICT) {
	            model.addAttribute("error", "El usuario ya existe. Por favor, intenta con un nombre de usuario diferente.");
	        } else if (response1.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
	            model.addAttribute("error", "No se pudo comunicar con el servidor de gateway.");
	        } else {
	            model.addAttribute("error", "Hubo un error al intentar registrar el usuario. Por favor, inténtelo de nuevo más tarde.");
	        }

	    } catch (FeignException ex) {
	        logger.error("Hubo un error no reconocido al intentar registrar el usuario", ex);
	        model.addAttribute("error", "Hubo un error al intentar registrar el usuario. Por favor, inténtelo de nuevo más tarde.");
	    }
	    return "formRegistro"; // Renderiza nuevamente el formulario de registro con un mensaje de error
	}
}
