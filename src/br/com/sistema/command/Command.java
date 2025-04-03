package br.com.sistema.command;

public interface Command {
    Object execute(Object arg);
    void undo();
}