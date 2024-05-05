package com.appweb.models;


public class User {

	private String name;
	
	private String apellido;
	
	private String username;

	private String email;

	private String telefono;
	
	private String password;

	private String confirmPassword;

	public User() {
	}

	public User(String username, String password, String confirmPassword, String name, String apellido,
			String telefono, String email) {
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.name = name;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", name=" + name + ", apellido=" + apellido + ", telefono=" + telefono + ", email="
				+ email + "]\n";
	}

}
