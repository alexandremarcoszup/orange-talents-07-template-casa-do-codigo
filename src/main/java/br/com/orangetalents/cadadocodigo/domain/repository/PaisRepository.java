package br.com.orangetalents.cadadocodigo.domain.repository;

import br.com.orangetalents.cadadocodigo.domain.entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
}
