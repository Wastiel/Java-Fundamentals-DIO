package Carro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Direcao direcao = new Direcao();

        direcao.criarrCarro();

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("O carro foi ligado: ");
                    direcao.ligarCarro();
                }
                case 2 -> direcao.desligarCarro();
                case 3 -> {
                    System.out.print("Digite 1 para subir marcha -1 para baixar marcha: ");
                    direcao.trocarMarcha(scanner.nextInt());
                }
                case 4 -> {
                    direcao.virar();
                }
                case 5 -> {
                    System.out.print("Deseja acelerar o carro? ");
                }
                case 6 -> {
                    System.out.print("Informe o valor do boleto: ");
                }
                case 0 -> System.out.println("Fim do programa. Obrigado!");
                default -> System.out.println("Opçao Inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    public static void exibirMenu() {
        System.out.println("\n Carro ligado - Escolha uma op??o:");
        System.out.println("1 - Ligar o carr");
        System.out.println("2 - Desligar o carro");
        System.out.println("3 - Trocar Marcha");
        System.out.println("4 - Mudar direção");
        System.out.println("5 - Acelerar");
        System.out.println("6 - Pagar Boleto");
        System.out.println("0 - Sair");
        System.out.print("Op??o: ");
    }
}




