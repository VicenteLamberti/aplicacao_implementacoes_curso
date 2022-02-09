package br.com.itf.vicente.application.dao;

import javax.persistence.EntityManager;

import br.com.itf.vicente.application.model.Categoria;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
}
