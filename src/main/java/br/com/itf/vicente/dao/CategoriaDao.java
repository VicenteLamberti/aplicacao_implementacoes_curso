package br.com.itf.vicente.dao;

import javax.persistence.EntityManager;

import br.com.itf.vicente.model.Categoria;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
}
