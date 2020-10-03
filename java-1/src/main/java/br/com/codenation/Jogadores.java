package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogadores {
    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;
    private Boolean isCaptain;

    public Jogadores(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
        this.isCaptain = false;
    }

    public Long getId() {
        return this.id;
    }

    public Long getIdTime() {
        return this.idTime;
    }

    public String getNome() {
        return this.nome;
    }

    public Integer getNivelHabilidade() {
        return this.nivelHabilidade;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setIsCaptain(Boolean isCaptain) {
        this.isCaptain = isCaptain;
    }

    public Boolean isCaptain() {
        return this.isCaptain;
    }
}
