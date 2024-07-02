package com.appweb.services;

import com.appweb.request_dtos.UserRequestLoginDto;
import com.appweb.responseDto.UserResponseDto;

public interface LoginService {

	public UserResponseDto login( UserRequestLoginDto userLoginDto);
}
