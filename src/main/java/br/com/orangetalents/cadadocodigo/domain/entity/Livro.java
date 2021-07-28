package br.com.orangetalents.cadadocodigo.domain.entity;

import br.com.orangetalents.cadadocodigo.controller.response.LivroResponse;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Column(length = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(value = 20)
    private Double preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroPaginas;

    @NotNull
    @Column(unique = true)
    private Integer isbn;

    @Future
    @NotNull
    private LocalDate dataLancamento;

    @ManyToOne
    @NotNull
    private Categoria categoria;

    @ManyToOne
    @NotNull
    private Autor autor;

    public Livro(){}

    public Livro(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, Integer isbn, LocalDate dataLancamento,
                 Categoria categoria, Autor autor) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    public LivroResponse domainToResponse(){
        return new LivroResponse(this.titulo,this.resumo,this.sumario,this.preco,this.numeroPaginas,this.isbn,this.dataLancamento,
                categoria.domainToResponse(),this.autor.domainToResponse());
    }
}
