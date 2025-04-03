package br.com.sistema.command;

import br.com.sistema.repository.PagamentoRepository;

public class ListarPagamentosCommand implements Command {
    private PagamentoRepository pagamentoRepo;
    
    public ListarPagamentosCommand(PagamentoRepository pagamentoRepo) {
        this.pagamentoRepo = pagamentoRepo;
    }
    
    @Override
    public Object execute(Object arg) {
        pagamentoRepo.listarPagamentos().forEach(System.out::println);
        return null;
    }
    
    @Override
    public void undo() {
        // Não aplicável
    }
}
