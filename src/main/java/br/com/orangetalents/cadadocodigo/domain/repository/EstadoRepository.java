package br.com.orangetalents.cadadocodigo.domain.repository;

import br.com.orangetalents.cadadocodigo.domain.entity.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
}
