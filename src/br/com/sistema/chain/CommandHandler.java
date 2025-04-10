// File: src/br/com/sistema/chain/CommandHandler.java
package br.com.sistema.chain;

public abstract class CommandHandler {
    protected CommandHandler next;
    public void setNext(CommandHandler next) {
        this.next = next;
    }
    public abstract boolean handle(String command, Object arg);
}
