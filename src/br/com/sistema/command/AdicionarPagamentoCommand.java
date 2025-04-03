package br.com.sistema.command;

import br.com.sistema.repository.PagamentoRepository;

public class AdicionarPagamentoCommand implements Command {
    private PagamentoRepository pagamentoRepo;
    
    public AdicionarPagamentoCommand(PagamentoRepository pagamentoRepo) {
        this.pagamentoRepo = pagamentoRepo;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        double valor = (Double) params[0];
        String metodo = (String) params[1];
        pagamentoRepo.adicionarPagamento(valor, metodo);
        System.out.println("Pagamento registrado com sucesso!");
        return null;
    }
    
    @Override
    public void undo() {
        // Operação não reversível
    }
}