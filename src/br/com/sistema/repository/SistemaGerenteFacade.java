// File: src/br/com/sistema/repository/SistemaGerenteFacade.java
package br.com.sistema.repository;

import br.com.sistema.chain.CommandHandler;
import br.com.sistema.chain.ConcreteCommandHandler;
import br.com.sistema.command.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import br.com.sistema.model.Pagamento;
import br.com.sistema.model.Usuario;

public class SistemaGerenteFacade implements SistemaMediator {
    private static SistemaGerenteFacade instancia;
    private UsuarioRepository usuarioRepo;
    private PagamentoRepository pagamentoRepo;
    private CommandHandler chain;
    
    private SistemaGerenteFacade() {
        usuarioRepo = new UsuarioRepository();
        pagamentoRepo = new PagamentoRepository();
        initChain();
    }

    public static SistemaGerenteFacade getInstance() {
        if (instancia == null) {
            instancia = new SistemaGerenteFacade();
        }
        return instancia;
    }
    
    private void initChain() {
        Map<String, Command> usuarioCommands = new HashMap<>();
        usuarioCommands.put("adicionarUsuario", new AdicionarUsuarioCommand(this));
        usuarioCommands.put("bloquearUsuario", new BloquearUsuarioCommand(this));
        usuarioCommands.put("listarUsuarios", new ListarUsuariosCommand(this));
        
        Map<String, Command> pagamentoCommands = new HashMap<>();
        pagamentoCommands.put("adicionarPagamento", new AdicionarPagamentoCommand(this));
        pagamentoCommands.put("aprovarPagamento", new AprovarPagamentoCommand(this));
        pagamentoCommands.put("listarPagamentos", new ListarPagamentosCommand(this));
        AtualizarPagamentoCommand atualizarCommand = new AtualizarPagamentoCommand(this);
        pagamentoCommands.put("atualizarPagamento", atualizarCommand);
        pagamentoCommands.put("undoAtualizacaoPagamento", new UndoAtualizacaoPagamentoCommand(atualizarCommand));
        pagamentoCommands.put("calcularTotalPagamento", new CalcularTotalPagamentoCompositeCommand(this));
        
        ConcreteCommandHandler usuarioHandler = new ConcreteCommandHandler(usuarioCommands);
        ConcreteCommandHandler pagamentoHandler = new ConcreteCommandHandler(pagamentoCommands);
        usuarioHandler.setNext(pagamentoHandler);
        chain = usuarioHandler;
    }
    
    public void executeCommand(String command, Object arg) {
        if (!chain.handle(command, arg)) {
            System.out.println("Comando não encontrado!");
        }
    }

    @Override
    public void adicionarUsuario(String login, String senha) {
        usuarioRepo.adicionarUsuario(login, senha);
    }
    
    @Override
    public boolean bloquearUsuario(int id) {
        return usuarioRepo.bloquearUsuario(id);
    }
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.listarTodos();
    }
    
    @Override
    public void adicionarPagamento(double valor, String metodo) {
        pagamentoRepo.adicionarPagamento(valor, metodo);
    }
    
    @Override
    public boolean aprovarPagamento(int id) {
        return pagamentoRepo.aprovarPagamento(id);
    }
    
    @Override
    public List<Pagamento> listarPagamentos() {
        return pagamentoRepo.listarPagamentos();
    }
    
    @Override
    public Pagamento getPagamentoById(int id) {
        return pagamentoRepo.getPagamentoById(id);
    }
    
    @Override
    public void salvarPagamentos() {
        pagamentoRepo.savePagamentos();
    }
}
