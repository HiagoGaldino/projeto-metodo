package br.com.sistema.main;

import br.com.sistema.repository.SistemaGerenteFacade;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaGerenteFacade sistema = SistemaGerenteFacade.getInstance();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar Usuário");
            System.out.println("2 - Bloquear Usuário");
            System.out.println("3 - Listar Usuários");
            System.out.println("4 - Adicionar Pagamento");
            System.out.println("5 - Listar Pagamentos");
            System.out.println("6 - Aprovar Pagamento");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, insira um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Login: ");
                    String login = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    sistema.adicionarUsuario(login, senha);
                    System.out.println("Usuário adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("ID do Usuário para bloquear: ");
                    try {
                        int idBloquear = Integer.parseInt(sc.nextLine());
                        if (sistema.bloquearUsuario(idBloquear)) {
                            System.out.println("Usuário bloqueado com sucesso!");
                        } else {
                            System.out.println("Usuário não encontrado!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;

                case 3:
                    System.out.println("=== Lista de Usuários ===");
                    sistema.listarUsuarios();
                    break;

                case 4:
                    try {
                        System.out.print("Valor do pagamento: ");
                        double valor = Double.parseDouble(sc.nextLine());
                        System.out.print("Método de pagamento: ");
                        String metodo = sc.nextLine();
                        sistema.adicionarPagamento(valor, metodo);
                        System.out.println("Pagamento registrado com sucesso!");
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 5:
                    System.out.println("=== Lista de Pagamentos ===");
                    sistema.listarPagamentos();
                    break;

                case 6:
                    System.out.print("ID do Pagamento para aprovar: ");
                    try {
                        int idPagamento = Integer.parseInt(sc.nextLine());
                        if (sistema.aprovarPagamento(idPagamento)) {
                            System.out.println("Pagamento aprovado com sucesso!");
                        } else {
                            System.out.println("Pagamento não encontrado!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;

                case 7:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
        sc.close();
    }
}
