// File: src/br/com/sistema/repository/SistemaMediator.java
package br.com.sistema.repository;

import br.com.sistema.model.Pagamento;
import br.com.sistema.model.Usuario;
import java.util.List;

public interface SistemaMediator {
    void adicionarUsuario(String login, String senha);
    boolean bloquearUsuario(int id);
    List<Usuario> listarUsuarios();
    void adicionarPagamento(double valor, String metodo);
    boolean aprovarPagamento(int id);
    List<Pagamento> listarPagamentos();
    Pagamento getPagamentoById(int id);
    void salvarPagamentos();
}
