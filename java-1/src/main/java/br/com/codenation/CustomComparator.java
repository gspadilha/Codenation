package br.com.codenation;

import java.util.Comparator;

public class CustomComparator implements Comparator<Jogadores> {
    @Override
    public int compare(Jogadores o1, Jogadores o2) {
        return o2.getNivelHabilidade().compareTo(o1.getNivelHabilidade());
    }
}