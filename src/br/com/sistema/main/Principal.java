// File: src/br/com/sistema/main/Principal.java
package br.com.sistema.main;

import br.com.sistema.repository.SistemaGerenteFacade;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaGerenteFacade sistema = SistemaGerenteFacade.getInstance();
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar Usuário");
            System.out.println("2 - Bloquear Usuário");
            System.out.println("3 - Listar Usuários");
            System.out.println("4 - Adicionar Pagamento");
            System.out.println("5 - Listar Pagamentos");
            System.out.println("6 - Aprovar Pagamento");
            System.out.println("7 - Atualizar Pagamento");
            System.out.println("8 - Desfazer Atualização de Pagamento");
            System.out.println("10 - Calcular Total Composite de Pagamentos");
            System.out.println("9 - Sair");
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
                    sistema.executeCommand("adicionarUsuario", new Object[]{login, senha});
                    break;

                case 2:
                    System.out.print("ID do Usuário para bloquear: ");
                    try {
                        int idBloquear = Integer.parseInt(sc.nextLine());
                        sistema.executeCommand("bloquearUsuario", new Object[]{idBloquear});
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;

                case 3:
                    sistema.executeCommand("listarUsuarios", null);
                    break;

                case 4:
                    try {
                        System.out.print("Valor do pagamento: ");
                        double valor = Double.parseDouble(sc.nextLine());
                        System.out.print("Método de pagamento: ");
                        String metodo = sc.nextLine();
                        sistema.executeCommand("adicionarPagamento", new Object[]{valor, metodo});
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 5:
                    sistema.executeCommand("listarPagamentos", null);
                    break;

                case 6:
                    System.out.print("ID do Pagamento para aprovar: ");
                    try {
                        int idPagamento = Integer.parseInt(sc.nextLine());
                        sistema.executeCommand("aprovarPagamento", new Object[]{idPagamento});
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;
                    
                case 7:
                    System.out.print("ID do Pagamento para atualizar: ");
                    try {
                        int idPagamento = Integer.parseInt(sc.nextLine());
                        System.out.print("Novo valor do pagamento: ");
                        double novoValor = Double.parseDouble(sc.nextLine());
                        System.out.print("Novo método de pagamento: ");
                        String novoMetodo = sc.nextLine();
                        sistema.executeCommand("atualizarPagamento", new Object[]{idPagamento, novoValor, novoMetodo});
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida!");
                    }
                    break;
                    
                case 8:
                    sistema.executeCommand("undoAtualizacaoPagamento", null);
                    break;
                    
                case 10:
                    System.out.print("Informe os IDs dos pagamentos separados por vírgula: ");
                    String input = sc.nextLine();
                    List<Integer> ids = Arrays.stream(input.split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .toList();
                    sistema.executeCommand("calcularTotalPagamento", ids);
                    break;
                    
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
        sc.close();
    }
}
