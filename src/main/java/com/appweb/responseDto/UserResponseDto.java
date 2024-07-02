package com.appweb.responseDto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserResponseDto {

	private Long id; // Cambiado a Long para manejar grandes valores de ID
	private String username;
	private String password; // Es posible que desees considerar no devolver la contraseña en el DTO
	private String name;
	private String apellido;
	private String telefono;
	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
	private LocalDateTime fechaCreacion;

	private String role;
	private String token;

	public UserResponseDto() {
	}

	public UserResponseDto(Long id, String username, String password, String name, String apellido, String telefono,
			String email, LocalDateTime fechaCreacion, String role, String token) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.role = role;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserResponseDto [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email + ", fechaCreacion="
				+ fechaCreacion + ", role=" + role + ", token=" + token + "]";
	}

}