package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.domain.Categoria;
import com.domain.Produto;
import com.repository.CategoriaRepository;
import com.repository.ProdutoRepository;
import com.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado " + id ));
		
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		
		return produtoRepository.findDistinctByNameContainingAndCategoriasIn(nome, categorias, pageRequest);
	}

}