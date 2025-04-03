package br.com.sistema.repository;

import br.com.sistema.model.Pagamento;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRepository {
    private List<Pagamento> pagamentos;
    private int geradorId;
    private final String ARQUIVO = "pagamentos.bin";

    public PagamentoRepository() {
        pagamentos = new ArrayList<>();
        geradorId = 1;
        carregarPagamentos();
    }

    public void adicionarPagamento(double valor, String metodo) {
        Pagamento pagamento = new Pagamento(geradorId++, valor, metodo);
        pagamentos.add(pagamento);
        salvarPagamentos();
    }

    public boolean aprovarPagamento(int id) {
        for (Pagamento p : pagamentos) {
            if (p.getId() == id) {
                p.aprovar();
                salvarPagamentos();
                return true;
            }
        }
        return false;
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentos;
    }
    
    public Pagamento getPagamentoById(int id) {
        for (Pagamento p : pagamentos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void savePagamentos() {
        salvarPagamentos();
    }

    private void carregarPagamentos() {
        File file = new File(ARQUIVO);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                pagamentos = (List<Pagamento>) ois.readObject();
                if (!pagamentos.isEmpty()) {
                    geradorId = pagamentos.get(pagamentos.size() - 1).getId() + 1;
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao carregar pagamentos: " + e.getMessage());
            }
        }
    }

    private void salvarPagamentos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(pagamentos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar pagamentos: " + e.getMessage());
        }
    }
}
