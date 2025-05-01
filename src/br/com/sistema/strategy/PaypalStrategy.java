package br.com.sistema.strategy;

import br.com.sistema.model.Pagamento;

public class PaypalStrategy implements PaymentStrategy {
    @Override
    public double calculateFee(Pagamento pagamento) {
        // 3% fee + fixed 0.30
        return pagamento.getValor() * 0.03 + 0.30;
    }
}
