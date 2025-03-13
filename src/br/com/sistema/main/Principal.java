package br.com.sistema.main;

import br.com.sistema.repository.UsuarioRepository;
import br.com.sistema.model.Usuario;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        int opcao = 0;
        
        while (opcao != 4) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar Usuário");
            System.out.println("2 - Bloquear Usuário");
            System.out.println("3 - Listar Usuários");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, insira um número.");
                continue;
            }
            
            switch (opcao) {
                case 1:
                    String login = lerLogin(sc);
                    String senha = lerSenha(sc);
                    usuarioRepository.adicionarUsuario(login, senha);
                    System.out.println("Usuário adicionado com sucesso!");
                    break;
                    
                case 2:
                    System.out.print("Digite o ID do usuário a bloquear: ");
                    try {
                        int idBloqueio = Integer.parseInt(sc.nextLine());
                        boolean bloqueado = usuarioRepository.bloquearUsuario(idBloqueio);
                        if (bloqueado) {
                            System.out.println("Usuário bloqueado com sucesso!");
                        } else {
                            System.out.println("Usuário não encontrado!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;
                    
                case 3:
                    List<Usuario> lista = usuarioRepository.listarTodos();
                    if (lista.isEmpty()) {
                        System.out.println("Não há usuários cadastrados.");
                    } else {
                        System.out.println("=== Lista de Usuários ===");
                        for (Usuario u : lista) {
                            System.out.println(u);
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
        
        sc.close();
    }
    
    // Lê e valida o login conforme as regras:
    // Máximo 12 caracteres, não pode ser vazio e não pode conter números.
    private static String lerLogin(Scanner sc) {
        String login;
        while (true) {
            System.out.print("Digite o login (máximo 12 caracteres, sem números): ");
            login = sc.nextLine().trim();
            if (login.isEmpty()) {
                System.out.println("Login não pode ser vazio.");
                continue;
            }
            if (login.length() > 12) {
                System.out.println("Login deve ter no máximo 12 caracteres.");
                continue;
            }
            if (login.matches(".*\\d.*")) {
                System.out.println("Login não pode conter números.");
                continue;
            }
            break;
        }
        return login;
    }
    
    // Lê e valida a senha conforme regras inspiradas na política do AWS IAM:
    // Mínimo 8 caracteres, pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial.
    private static String lerSenha(Scanner sc) {
        String senha;
        while (true) {
            System.out.print("Digite a senha (mínimo 8 caracteres, com pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial): ");
            senha = sc.nextLine().trim();
            if (validarSenha(senha)) {
                break;
            } else {
                System.out.println("Senha inválida. Tente novamente.");
            }
        }
        return senha;
    }
    
    private static boolean validarSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            System.out.println("Senha não pode ser vazia.");
            return false;
        }
        if (senha.length() < 8) {
            System.out.println("Senha deve ter no mínimo 8 caracteres.");
            return false;
        }
        if (!senha.matches(".*[A-Z].*")) {
            System.out.println("Senha deve conter pelo menos uma letra maiúscula.");
            return false;
        }
        if (!senha.matches(".*[a-z].*")) {
            System.out.println("Senha deve conter pelo menos uma letra minúscula.");
            return false;
        }
        if (!senha.matches(".*\\d.*")) {
            System.out.println("Senha deve conter pelo menos um número.");
            return false;
        }
        if (!senha.matches(".*[!@#$%^&*()_+\\-=[\\]{};':\"\\\\|,.<>/?].*")) {
            System.out.println("Senha deve conter pelo menos um caractere especial.");
            return false;
        }
        return true;
    }
}
