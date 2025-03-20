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

    @Override
    public String toString() {
        return "Pagamento ID: " + id + " | Valor: R$" + valor + " | Método: " + metodo + " | Aprovado: " + aprovado;
    }
}
