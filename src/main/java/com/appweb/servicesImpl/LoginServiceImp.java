package com.appweb.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appweb.clients.AuthClient;
import com.appweb.request_dtos.UserRequestLoginDto;
import com.appweb.responseDto.UserResponseDto;
import com.appweb.services.LoginService;
@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private AuthClient authClient;

    @Override
    public UserResponseDto login(UserRequestLoginDto userLoginDto) {
    	
        try {
            ResponseEntity<?> response = authClient.signIn(userLoginDto);
            System.out.println(response.toString());

            if (response.getStatusCode().is2xxSuccessful()) {
            	//
            	System.out.println("Login correcto...");
                return null;
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