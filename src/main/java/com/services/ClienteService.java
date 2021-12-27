package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.DTO.ClienteDTO;
import com.domain.Cliente;
import com.repository.ClienteRepository;
import com.services.exceptions.DataIntegrityException;
import com.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado " + id ));
		
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId());
		updaData(newObj,obj);
		return clienteRepository.save(newObj);
	}
	
	private void updaData(Cliente newObj, Cliente obj) {
	newObj.setName(obj.getName());
	newObj.setEmail(obj.getEmail());
	}

	public void delete(Integer id) {
		try {
			
			clienteRepository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			 throw new DataIntegrityException("Não e Possivel Excluir uma Cliente que possui produtos"); 
			 
		}
		
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(),objDto.getName(),objDto.getEmail(), null,null);
	}

}
