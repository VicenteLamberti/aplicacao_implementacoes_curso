package br.com.itf.vicente.application;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.EntityManager;

import br.com.itf.vicente.application.dao.CategoriaDao;
import br.com.itf.vicente.application.dao.ClienteDao;
import br.com.itf.vicente.application.dao.PedidoDao;
import br.com.itf.vicente.application.dao.ProdutoDao;
import br.com.itf.vicente.application.model.Categoria;
import br.com.itf.vicente.application.model.Cliente;
import br.com.itf.vicente.application.model.ItemPedido;
import br.com.itf.vicente.application.model.Pedido;
import br.com.itf.vicente.application.model.Produto;
import br.com.itf.vicente.application.util.JPAUtil;

public class TestePerformance {
	public static void main(String[] args) {

		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
		Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);
		
		
		Cliente cliente = new Cliente("Rodrigo", "123456");
		
		Pedido pedido = new Pedido(cliente);
		
		pedido.adicionaItem(new ItemPedido(10,pedido,celular));
		pedido.adicionaItem(new ItemPedido(40,pedido,videogame));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionaItem(new ItemPedido(2,pedido2,macbook));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao= new PedidoDao(em);
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);
		
		clienteDao.cadastrar(cliente);
		
		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);
		
		em.getTransaction().commit();
		em.close();
	}
}
