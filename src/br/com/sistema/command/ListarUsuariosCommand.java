// File: src/br/com/sistema/command/ListarUsuariosCommand.java
package br.com.sistema.command;

import br.com.sistema.repository.SistemaMediator;

public class ListarUsuariosCommand implements Command {
    private SistemaMediator mediator;
    
    public ListarUsuariosCommand(SistemaMediator mediator) {
        this.mediator = mediator;
    }
    
    @Override
    public Object execute(Object arg) {
        mediator.listarUsuarios().forEach(System.out::println);
        return null;
    }
    
    @Override
    public void undo() {
        // Não aplicável
    }
}
