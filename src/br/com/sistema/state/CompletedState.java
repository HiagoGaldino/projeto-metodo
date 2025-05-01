package br.com.sistema.state;

import br.com.sistema.model.Pagamento;

public class CompletedState implements PaymentState {
    @Override
    public void handle(Pagamento pagamento) {
        // Logic for completed payment
        System.out.println("Payment already completed: " + pagamento.getId());
    }
}
