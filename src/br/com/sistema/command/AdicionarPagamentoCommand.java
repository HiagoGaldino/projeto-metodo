// File: src/br/com/sistema/command/AdicionarPagamentoCommand.java
package br.com.sistema.command;

import br.com.sistema.flyweight.PaymentMethodFactory;
import br.com.sistema.flyweight.PaymentMethod;
import br.com.sistema.repository.SistemaMediator;

public class AdicionarPagamentoCommand implements Command {
    private SistemaMediator mediator;
    
    public AdicionarPagamentoCommand(SistemaMediator mediator) {
        this.mediator = mediator;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        double valor = (Double) params[0];
        String metodoStr = (String) params[1];
        PaymentMethod metodo = PaymentMethodFactory.getPaymentMethod(metodoStr);
        mediator.adicionarPagamento(valor, metodo.getMethod());
        System.out.println("Pagamento registrado com sucesso!");
        return null;
    }
    
    @Override
    public void undo() {
        // Operação não reversível
    }
}
