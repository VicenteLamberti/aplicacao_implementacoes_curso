package br.com.itf.vicente.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itf.vicente.application.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
