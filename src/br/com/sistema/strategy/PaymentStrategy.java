package br.com.sistema.strategy;

import br.com.sistema.model.Pagamento;

public interface PaymentStrategy {
    double calculateFee(Pagamento pagamento);
}
