package br.com.sistema.command;

import br.com.sistema.repository.UsuarioRepository;

public class ListarUsuariosCommand implements Command {
    private UsuarioRepository usuarioRepo;
    
    public ListarUsuariosCommand(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }
    
    @Override
    public Object execute(Object arg) {
        usuarioRepo.listarTodos().forEach(System.out::println);
        return null;
    }
    
    @Override
    public void undo() {
        // Não aplicável
    }
}
