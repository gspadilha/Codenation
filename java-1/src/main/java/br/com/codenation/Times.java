package br.com.codenation;

import java.time.LocalDate;

public class Times {
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;

    public Times(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
}
