package com.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.domain.Cliente;

@SuppressWarnings("deprecation")
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	@SuppressWarnings("deprecation")
	@NotEmpty(message = "Prenchimento Obrigatorio")
	@Length(min = 5, max = 120, message = "O tamnho deve ser entre 5 e 120 caracteres")
	private String name;
	

	@SuppressWarnings("deprecation")
	@NotEmpty(message = "Prenchimento Obrigatorio")
	@Email(message = "Email Invalido")
	private String email;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
