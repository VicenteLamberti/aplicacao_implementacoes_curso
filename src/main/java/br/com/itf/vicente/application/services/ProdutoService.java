package br.com.itf.vicente.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.itf.vicente.application.model.Produto;
import br.com.itf.vicente.application.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto buscarPorId(Long id) {
		
		Optional<Produto> objProduto =  produtoRepository.findById(id);
		return objProduto.orElse(null);
	}
	
	public void salvar(Produto produto) {
		produtoRepository.save(produto);
		System.out.println("Produto salvo");
	}
}
