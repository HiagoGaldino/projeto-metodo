// File: src/br/com/sistema/composite/CompositePagamento.java
package br.com.sistema.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositePagamento implements PagamentoComponente {
    private List<PagamentoComponente> componentes = new ArrayList<>();

    public void add(PagamentoComponente componente) {
        componentes.add(componente);
    }

    public void remove(PagamentoComponente componente) {
        componentes.remove(componente);
    }

    @Override
    public double getValorTotal() {
        double total = 0;
        for (PagamentoComponente comp : componentes) {
            total += comp.getValorTotal();
        }
        return total;
    }
}
