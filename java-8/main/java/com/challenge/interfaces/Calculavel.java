package com.challenge.interfaces;

import com.challenge.annotation.Somar;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public interface Calculavel {
    public BigDecimal somar(Object classe) throws IllegalAccessException;
    public BigDecimal subtrair(Object classe);
    public BigDecimal totalizar(Object classe);
}
