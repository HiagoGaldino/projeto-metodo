package br.com.sistema.command;

import br.com.sistema.repository.PagamentoRepository;

public class AprovarPagamentoCommand implements Command {
    private PagamentoRepository pagamentoRepo;
    
    public AprovarPagamentoCommand(PagamentoRepository pagamentoRepo) {
        this.pagamentoRepo = pagamentoRepo;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        int id = (Integer) params[0];
        boolean sucesso = pagamentoRepo.aprovarPagamento(id);
        if (sucesso) {
            System.out.println("Pagamento aprovado com sucesso!");
        } else {
            System.out.println("Pagamento não encontrado!");
        }
        return null;
    }
    
    @Override
    public void undo() {
        // Operação não reversível
    }
}
