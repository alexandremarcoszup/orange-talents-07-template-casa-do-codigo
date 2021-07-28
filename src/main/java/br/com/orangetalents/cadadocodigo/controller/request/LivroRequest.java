package br.com.orangetalents.cadadocodigo.controller.request;

import br.com.orangetalents.cadadocodigo.domain.entity.Autor;
import br.com.orangetalents.cadadocodigo.domain.entity.Categoria;
import br.com.orangetalents.cadadocodigo.domain.entity.Livro;
import br.com.orangetalents.cadadocodigo.domain.repository.AutorRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.CategoriaRepository;
import br.com.orangetalents.cadadocodigo.security.validator.ExistisId;
import br.com.orangetalents.cadadocodigo.security.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(value = 20)
    private Double preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroPaginas;

    @NotNull
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private Integer isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @NotNull
    @ExistisId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull
    @ExistisId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public LivroRequest() {
    }

    public LivroRequest(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, @NotNull @Min(value = 20) String sumario,
                        @NotNull @Min(value = 20) Double preco, @NotNull @Min(value = 100) Integer numeroPaginas, @NotNull Integer isbn,
                        LocalDate dataLancamento, @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    public Livro requestToDomain(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autor = autorRepository.findById(this.idAutor);
        Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
                this.dataLancamento, categoria.get(), autor.get());

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }
}
