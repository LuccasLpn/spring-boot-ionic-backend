package com.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.DTO.ClienteNewDTO;
import com.domain.Cliente;
import com.domain.enums.TipoCliente;
import com.repository.ClienteRepository;
import com.resources.exception.FieldMessage;
import com.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && ! BR.isValidCPF(objDto.getCpfOuCnpj())){
			list.add(new FieldMessage("CpfOuCnpj", "CPF Inválido"));
		}
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && ! BR.isValidCNPJ(objDto.getCpfOuCnpj())){
			list.add(new FieldMessage("CpfOuCnpj", "CNPJ Inválido"));
		}
		
		Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
		
		if(aux != null) {
			list.add(new FieldMessage("Email", "Email já existente"));
		}
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldname())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}