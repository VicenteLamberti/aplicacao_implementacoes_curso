package br.com.itf.vicente.application;

import java.math.BigDecimal;
import java.util.List;

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
import br.com.itf.vicente.application.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {

		
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		
		Cliente cliente =  clienteDao.buscarPorId(1l);
		Pedido pedido = new Pedido(cliente);
		pedido.adicionaItem(new ItemPedido(10,pedido,produto));
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		
		
		em.getTransaction().commit();
		
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println(totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);
		
	}
	private static void popularBancoDeDados() {
		
		
		Categoria celulares = new Categoria("Celulares");
		Produto celular = new Produto("MOTOG", "muito ruim", new BigDecimal(2000), celulares);
		Cliente cliente = new Cliente("vicente","123456");
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);
		em.getTransaction().commit();
		em.close();
	}
}