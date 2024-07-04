package com.appweb.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appweb.clients.FaceConectClient;
import com.appweb.request_dtos.UsuarioRequestFaceDto;
import com.appweb.responseDto.UserResponseDto;
import com.appweb.services.LoginService;

@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	private FaceConectClient faceConectClient;

	@Override
	public UserResponseDto login(UsuarioRequestFaceDto userLoginDto) {
		try {
			// Cambia el tipo de ResponseEntity a String si esperas un texto plano
			ResponseEntity<String> response = faceConectClient.registerFaceUser(userLoginDto);

			System.out.println(response.toString());

			if (response.getStatusCode().is2xxSuccessful()) {
				// Captura el cuerpo de la respuesta como texto plano
				String responseBody = response.getBody();

				// Imprime el cuerpo de la respuesta
				System.out.println("Respuesta del servidor: " + responseBody);

				// Aquí puedes procesar el texto plano según sea necesario
				// Ejemplo: convertir el texto plano a UserResponseDto (si es necesario)

				return null; // Retorna el objeto procesado según tus necesidades
			} else {
				System.out.println("Login fallido con estado: " + response.getStatusCode());
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error en la solicitud...");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
