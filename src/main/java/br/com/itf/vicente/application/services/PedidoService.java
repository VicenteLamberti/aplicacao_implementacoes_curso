package br.com.itf.vicente.application.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itf.vicente.application.model.Pedido;
import br.com.itf.vicente.application.repositories.PedidoRepository;
import br.com.itf.vicente.application.vo.RelatorioDeVendasVo;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	public PedidoService(PedidoRepository pedidoRepository){
		this.pedidoRepository = pedidoRepository;
	}
	
	public void salvar(Pedido pedido) {
		this.pedidoRepository.save(pedido);
		System.out.println("Pedido salvo");
	}
	
	public BigDecimal buscarValorTotalVendido() {
		return this.pedidoRepository.getValorTotalVendido();
	}
	
	public List<RelatorioDeVendasVo> buscarRelatoriosDeVenda(){
		return this.pedidoRepository.getRelatorioDeVendas();
	}

}
