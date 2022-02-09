package br.com.itf.vicente.application.services;

import org.springframework.stereotype.Service;

import br.com.itf.vicente.application.model.Categoria;
import br.com.itf.vicente.application.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	
	private final CategoriaRepository categoriaRepository;
	
	public CategoriaService( CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public void salvar(Categoria categoria) {
		categoriaRepository.save(categoria);
		System.out.println("Categoria salva");
	}
}
