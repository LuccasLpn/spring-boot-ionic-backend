package com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Categoria;
import com.domain.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{
	
	@Transactional(readOnly = true)
	Page<Produto> findDistinctByNameContainingAndCategoriasIn(String nome, List<Categoria> categorias , Pageable pageRequest);
	
}
