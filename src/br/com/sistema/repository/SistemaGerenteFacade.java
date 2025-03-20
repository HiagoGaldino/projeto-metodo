package br.com.sistema.repository;

public class SistemaGerenteFacade {
    private static SistemaGerenteFacade instancia;
    private UsuarioRepository usuarioRepo;
    private PagamentoRepository pagamentoRepo;

    private SistemaGerenteFacade() {
        usuarioRepo = new UsuarioRepository();
        pagamentoRepo = new PagamentoRepository();
    }

    public static SistemaGerenteFacade getInstance() {
        if (instancia == null) {
            instancia = new SistemaGerenteFacade();
        }
        return instancia;
    }

    // CRUD de usuário
    public void adicionarUsuario(String login, String senha) {
        usuarioRepo.adicionarUsuario(login, senha);
    }

    public boolean bloquearUsuario(int id) {
        return usuarioRepo.bloquearUsuario(id);
    }

    public void listarUsuarios() {
        usuarioRepo.listarTodos().forEach(System.out::println);
    }

    // CRUD de pagamento
    public void adicionarPagamento(double valor, String metodo) {
        pagamentoRepo.adicionarPagamento(valor, metodo);
    }

    public boolean aprovarPagamento(int id) {
        return pagamentoRepo.aprovarPagamento(id);
    }

    public void listarPagamentos() {
        pagamentoRepo.listarPagamentos().forEach(System.out::println);
    }
}
