// File: src/br/com/sistema/command/AdicionarUsuarioCommand.java
package br.com.sistema.command;

import br.com.sistema.repository.SistemaMediator;

public class AdicionarUsuarioCommand implements Command {
    private SistemaMediator mediator;
    
    public AdicionarUsuarioCommand(SistemaMediator mediator) {
        this.mediator = mediator;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        String login = (String) params[0];
        String senha = (String) params[1];
        mediator.adicionarUsuario(login, senha);
        System.out.println("Usuário adicionado com sucesso!");
        return null;
    }
    
    @Override
    public void undo() {
        // Operação não reversível
    }
}
