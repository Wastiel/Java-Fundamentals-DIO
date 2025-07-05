package Tributavel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Cálculo de Tributos ===");
            System.out.println("1. Produto de Alimentação");
            System.out.println("2. Produto de Saúde e Bem-estar");
            System.out.println("3. Produto de Vestuário");
            System.out.println("4. Produto de Cultura");
            System.out.println("5. Sair");
            System.out.print("Escolha o tipo de produto: ");

            int opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 4) {
                System.out.print("Digite o valor do produto: R$ ");
                double valor = scanner.nextDouble();

                Tributavel produto = switch (opcao) {
                    case 1 -> new Alimentacao(valor);
                    case 2 -> new Saude(valor);
                    case 3 -> new Vestuario(valor);
                    case 4 -> new Cultura(valor);
                    default -> null;
                };

                System.out.printf("Imposto a pagar: R$ %.2f\n", produto.calcularImposto());
            } else if (opcao == 5) {
                continuar = false;
                System.out.println("Encerrando cálculo de tributos...");
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
