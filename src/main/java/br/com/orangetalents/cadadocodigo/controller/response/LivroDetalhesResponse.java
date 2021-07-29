package br.com.orangetalents.cadadocodigo.controller.response;

import java.time.LocalDate;

public class LivroDetalhesResponse {

    private String titulo;

    private String resumo;

    private String sumario;

    private Double preco;

    private Integer numeroPaginas;

    private Integer isbn;

    private LocalDate dataLancamento;

    private AutorDetalhesResponse autorDetalhesResponse;

    public LivroDetalhesResponse(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, Integer isbn,
                                 LocalDate dataLancamento, AutorDetalhesResponse autorDetalhesResponse){
        this.titulo = titulo;
        this.resumo =resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.autorDetalhesResponse = autorDetalhesResponse;
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

    public AutorDetalhesResponse getAutorDetalhesResponse() {
        return autorDetalhesResponse;
    }
}
