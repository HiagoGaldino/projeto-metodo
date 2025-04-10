// File: src/br/com/sistema/flyweight/PaymentMethod.java
package br.com.sistema.flyweight;

public class PaymentMethod {
    private String method;
    public PaymentMethod(String method) {
        this.method = method;
    }
    public String getMethod() {
        return method;
    }
    @Override
    public String toString() {
        return method;
    }
    public static PaymentMethod of(String method) {
        return PaymentMethodFactory.getPaymentMethod(method);
    }
}
