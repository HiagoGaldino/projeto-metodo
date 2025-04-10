// File: src/br/com/sistema/command/UndoAtualizacaoPagamentoCommand.java
package br.com.sistema.command;

public class UndoAtualizacaoPagamentoCommand implements Command {
    private AtualizarPagamentoCommand atualizarCommand;
    
    public UndoAtualizacaoPagamentoCommand(AtualizarPagamentoCommand atualizarCommand) {
        this.atualizarCommand = atualizarCommand;
    }
    
    @Override
    public Object execute(Object arg) {
        atualizarCommand.undo();
        return null;
    }
    
    @Override
    public void undo() {
        // Undo de um undo não é suportado
    }
}
