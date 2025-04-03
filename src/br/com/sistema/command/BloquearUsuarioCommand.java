package br.com.sistema.command;

import br.com.sistema.repository.UsuarioRepository;

public class BloquearUsuarioCommand implements Command {
    private UsuarioRepository usuarioRepo;
    
    public BloquearUsuarioCommand(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        int id = (Integer) params[0];
        boolean sucesso = usuarioRepo.bloquearUsuario(id);
        if (sucesso) {
            System.out.println("Usuário bloqueado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
        return null;
    }
    
    @Override
    public void undo() {
        // Operação não reversível
    }
}
