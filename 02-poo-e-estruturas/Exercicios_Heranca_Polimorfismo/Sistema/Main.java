package Sistema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando usuários
        Gerente gerente = new Gerente("Ana", "ana@empresa.com", "123");
        Vendedor vendedor = new Vendedor("Carlos", "carlos@empresa.com", "abc");
        Atendente atendente = new Atendente("Bruna", "bruna@empresa.com", "xyz");

        Pessoa usuarioLogado = null;

        while (true) {
            System.out.println("\n--- Sistema ---");
            System.out.println("1. Login");
            System.out.println("2. Logoff");
            System.out.println("3. Ações disponíveis");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    if (gerente.login(email, senha)) {
                        usuarioLogado = gerente;
                        System.out.println("Login como gerente.");
                    } else if (vendedor.login(email, senha)) {
                        usuarioLogado = vendedor;
                        System.out.println("Login como vendedor.");
                    } else if (atendente.login(email, senha)) {
                        usuarioLogado = atendente;
                        System.out.println("Login como atendente.");
                    } else {
                        System.out.println("Credenciais inválidas.");
                    }
                    break;

                case 2:
                    if (usuarioLogado != null) {
                        usuarioLogado.logoff();
                        System.out.println("Deslogado com sucesso.");
                        usuarioLogado = null;
                    } else {
                        System.out.println("Nenhum usuário logado.");
                    }
                    break;

                case 3:
                    if (usuarioLogado == null) {
                        System.out.println("Faça login primeiro.");
                        break;
                    }

                    if (usuarioLogado instanceof Gerente) {
                        Gerente g = (Gerente) usuarioLogado;
                        System.out.println("1. Gerar relatório financeiro");
                        System.out.println("2. Consultar vendas");
                        int escolha = sc.nextInt();
                        if (escolha == 1) g.gerarRelatorioFinanceiro();
                        else g.consultarVendas();

                    } else if (usuarioLogado instanceof Vendedor) {
                        Vendedor v = (Vendedor) usuarioLogado;
                        System.out.println("1. Realizar venda");
                        System.out.println("2. Consultar vendas");
                        int escolha = sc.nextInt();
                        if (escolha == 1) v.realizarVenda();
                        else v.consultarVendas();

                    } else if (usuarioLogado instanceof Atendente) {
                        Atendente a = (Atendente) usuarioLogado;
                        System.out.println("1. Receber pagamento");
                        System.out.println("2. Fechar caixa");
                        int escolha = sc.nextInt();
                        if (escolha == 1) {
                            System.out.print("Valor: ");
                            double valor = sc.nextDouble();
                            a.receberPagamento(valor);
                        } else {
                            a.fecharCaixa();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando sistema.");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
