package br.com.sistema.state;

import br.com.sistema.model.Pagamento;

public class PendingState implements PaymentState {
    @Override
    public void handle(Pagamento pagamento) {
        // Logic for pending payment
        System.out.println("Payment in pending state for: " + pagamento.getId());
        pagamento.setState(new CompletedState());
    }
}
