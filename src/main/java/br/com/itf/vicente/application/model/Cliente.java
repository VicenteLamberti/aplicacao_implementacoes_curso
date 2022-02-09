package br.com.itf.vicente.application.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private DadosPessoais dadosPessoais;

	
	public Cliente() {
	}

	

	public Cliente( String nome, String cpf) {
		super();

		this.dadosPessoais = new DadosPessoais(nome,cpf);
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return this.dadosPessoais.getNome();
	}


	public DadosPessoais getDadosPessoais() {
		return this.dadosPessoais;
	}
	


	public String getCpf() {
		return this.dadosPessoais.getCpf();
	}


	

	

	


	
	
	
}
