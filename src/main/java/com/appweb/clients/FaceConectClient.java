package com.appweb.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.appweb.request_dtos.UsuarioRequestFaceDto;

@FeignClient(value = "face", path = "/gateway/authentication", url = "${url.service.gateway}")
public interface FaceConectClient {

	@PostMapping(value = "/login", consumes = "application/json", produces = "text/plain")
	ResponseEntity<String> registerFaceUser(@RequestBody UsuarioRequestFaceDto usuario);
}
