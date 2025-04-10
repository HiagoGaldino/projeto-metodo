// File: src/br/com/sistema/command/ListarPagamentosCommand.java
package br.com.sistema.command;

import br.com.sistema.repository.SistemaMediator;

public class ListarPagamentosCommand implements Command {
    private SistemaMediator mediator;
    
    public ListarPagamentosCommand(SistemaMediator mediator) {
        this.mediator = mediator;
    }
    
    @Override
    public Object execute(Object arg) {
        mediator.listarPagamentos().forEach(System.out::println);
        return null;
    }
    
    @Override
    public void undo() {
        // Não aplicável
    }
}
