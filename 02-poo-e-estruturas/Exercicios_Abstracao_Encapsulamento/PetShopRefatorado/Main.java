package PetShopRefatorado;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaBanho maquina = new MaquinaBanho();
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    if (!maquina.isEmUso()) {
                        System.out.println("Nenhum pet está na máquina.");
                    } else if (maquina.darBanho()) {
                        System.out.println("Banho realizado com sucesso em " + maquina.getPet() + ".");
                    } else {
                        System.out.println("Não há produtos suficientes para o banho.");
                    }
                }
                case 2 -> {
                    if (maquina.abastecerAgua()) {
                        System.out.println("Água abastecida. Nível atual: " + maquina.getAgua() + "L");
                    } else {
                        System.out.println("A máquina já está com o nível máximo de água.");
                    }
                }
                case 3 -> {
                    if (maquina.abastecerShampoo()) {
                        System.out.println("Shampoo abastecido. Nível atual: " + maquina.getShampoo() + "L");
                    } else {
                        System.out.println("A máquina já está com o nível máximo de shampoo.");
                    }
                }
                case 4 -> System.out.println("Nível de shampoo: " + maquina.getShampoo() + "L");
                case 5 -> System.out.println("Nível de água: " + maquina.getAgua() + "L");
                case 6 -> System.out.println(maquina.isEmUso() ? "Há um pet na máquina." : "A máquina está vazia.");
                case 7 -> {
                    if (maquina.isEmUso()) {
                        System.out.println("Já há um pet na máquina.");
                    } else if (maquina.isSuja()) {
                        System.out.println("A máquina precisa ser limpa antes de colocar outro pet.");
                    } else {
                        System.out.print("Nome do pet: ");
                        String nome = scanner.nextLine();
                        System.out.print("Raça do pet: ");
                        String raca = scanner.nextLine();
                        if (maquina.colocarPet(new Pet(nome, raca))) {
                            System.out.println("Pet colocado na máquina com sucesso.");
                        } else {
                            System.out.println("Erro ao colocar pet na máquina.");
                        }
                    }
                }
                case 8 -> {
                    if (maquina.retirarPet()) {
                        System.out.println("Pet retirado da máquina.");
                    } else {
                        System.out.println("Não há pet para retirar.");
                    }
                }
                case 9 -> {
                    if (maquina.limparMaquina()) {
                        System.out.println("Máquina limpa com sucesso.");
                    } else {
                        System.out.println("Falta água ou shampoo para limpeza.");
                    }
                }
                case 0 -> System.out.println("Programa encerrado.");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Limpa PET ---");
        System.out.println("1 - Dar banho no pet");
        System.out.println("2 - Abastecer com água");
        System.out.println("3 - Abastecer com shampoo");
        System.out.println("4 - Verificar nível de shampoo");
        System.out.println("5 - Verificar nível de água");
        System.out.println("6 - Verificar se há pet na máquina");
        System.out.println("7 - Colocar pet na máquina");
        System.out.println("8 - Retirar pet da máquina");
        System.out.println("9 - Limpar máquina");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }
}
