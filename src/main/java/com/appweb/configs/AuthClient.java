package com.appweb.configs;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.appweb.request_dtos.UsuarioDtoRequest;

@FeignClient(name = "gateway")
public interface AuthClient {
	@PostMapping("/gateway/api/authentication/sign-up")
	 ResponseEntity<?> signUp(@RequestBody UsuarioDtoRequest userDto);
}