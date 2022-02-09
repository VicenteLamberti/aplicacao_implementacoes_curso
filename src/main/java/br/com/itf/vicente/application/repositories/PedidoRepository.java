package br.com.itf.vicente.application.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.itf.vicente.application.model.Pedido;
import br.com.itf.vicente.application.vo.RelatorioDeVendasVo;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Query("SELECT SUM(p.valorTotal) FROM Pedido p")
	BigDecimal getValorTotalVendido();
	
	
	//Select New -  usando VO
	@Query("SELECT new br.com.itf.vicente.application.vo.RelatorioDeVendasVo(produto.nome, SUM(item.quantidade), MAX(pedido.dataCadastro)) FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto GROUP BY produto.nome ORDER BY item.quantidade DESC")
	List<RelatorioDeVendasVo> getRelatorioDeVendas();
}
