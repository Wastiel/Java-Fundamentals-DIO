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

                if(!direcao.chaveIgnicao() && opcao !=1){
                    System.out.println("Antes de tentar qualquer coisa, você deve ligar o carro, não?");
                }else {
                    switch (opcao) {
                        case 1 -> {
                            System.out.print("Ligar o Carro: ");
                            direcao.ligarCarro();
                        }
                        case 2 -> direcao.desligarCarro();
                        case 3 -> {
                            System.out.print("Aumentando Marcha ");
                            direcao.trocarMarcha(1);
                        }
                        case 4 -> {
                            System.out.print("Retrocedendo Marcha: ");
                            direcao.trocarMarcha(-1);
                        }
                        case 5 -> {
                            direcao.virar();
                        }
                        case 6 -> {
                            System.out.print("Acelerando: ");
                            direcao.acelerarDesacelerar(1);
                        }
                        case 7 -> {
                            System.out.print("Desacelerando: ");
                            direcao.acelerarDesacelerar(-1);
                        }
                        case 8 -> {
                            direcao.velocimetro();
                        }
                        case 0 -> System.out.println("Fim do programa. Obrigado!");
                        default -> System.out.println("Opçao Inválida. Tente novamente.");
                    }
                }

            } while (opcao != 0);

    }

    public static void exibirMenu() {
        System.out.println("\n - Escolha uma opção:");
        System.out.println("1 - Ligar o caro");
        System.out.println("2 - Desligar o carro");
        System.out.println("3 - Avançar Marcha");
        System.out.println("4 - Retroceder Marcha");
        System.out.println("5 - Mudar direção");
        System.out.println("6 - Acelerar");
        System.out.println("7 - Desacelerar");
        System.out.println("8 - Velocidade");
        System.out.println("0 - Sair");
        System.out.print("Digite a opção Desejada: ");
    }
}




