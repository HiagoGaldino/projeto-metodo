package br.com.sistema.repository;

import br.com.sistema.model.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private List<Usuario> usuarios;
    private int geradorId;
    private final String ARQUIVO = "usuarios.bin";

    public UsuarioRepository() {
        usuarios = new ArrayList<>();
        geradorId = 1;
        carregarUsuarios();
    }

    public void adicionarUsuario(String login, String senha) {
        Usuario novoUsuario = new Usuario(geradorId, login, senha);
        usuarios.add(novoUsuario);
        geradorId++;
        salvarUsuarios();
    }

    public boolean bloquearUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.setBloqueado(true);
                salvarUsuarios();
                return true;
            }
        }
        return false;
    }

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    private void carregarUsuarios() {
        File file = new File(ARQUIVO);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                usuarios = (List<Usuario>) ois.readObject();
                if (usuarios != null && !usuarios.isEmpty()) {
                    // Atualiza geradorId com base no maior id encontrado
                    int maxId = 0;
                    for (Usuario u : usuarios) {
                        if (u.getId() > maxId) {
                            maxId = u.getId();
                        }
                    }
                    geradorId = maxId + 1;
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao carregar os usuários: " + e.getMessage());
            }
        }
    }

    private void salvarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os usuários: " + e.getMessage());
        }
    }
}
