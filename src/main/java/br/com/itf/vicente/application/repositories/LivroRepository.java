package br.com.itf.vicente.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itf.vicente.application.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
