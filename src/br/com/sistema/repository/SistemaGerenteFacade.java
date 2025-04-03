package br.com.sistema.repository;

import br.com.sistema.command.*;
import java.util.HashMap;
import java.util.Map;

public class SistemaGerenteFacade {
    private static SistemaGerenteFacade instancia;
    private UsuarioRepository usuarioRepo;
    private PagamentoRepository pagamentoRepo;
    private Map<String, Command> commandMap;
    private AtualizarPagamentoCommand atualizarPagamentoCommand; // para referência no undo
    
    private SistemaGerenteFacade() {
        usuarioRepo = new UsuarioRepository();
        pagamentoRepo = new PagamentoRepository();
        initCommands();
    }

    public static SistemaGerenteFacade getInstance() {
        if (instancia == null) {
            instancia = new SistemaGerenteFacade();
        }
        return instancia;
    }
    
    private void initCommands() {
        commandMap = new HashMap<>();
        commandMap.put("adicionarUsuario", new AdicionarUsuarioCommand(usuarioRepo));
        commandMap.put("bloquearUsuario", new BloquearUsuarioCommand(usuarioRepo));
        commandMap.put("listarUsuarios", new ListarUsuariosCommand(usuarioRepo));
        commandMap.put("adicionarPagamento", new AdicionarPagamentoCommand(pagamentoRepo));
        commandMap.put("aprovarPagamento", new AprovarPagamentoCommand(pagamentoRepo));
        commandMap.put("listarPagamentos", new ListarPagamentosCommand(pagamentoRepo));
        atualizarPagamentoCommand = new AtualizarPagamentoCommand(pagamentoRepo);
        commandMap.put("atualizarPagamento", atualizarPagamentoCommand);
        commandMap.put("undoAtualizacaoPagamento", new UndoAtualizacaoPagamentoCommand(atualizarPagamentoCommand));
    }
    
    public void adicionarUsuario(String login, String senha) {
        Command cmd = commandMap.get("adicionarUsuario");
        cmd.execute(new Object[]{login, senha});
    }
    
    public boolean bloquearUsuario(int id) {
        Command cmd = commandMap.get("bloquearUsuario");
        cmd.execute(new Object[]{id});
        return true;
    }
    
    public void listarUsuarios() {
        Command cmd = commandMap.get("listarUsuarios");
        cmd.execute(null);
    }
    
    public void adicionarPagamento(double valor, String metodo) {
        Command cmd = commandMap.get("adicionarPagamento");
        cmd.execute(new Object[]{valor, metodo});
    }
    
    public boolean aprovarPagamento(int id) {
        Command cmd = commandMap.get("aprovarPagamento");
        cmd.execute(new Object[]{id});
        return true;
    }
    
    public void listarPagamentos() {
        Command cmd = commandMap.get("listarPagamentos");
        cmd.execute(null);
    }
    
    public void atualizarPagamento(int id, double novoValor, String novoMetodo) {
        Command cmd = commandMap.get("atualizarPagamento");
        cmd.execute(new Object[]{id, novoValor, novoMetodo});
    }
    
    public void undoAtualizacaoPagamento() {
        Command cmd = commandMap.get("undoAtualizacaoPagamento");
        cmd.execute(null);
    }
}
package br.com.sistema.repository;

import br.com.sistema.command.*;
import java.util.HashMap;
import java.util.Map;

public class SistemaGerenteFacade {
    private static SistemaGerenteFacade instancia;
    private UsuarioRepository usuarioRepo;
    private PagamentoRepository pagamentoRepo;
    private Map<String, Command> commandMap;
    private AtualizarPagamentoCommand atualizarPagamentoCommand; // para referência no undo
    
    private SistemaGerenteFacade() {
        usuarioRepo = new UsuarioRepository();
        pagamentoRepo = new PagamentoRepository();
        initCommands();
    }

    public static SistemaGerenteFacade getInstance() {
        if (instancia == null) {
            instancia = new SistemaGerenteFacade();
        }
        return instancia;
    }
    
    private void initCommands() {
        commandMap = new HashMap<>();
        commandMap.put("adicionarUsuario", new AdicionarUsuarioCommand(usuarioRepo));
        commandMap.put("bloquearUsuario", new BloquearUsuarioCommand(usuarioRepo));
        commandMap.put("listarUsuarios", new ListarUsuariosCommand(usuarioRepo));
        commandMap.put("adicionarPagamento", new AdicionarPagamentoCommand(pagamentoRepo));
        commandMap.put("aprovarPagamento", new AprovarPagamentoCommand(pagamentoRepo));
        commandMap.put("listarPagamentos", new ListarPagamentosCommand(pagamentoRepo));
        atualizarPagamentoCommand = new AtualizarPagamentoCommand(pagamentoRepo);
        commandMap.put("atualizarPagamento", atualizarPagamentoCommand);
        commandMap.put("undoAtualizacaoPagamento", new UndoAtualizacaoPagamentoCommand(atualizarPagamentoCommand));
    }
    
    public void adicionarUsuario(String login, String senha) {
        Command cmd = commandMap.get("adicionarUsuario");
        cmd.execute(new Object[]{login, senha});
    }
    
    public boolean bloquearUsuario(int id) {
        Command cmd = commandMap.get("bloquearUsuario");
        cmd.execute(new Object[]{id});
        return true;
    }
    
    public void listarUsuarios() {
        Command cmd = commandMap.get("listarUsuarios");
        cmd.execute(null);
    }
    
    public void adicionarPagamento(double valor, String metodo) {
        Command cmd = commandMap.get("adicionarPagamento");
        cmd.execute(new Object[]{valor, metodo});
    }
    
    public boolean aprovarPagamento(int id) {
        Command cmd = commandMap.get("aprovarPagamento");
        cmd.execute(new Object[]{id});
        return true;
    }
    
    public void listarPagamentos() {
        Command cmd = commandMap.get("listarPagamentos");
        cmd.execute(null);
    }
    
    public void atualizarPagamento(int id, double novoValor, String novoMetodo) {
        Command cmd = commandMap.get("atualizarPagamento");
        cmd.execute(new Object[]{id, novoValor, novoMetodo});
    }
    
    public void undoAtualizacaoPagamento() {
        Command cmd = commandMap.get("undoAtualizacaoPagamento");
        cmd.execute(null);
    }
}