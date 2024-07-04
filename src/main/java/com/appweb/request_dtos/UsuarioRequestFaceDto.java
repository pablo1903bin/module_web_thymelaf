package com.appweb.request_dtos;

public class UsuarioRequestFaceDto {

	public String nombreUsuario;
	public String contraseña;

	public UsuarioRequestFaceDto() {

	}

	public UsuarioRequestFaceDto(String nombreUsuario, String contraseña) {

		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "UsuarioRequestDto [nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + "]";
	}

}
