package br.com.itf.vicente.dao;

import javax.persistence.EntityManager;

import br.com.itf.vicente.model.Cliente;

public class ClienteDao {
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return this.em.find(Cliente.class, id);
	}
	
	
	
	
}
