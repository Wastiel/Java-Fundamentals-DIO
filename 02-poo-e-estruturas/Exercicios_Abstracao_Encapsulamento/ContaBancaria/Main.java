package ContaBancaria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        var scanner = new Scanner(System.in);
        var caixaEletronico = new CaixaEletronico();
        int opcao = 1;


        do{


            switch (opcao){
                case 1 -> {
                    System.out.println("Criando conta, digite o seu saldo: ");
                            caixaEletronico.criarConta(scanner.nextDouble());
                }
                case 2 -> {
                    caixaEletronico.saldo();
                }
                case 3 -> {
                    System.out.println("Seu cheque especial é: ");
                    caixaEletronico.chequeEmUso();
                }
                case 4 -> {
                    System.out.println("Digite o valor do seu depósito: ");
                    caixaEletronico.depositar(scanner.nextDouble());
                }
                case 5-> {
                    System.out.println("Digite o valor do saque: ");
                    caixaEletronico.sacar(scanner.nextDouble());
                }
                case 6-> {
                    System.out.println("Digite o valor do boleto: ");
                    caixaEletronico.pagarBarra(scanner.nextDouble());
                }
                case 7-> {
                    System.out.println("Seu cheque especial em uso: ");
                    caixaEletronico.chequeEmUso();
                }
            }


            //caixaEletronico.saldo();

            System.out.println("Caixa Eletronico! Escolha uma das opções abaixo: ");
            System.out.println("1 - Criar Conta ");
            System.out.println("2 - Consultar Saldo ");
            System.out.println("3 - Consultar Cheque Especial ");
            System.out.println("4 - Depositar Dinheiro ");
            System.out.println("5 - Sacar Dinheiro ");
            System.out.println("6 - Pagar um boleto");
            System.out.println("0 - Sair do Sistema");

            opcao = scanner.nextInt();

        } while(opcao != 0);
        System.out.println("Fim do Programa!!");

    }


}
