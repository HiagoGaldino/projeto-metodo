// File: src/br/com/sistema/command/CalcularTotalPagamentoCompositeCommand.java
package br.com.sistema.command;

import br.com.sistema.composite.CompositePagamento;
import br.com.sistema.composite.PagamentoComponente;
import br.com.sistema.model.Pagamento;
import br.com.sistema.repository.SistemaMediator;
import java.util.List;

public class CalcularTotalPagamentoCompositeCommand implements Command {
    private SistemaMediator mediator;

    public CalcularTotalPagamentoCompositeCommand(SistemaMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public Object execute(Object arg) {
        List<Integer> ids = (List<Integer>) arg;
        CompositePagamento composite = new CompositePagamento();
        for (Integer id : ids) {
            Pagamento p = mediator.getPagamentoById(id);
            if (p != null) {
                composite.add(new PagamentoAdapter(p));
            }
        }
        System.out.println("Total composite: " + composite.getValorTotal());
        return composite.getValorTotal();
    }

    @Override
    public void undo() {
        // Não aplicável
    }

    private class PagamentoAdapter implements PagamentoComponente {
        private Pagamento pagamento;
        public PagamentoAdapter(Pagamento pagamento) {
            this.pagamento = pagamento;
        }
        @Override
        public double getValorTotal() {
            return pagamento.getValor();
        }
    }
}
