package com.challenge.desafio;

import com.challenge.annotation.Somar;

import java.math.BigDecimal;

public class Teste {
    @Somar
    private BigDecimal teste1;
    @Somar
    private int teste2;
    private BigDecimal teste3;
    @Somar
    public BigDecimal teste4;

    public BigDecimal getTeste1() {
        return teste1;
    }

    public void setTeste1(BigDecimal teste1) {
        this.teste1 = teste1;
    }
}
