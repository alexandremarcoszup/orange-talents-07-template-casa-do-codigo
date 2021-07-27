package br.com.orangetalents.cadadocodigo.domain.repository;

import br.com.orangetalents.cadadocodigo.domain.entity.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
}
