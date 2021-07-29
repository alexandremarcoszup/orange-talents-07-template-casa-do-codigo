package br.com.orangetalents.cadadocodigo.domain.repository;

import br.com.orangetalents.cadadocodigo.domain.entity.Livro;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends PagingAndSortingRepository<Livro, Long> {
}
