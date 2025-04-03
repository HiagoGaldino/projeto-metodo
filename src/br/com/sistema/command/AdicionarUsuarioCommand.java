package br.com.sistema.command;

import br.com.sistema.repository.UsuarioRepository;

public class AdicionarUsuarioCommand implements Command {
    private UsuarioRepository usuarioRepo;
    
    public AdicionarUsuarioCommand(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }
    
    @Override
    public Object execute(Object arg) {
        Object[] params = (Object[]) arg;
        String login = (String) params[0];
        String senha = (String) params[1];
        usuarioRepo.adicionarUsuario(login, senha);
        System.out.println("Usuário adicionado com sucesso!");
        return null;
    }
    
    @Override
    public void undo() {
        // Operação não reversível
    }
}
