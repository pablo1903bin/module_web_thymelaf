package com.appweb.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appweb.clients.AuthClient;
import com.appweb.request_dtos.UsuarioDtoRequest;

import feign.FeignException;

@Service
public class AuthService {

	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

	@Autowired
	private AuthClient authClient;

	public ResponseEntity<?> registerUser(UsuarioDtoRequest userDto) {

		logger.info("Llamando al servicio de registro de usuarios gateway");
  System.out.println(userDto.toString());
		try {
			
			ResponseEntity<?> response = authClient.signUp(userDto);

			logger.info("se registro correctamente");
			// Si la respuesta es un código de estado 201, devolver la misma respuesta
			if (response.getStatusCode() == HttpStatus.CREATED) {
				return ResponseEntity.status(HttpStatus.CREATED).body(response.getBody());
			} else if (response.getStatusCode() == HttpStatus.CONFLICT) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}

		} catch (FeignException.ServiceUnavailable ex) {
			logger.info("Servicio de registro no esta disponible gateway");
		     return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("El servicio de registro de usuarios no está disponible en este momento. Por favor, inténtelo de nuevo más tarde.");
		} catch (FeignException.Conflict fc) {
			logger.info("Usuario duplicado");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (FeignException ex) {
			// Otros errores de Feign, manejar según sea necesario
			System.out.println("Error al comunicarse con el servicio de registro: " + ex.getMessage());
		}
		   // Respuesta por defecto
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al comunicarse con el servicio de registro");
	}
}
