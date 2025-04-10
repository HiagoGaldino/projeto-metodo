// File: src/br/com/sistema/command/AtualizarPagamentoCommand.java
package br.com.sistema.command;

import br.com.sistema.model.Pagamento;
import br.com.sistema.model.PaymentMemento;
import br.com.sistema.repository.SistemaMediator;

public class AtualizarPagamentoCommand implements Command {
    private SistemaMediator mediator;
    private PaymentMemento lastMemento;
    private int lastPagamentoId;
    private boolean executed = false;
    
    public AtualizarPagamentoCommand(SistemaMediator mediator) {
        this.mediator = mediator;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        int id = (Integer) params[0];
        double novoValor = (Double) params[1];
        String novoMetodo = (String) params[2];
        
        Pagamento pagamento = mediator.getPagamentoById(id);
        if (pagamento == null) {
            System.out.println("Pagamento não encontrado!");
            return null;
        }
        lastMemento = pagamento.createMemento();
        lastPagamentoId = id;
        executed = true;
        
        pagamento.setValor(novoValor);
        pagamento.setMetodo(novoMetodo);
        mediator.salvarPagamentos();
        System.out.println("Pagamento atualizado com sucesso!");
        return pagamento;
    }
    
    @Override
    public void undo() {
        if (!executed || lastMemento == null) {
            System.out.println("Nenhuma atualização para desfazer!");
            return;
        }
        Pagamento pagamento = mediator.getPagamentoById(lastPagamentoId);
        if (pagamento != null) {
            pagamento.restoreMemento(lastMemento);
            mediator.salvarPagamentos();
            System.out.println("Atualização desfeita com sucesso!");
            executed = false;
            lastMemento = null;
        } else {
            System.out.println("Pagamento não encontrado para desfazer!");
        }
    }
}
