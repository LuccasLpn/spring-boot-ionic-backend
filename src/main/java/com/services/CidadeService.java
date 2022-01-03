package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Cidade;
import com.repository.CidadeRepository;

@Service
public class CidadeService {
	
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public List<Cidade> findByEstado(Integer estadoId){
	     return cidadeRepository.findCidades(estadoId);  
	}
	

}
