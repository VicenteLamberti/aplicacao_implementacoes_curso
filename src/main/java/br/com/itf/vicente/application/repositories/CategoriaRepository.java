package br.com.itf.vicente.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itf.vicente.application.model.Categoria;
import br.com.itf.vicente.application.model.CategoriaId;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, CategoriaId>  {

}
