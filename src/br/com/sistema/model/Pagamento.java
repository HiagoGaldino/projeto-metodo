// File: src/br/com/sistema/model/Pagamento.java
package br.com.sistema.model;

import java.io.Serializable;
import br.com.sistema.composite.PagamentoComponente;
import br.com.sistema.flyweight.PaymentMethod;
import br.com.sistema.flyweight.PaymentMethodFactory;

public class Pagamento implements Serializable, PagamentoComponente {
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
