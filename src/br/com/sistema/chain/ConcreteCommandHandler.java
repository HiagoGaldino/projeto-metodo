// File: src/br/com/sistema/chain/ConcreteCommandHandler.java
package br.com.sistema.chain;

import br.com.sistema.command.Command;
import java.util.Map;

public class ConcreteCommandHandler extends CommandHandler {
    private Map<String, Command> commandMap;

    public ConcreteCommandHandler(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    @Override
    public boolean handle(String command, Object arg) {
        if (commandMap.containsKey(command)) {
            commandMap.get(command).execute(arg);
            return true;
        } else if (next != null) {
            return next.handle(command, arg);
        }
        return false;
    }
}
