package br.com.sistema.state;

import br.com.sistema.model.Pagamento;

public interface PaymentState {
    void handle(Pagamento pagamento);
}
