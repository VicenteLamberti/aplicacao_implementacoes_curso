package br.com.itf.vicente.application.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.itf.vicente.application.model.Pedido;
import br.com.itf.vicente.application.vo.RelatorioDeVendasVo;

public class PedidoDao {
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql,BigDecimal.class)
				.getSingleResult();
	}
	
	public List<RelatorioDeVendasVo> relatorioDeVendas(){
		String jpql = "SELECT new br.com.itf.vicente.application.vo.RelatorioDeVendasVo("
				+ "produto.nome, "
				+ "SUM(item.quantidade), "
				+ "MAX(pedido.dataCadastro)) " 
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		return em.createQuery(jpql,RelatorioDeVendasVo.class)
				.getResultList();
	}	
	public Pedido buscarPedidoComCliente(Long id) {
		String jpql = "SELECT p FROM Produto p JOIN FETCH p.cliente WHERE p.id = :id";
		return em.createQuery(jpql,Pedido.class)
		.setParameter(0, jpql)
		.getSingleResult();
	}
	
	
}
