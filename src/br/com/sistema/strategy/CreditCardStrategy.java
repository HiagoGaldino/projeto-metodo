package br.com.sistema.strategy;

import br.com.sistema.model.Pagamento;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public double calculateFee(Pagamento pagamento) {
        // 2% fee for credit card
        return pagamento.getValor() * 0.02;
    }
}
