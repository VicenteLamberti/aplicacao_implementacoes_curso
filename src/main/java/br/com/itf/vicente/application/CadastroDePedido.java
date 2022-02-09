package br.com.itf.vicente.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.itf.vicente.application.model.Categoria;
import br.com.itf.vicente.application.model.Cliente;
import br.com.itf.vicente.application.model.ItemPedido;
import br.com.itf.vicente.application.model.Pedido;
import br.com.itf.vicente.application.model.Produto;
import br.com.itf.vicente.application.services.CategoriaService;
import br.com.itf.vicente.application.services.ClienteService;
import br.com.itf.vicente.application.services.PedidoService;
import br.com.itf.vicente.application.services.ProdutoService;
import br.com.itf.vicente.application.vo.RelatorioDeVendasVo;

@SpringBootApplication
public class CadastroDePedido implements CommandLineRunner {

	@Autowired
	private final ProdutoService produtoService= null;
	@Autowired
	private final CategoriaService categoriaService=null;
	@Autowired
	private final ClienteService clienteService=null;;
	@Autowired
	private final PedidoService pedidoService=null;;
	
//	public CadastroDePedido(ProdutoService produtoService,CategoriaService categoriaService,ClienteService clienteService) {
//		this.produtoService = produtoService;
//		this.categoriaService = categoriaService;
//		this.clienteService = clienteService;
//
//	}
	

	
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroDePedido.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("oi");
//		popularBancoDeDados();
	
		Categoria categoria1 = new Categoria("ELETRODOMESTICOS");
		
		this.categoriaService.salvar(categoria1);
		
		Produto produto1 = new Produto("GELADEIRA","BRANCA",new BigDecimal(1000), categoria1);
		
		this.produtoService.salvar(produto1);
		
		Produto produto = this.produtoService.buscarPorId(1l);
		
		System.out.println(produto);;
		
		
		
		
		Cliente cliente1 = new Cliente("Vicente","99999999");
		this.clienteService.salvar(cliente1);
		
		Cliente cliente =  this.clienteService.buscarPorId(1l);
		
		Pedido pedido = new Pedido(cliente);
		
		pedido.adicionaItem(new ItemPedido(10,pedido,produto));

		this.pedidoService.salvar(pedido);


		
		
		BigDecimal totalVendido = pedidoService.buscarValorTotalVendido();
		System.out.println("Valor total vendido foi igual a " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorios = pedidoService.buscarRelatoriosDeVenda();
		relatorios.forEach(x -> System.out.println("---Relatorio---"));
		relatorios.forEach(System.out::println);
		
		
		
		
		System.out.println("--------------------PARTE DOIS-------------------");
		
		
		Categoria categoriaCelular = new Categoria("Celulares");
		Produto celular2 = new Produto("MOTOG", "muito ruim", new BigDecimal(2000), categoriaCelular);
		Cliente cliente2 = new Cliente("vicente","123456");
	
		
		
		categoriaService.salvar(categoriaCelular);
		produtoService.salvar(celular2);
		clienteService.salvar(cliente2);
		
		
	}
	
	
//	private static void popularBancoDeDados() {
//		
//		
//		Categoria celulares = new Categoria("Celulares");
//		Produto celular = new Produto("MOTOG", "muito ruim", new BigDecimal(2000), celulares);
//		Cliente cliente = new Cliente("vicente","123456");
//		
//		EntityManager em = JPAUtil.getEntityManager();
//		ProdutoDao produtoDao = new ProdutoDao(em);
//		CategoriaDao categoriaDao = new CategoriaDao(em);
//		ClienteDao clienteDao = new ClienteDao(em);
//		
//		em.getTransaction().begin();
//		categoriaDao.cadastrar(celulares);
//		produtoDao.cadastrar(celular);
//		clienteDao.cadastrar(cliente);
//		em.getTransaction().commit();
//		em.close();
//		
//		
//	}

	
}