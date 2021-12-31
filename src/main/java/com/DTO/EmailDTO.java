package com.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotEmpty;

public class EmailDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	@NotEmpty(message = "Prenchimento Obrigatorio")
	@Email(message = "Email Invalido")
	private String email;
	
	public EmailDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
