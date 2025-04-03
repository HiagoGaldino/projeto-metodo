package br.com.sistema.model;

import java.io.Serializable;

public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private double valor;
    private String metodo;
    private boolean aprovado;

    public Pagamento(int id, double valor, String metodo) {
        this.id = id;
        this.valor = valor;
        this.metodo = metodo;
        this.aprovado = false;
    }

    public int getId() { return id; }
    public double getValor() { return valor; }
    public String getMetodo() { return metodo; }
    public boolean isAprovado() { return aprovado; }

    public void aprovar() { this.aprovado = true; }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    
    public PaymentMemento createMemento() {
        return new PaymentMemento(this.valor, this.metodo);
    }
    
    public void restoreMemento(PaymentMemento memento) {
        this.valor = memento.getValor();
        this.metodo = memento.getMetodo();
    }

    @Override
    public String toString() {
        return "Pagamento ID: " + id + " | Valor: R$" + valor + " | Método: " + metodo + " | Aprovado: " + aprovado;
    }
}
