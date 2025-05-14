package br.com.sistema.adapter;

import br.com.sistema.model.Pagamento;
import br.com.sistema.composite.PagamentoComponente;

public class PagamentoAdapter implements PagamentoComponente {
    private Pagamento pagamento;

    public PagamentoAdapter(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public double getValorTotal() {
        return pagamento.getValor();
    }
}
