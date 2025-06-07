package ContaBancaria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaixaEletronico caixa = new CaixaEletronico();
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Informe o valor inicial para criar a conta: ");
                    caixa.criarConta(scanner.nextDouble());
                }
                case 2 -> caixa.exibirSaldo();
                case 3 -> caixa.exibirChequeEspecial();
                case 4 -> {
                    System.out.print("Informe o valor para depósito: ");
                    caixa.depositar(scanner.nextDouble());
                }
                case 5 -> {
                    System.out.print("Informe o valor para saque: ");
                    caixa.sacar(scanner.nextDouble());
                }
                case 6 -> {
                    System.out.print("Informe o valor do boleto: ");
                    caixa.pagarBoleto(scanner.nextDouble());
                }
                case 0 -> System.out.println("Fim do programa. Obrigado!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    public static void exibirMenu() {
        System.out.println("\nCaixa Eletrônico - Escolha uma opção:");
        System.out.println("1 - Criar Conta");
        System.out.println("2 - Consultar Saldo");
        System.out.println("3 - Consultar Cheque Especial");
        System.out.println("4 - Depositar Dinheiro");
        System.out.println("5 - Sacar Dinheiro");
        System.out.println("6 - Pagar Boleto");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }
}
