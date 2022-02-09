package br.com.itf.vicente.model;

public class Livro extends Produto{

	
	private String autor;
	private Integer quantidadeDePaginas;
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(String autor, Integer quantidadeDePaginas) {
		super();
		this.autor = autor;
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getQuantidadeDePaginas() {
		return quantidadeDePaginas;
	}

	public void setQuantidadeDePaginas(Integer quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}
	
	
	
	
}
