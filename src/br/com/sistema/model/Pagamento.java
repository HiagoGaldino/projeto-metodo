// File: src/br/com/sistema/model/Pagamento.java
package br.com.sistema.model;
import br.com.sistema.state.PaymentState;
import br.com.sistema.strategy.PaymentStrategy;

import java.io.Serializable;
import br.com.sistema.composite.PagamentoComponente;
import br.com.sistema.flyweight.PaymentMethod;
import br.com.sistema.flyweight.PaymentMethodFactory;

public class Pagamento implements Serializable, PagamentoComponente {

    // State and Strategy pattern fields
    private br.com.sistema.state.PaymentState state;
    private br.com.sistema.strategy.PaymentStrategy strategy;

    public void setState(br.com.sistema.state.PaymentState state) {
        this.state = state;
    }

    public void processState() {
        if (state != null) state.handle(this);
    }

    public void setStrategy(br.com.sistema.strategy.PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFee() {
        return strategy != null ? strategy.calculateFee(this) : 0;
    }
    private static final long serialVersionUID = 1L;
    private int id;
    private double valor;
    private PaymentMethod metodo;
    private boolean aprovado;

    public Pagamento(int id, double valor, String metodo) {
        this.id = id;
        this.valor = valor;
        this.metodo = PaymentMethodFactory.getPaymentMethod(metodo);
        this.aprovado = false;
    }

    public int getId() { return id; }
    public double getValor() { return valor; }
    public PaymentMethod getMetodo() { return metodo; }
    public boolean isAprovado() { return aprovado; }

    public void aprovar() { this.aprovado = true; }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void setMetodo(String metodo) {
        this.metodo = PaymentMethodFactory.getPaymentMethod(metodo);
    }
    
    public PaymentMemento createMemento() {
        return new PaymentMemento(this.valor, this.metodo.getMethod());
    }
    
    public void restoreMemento(PaymentMemento memento) {
        this.valor = memento.getValor();
        this.metodo = PaymentMethodFactory.getPaymentMethod(memento.getMetodo());
    }

    @Override
    public String toString() {
        return "Pagamento ID: " + id + " | Valor: R$" + valor + " | Método: " + metodo + " | Aprovado: " + aprovado;
    }
    
    @Override
    public double getValorTotal() {
        return this.valor;
    }
}
