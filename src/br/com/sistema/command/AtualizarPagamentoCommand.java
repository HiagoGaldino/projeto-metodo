package br.com.sistema.command;

import br.com.sistema.model.Pagamento;
import br.com.sistema.model.PaymentMemento;
import br.com.sistema.repository.PagamentoRepository;

public class AtualizarPagamentoCommand implements Command {
    private PagamentoRepository pagamentoRepo;
    private PaymentMemento lastMemento;
    private int lastPagamentoId;
    private boolean executed = false;
    
    public AtualizarPagamentoCommand(PagamentoRepository pagamentoRepo) {
        this.pagamentoRepo = pagamentoRepo;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        int id = (Integer) params[0];
        double novoValor = (Double) params[1];
        String novoMetodo = (String) params[2];
        
        Pagamento pagamento = pagamentoRepo.getPagamentoById(id);
        if (pagamento == null) {
            System.out.println("Pagamento não encontrado!");
            return null;
        }
        // Salva o estado atual via Memento
        lastMemento = pagamento.createMemento();
        lastPagamentoId = id;
        executed = true;
        
        // Aplica a atualização
        pagamento.setValor(novoValor);
        pagamento.setMetodo(novoMetodo);
        pagamentoRepo.savePagamentos();
        System.out.println("Pagamento atualizado com sucesso!");
        return pagamento;
    }
    
    @Override
    public void undo() {
        if (!executed || lastMemento == null) {
            System.out.println("Nenhuma atualização para desfazer!");
            return;
        }
        Pagamento pagamento = pagamentoRepo.getPagamentoById(lastPagamentoId);
        if (pagamento != null) {
            pagamento.restoreMemento(lastMemento);
            pagamentoRepo.savePagamentos();
            System.out.println("Atualização desfeita com sucesso!");
            executed = false;
            lastMemento = null;
        } else {
            System.out.println("Pagamento não encontrado para desfazer!");
        }
    }
}
