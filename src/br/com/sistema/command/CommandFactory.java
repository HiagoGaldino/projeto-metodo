package br.com.sistema.factory;

import br.com.sistema.command.*;
import br.com.sistema.repository.SistemaMediator;

import java.util.Map;

public class CommandFactory {

    private SistemaMediator mediator;

    public CommandFactory(SistemaMediator mediator) {
        this.mediator = mediator;
    }

    public Command createCommand(String commandName, Object arg) {
        switch (commandName) {
            case "adicionarUsuario":
                return new AdicionarUsuarioCommand(mediator);
            case "bloquearUsuario":
                return new BloquearUsuarioCommand(mediator);
            case "listarUsuarios":
                return new ListarUsuariosCommand(mediator);
            case "adicionarPagamento":
                return new AdicionarPagamentoCommand(mediator);
            case "listarPagamentos":
                return new ListarPagamentosCommand(mediator);
            case "aprovarPagamento":
                return new AprovarPagamentoCommand(mediator);
            case "atualizarPagamento":
                return new AtualizarPagamentoCommand(mediator);
            case "undoAtualizacaoPagamento":
                return new UndoAtualizacaoPagamentoCommand(new AtualizarPagamentoCommand(mediator));
            case "calcularTotalPagamento":
                return new CalcularTotalPagamentoCompositeCommand(mediator);
            default:
                throw new IllegalArgumentException("Comando não reconhecido: " + commandName);
        }
    }
}
