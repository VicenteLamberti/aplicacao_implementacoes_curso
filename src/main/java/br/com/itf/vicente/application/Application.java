package br.com.itf.vicente.application;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.itf.vicente.application.dao.CategoriaDao;
import br.com.itf.vicente.application.dao.ProdutoDao;
import br.com.itf.vicente.application.model.Categoria;
import br.com.itf.vicente.application.model.Produto;
import br.com.itf.vicente.application.util.JPAUtil;

public class Application {

	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getNome());
	}

	
	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("Celulares");
		Produto celular = new Produto("MOTOG", "muito ruim", new BigDecimal(2000), celulares);
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
