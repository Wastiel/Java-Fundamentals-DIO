package Mensageiro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Envio de Mensagens de Marketing ===");
            System.out.println("1. Enviar por SMS");
            System.out.println("2. Enviar por E-mail");
            System.out.println("3. Enviar por Redes Sociais");
            System.out.println("4. Enviar por WhatsApp");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (opcao >= 1 && opcao <= 4) {
                System.out.print("Digite a mensagem de marketing: ");
                String mensagem = scanner.nextLine();

                Mensageiro mensageiro = switch (opcao) {
                    case 1 -> new ServicoSMS();
                    case 2 -> new ServicoEmail();
                    case 3 -> new ServicoRedesSociais();
                    case 4 -> new ServicoWhatsApp();
                    default -> null; // nunca chega aqui
                };

                mensageiro.enviarMensagem(mensagem);

            } else if (opcao == 5) {
                continuar = false;
                System.out.println("Encerrando envio de mensagens...");
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
