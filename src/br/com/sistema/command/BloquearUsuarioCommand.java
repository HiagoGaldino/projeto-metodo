// File: src/br/com/sistema/command/BloquearUsuarioCommand.java
package br.com.sistema.command;

import br.com.sistema.repository.SistemaMediator;

public class BloquearUsuarioCommand implements Command {
    private SistemaMediator mediator;
    
    public BloquearUsuarioCommand(SistemaMediator mediator) {
        this.mediator = mediator;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        int id = (Integer) params[0];
        boolean sucesso = mediator.bloquearUsuario(id);
        if (sucesso) {
            System.out.println("Usuário bloqueado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
        return null;
    }
    
    @Override
    public void undo() {
        // Operação não reversível
    }
}
