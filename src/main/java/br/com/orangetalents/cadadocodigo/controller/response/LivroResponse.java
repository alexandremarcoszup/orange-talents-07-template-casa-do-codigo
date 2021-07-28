package br.com.orangetalents.cadadocodigo.controller.response;

import java.time.LocalDate;

public class LivroResponse {

    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private Double preco;

    private Integer numeroPaginas;

    private Integer isbn;

    private LocalDate dataLancamento;

    private CategoriaResponse categoria;

    private AutorResponse autor;

    public LivroResponse(){}

    public LivroResponse(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, Integer isbn, LocalDate dataLancamento,
                         CategoriaResponse categoriaResponse, AutorResponse autorResponse) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoriaResponse;
        this.autor = autorResponse;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public CategoriaResponse getCategoria() {
        return categoria;
    }

    public AutorResponse getAutor() {
        return autor;
    }


}
