package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    public static void main(String[] args) {
        Teste t = new Teste();
        t.setTeste1(new BigDecimal(1000.0));

        try {
            CalculadorDeClasses m = new CalculadorDeClasses();
            System.out.println(m.somar(t));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BigDecimal somar(Object classe) {
        return this.somatorio(classe, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object classe) {
        return this.somatorio(classe, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object classe) {
        return this.somar(classe).subtract(this.subtrair(classe));
    }

    public BigDecimal somatorio(Object classe, Class annotionProcurada) {
        BigDecimal total = BigDecimal.ZERO;

        try {
            Field[] fields = classe.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(annotionProcurada) && field.getType().equals(BigDecimal.class)) {
                    field.setAccessible(true);
                    if (field.get(classe) != null) {
                        total = total.add((BigDecimal) field.get(classe));
                    }
                } else {
                    total = total.add(BigDecimal.ZERO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
}
