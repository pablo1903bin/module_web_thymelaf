package com.appweb.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.appweb.request_dtos.UserRequestLoginDto;
import com.appweb.request_dtos.UsuarioDtoRequest;
import com.appweb.responseDto.UserResponseDto;

//http://45.33.13.164//gateway/api/authentication/sign-in
//http://45.33.13.164//gateway/api/authentication/sign-in
@FeignClient(
	    value = "gateway", 
	    path = "/gateway/api/authentication", 
	    url = "${url.service.gateway}" // Asegúrate de que no hay doble barra al final
	)
	public interface AuthClient {

	    @PostMapping("/sign-up")
	    ResponseEntity<?> signUp(@RequestBody UsuarioDtoRequest userDto);

	    @PostMapping("/sign-in")
	    ResponseEntity<?> signIn(@RequestBody UserRequestLoginDto userRequest);
	}