package com.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.domain.Categoria;
import com.repository.CategoriaRepository;
import com.services.exceptions.DataIntegrityException;
import com.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado " + id ));
		
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		findById(obj.getId());
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			 throw new DataIntegrityException("Não e Possivel Excluir uma Categoria que possui produtos");
		}
		
	}

}
