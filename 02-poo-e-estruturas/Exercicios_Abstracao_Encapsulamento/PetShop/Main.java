package PetShop;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MaquinaBanho maquinaBanho = new MaquinaBanho();
        String pet;
        String raca;
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    if(!maquinaBanho.isEmUso()){
                        System.out.print("A maquina nãp possui nem um pet: ");
                    }else if (maquinaBanho.darBanho()){
                        System.out.print("Pet limpo com sucesso: ");
                    } else {
                        System.out.print("N?o ha produtos suficientes na maquina para limpeza do pet: ");
                    }
                }
                case 2 -> {
                    maquinaBanho.abastecerAgua();
                    System.out.print("Maquina abastecida com sucesso. Quantidade de agua: " + maquinaBanho.getAgua());
                }
                case 3 -> {
                    maquinaBanho.abastecerShampoo();
                    System.out.print("Maquina abastecida com sucesso. Quantidade de shampoo: " + maquinaBanho.getShampoo());
                }
                case 4 -> System.out.print("O nível do shampoo ?: " + maquinaBanho.getShampoo());
                case 5 -> System.out.print("O nível da agua ?: " + maquinaBanho.getAgua());
                case 6 -> {
                    if(maquinaBanho.isEmUso()){
                        System.out.print("A maquina está ocupada: ");
                    }else{
                        System.out.print("A maquina está livre: ");
                    }
                }
                case 7 -> {
                    if(maquinaBanho.isUtilizada()){
                        System.out.print("A maquina tem que ser limpa antes do proximo uso. ");
                    }else if(!maquinaBanho.isEmUso()){
                        System.out.print("Informe o nome do pet: ");
                        pet = scanner.next();
                        System.out.print("Informe a raça: ");
                        raca = scanner.next();
                        if (maquinaBanho.colocarPet(pet, raca))
                        {
                            System.out.print("O pet foi inserido na maquina ");
                        }
                    }else{
                        System.out.print("A maquina está em uso ");
                    }
                }
                case 8 -> {
                    if(maquinaBanho.isEmUso()){
                        maquinaBanho.retirarMaquina();
                        System.out.print("Pat retirado com sucesso: ");
                    }else{
                        System.out.print("A maquina nãp possui nem um pet: ");
                    }
                }
                case 9 -> {
                    if(maquinaBanho.limparMaquina()){
                        System.out.println("Maquina limpa com sucesso");
                    }else{
                        System.out.println("Faltam produtos para realizar a limpeza");
                    }
                }
                case 0 -> System.out.println("Fim do programa. Obrigado!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

    }

    public static void exibirMenu() {
        System.out.println("\nBem vindo ao Limpa PET!! - Escolha a sua opção:");
        System.out.println("1 - Dar banno no pet.");
        System.out.println("2 - Abastecer com água.");
        System.out.println("3 - Abastecer com shampoo.");
        System.out.println("4 - verificar nível de shampoo.");
        System.out.println("5 - verificar nível de agua.");
        System.out.println("6 - verificar se tem pet no banho.");
        System.out.println("7 - colocar pet na maquina.");
        System.out.println("8 - retirar pet da m?quina.");
        System.out.println("9 - limpar maquina.");
        System.out.println("0 - Sair.");
        System.out.print("Opção: ");

    }
}
