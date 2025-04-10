// File: src/br/com/sistema/flyweight/PaymentMethodFactory.java
package br.com.sistema.flyweight;

import java.util.HashMap;
import java.util.Map;

public class PaymentMethodFactory {
    private static Map<String, PaymentMethod> pool = new HashMap<>();

    public static PaymentMethod getPaymentMethod(String method) {
        if (!pool.containsKey(method)) {
            pool.put(method, new PaymentMethod(method));
        }
        return pool.get(method);
    }
}
