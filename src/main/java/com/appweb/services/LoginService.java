package com.appweb.services;

import com.appweb.request_dtos.UsuarioRequestFaceDto;
import com.appweb.responseDto.UserResponseDto;

public interface LoginService {

	public UserResponseDto login( UsuarioRequestFaceDto use);
}
