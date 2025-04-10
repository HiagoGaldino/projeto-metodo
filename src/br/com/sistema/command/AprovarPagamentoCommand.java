// File: src/br/com/sistema/command/AprovarPagamentoCommand.java
package br.com.sistema.command;

import br.com.sistema.repository.SistemaMediator;

public class AprovarPagamentoCommand implements Command {
    private SistemaMediator mediator;
    
    public AprovarPagamentoCommand(SistemaMediator mediator) {
        this.mediator = mediator;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        int id = (Integer) params[0];
        boolean sucesso = mediator.aprovarPagamento(id);
        if (sucesso) {
            System.out.println("Pagamento aprovado com sucesso!");
        } else {
            System.out.println("Pagamento não encontrado!");
        }
        return null;
    }
    
    @Override
    public void undo() {
        // Operação não reversível
    }
}
