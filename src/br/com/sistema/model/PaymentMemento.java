package br.com.sistema.model;

public class PaymentMemento {
    private double valor;
    private String metodo;

    public PaymentMemento(double valor, String metodo) {
        this.valor = valor;
        this.metodo = metodo;
    }

    public double getValor() {
        return valor;
    }

    public String getMetodo() {
        return metodo;
    }
}