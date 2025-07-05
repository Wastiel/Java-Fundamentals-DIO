package Geometria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Calculadora de Áreas ===");
            System.out.println("1. Quadrado");
            System.out.println("2. Retângulo");
            System.out.println("3. Círculo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Informe o valor do lado: ");
                    int lado = scanner.nextInt();
                    Square quadrado = new Square(lado);
                    System.out.println("Área do quadrado: " + quadrado.getArea());
                }
                case 2 -> {
                    System.out.print("Informe a base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Informe a altura: ");
                    double altura = scanner.nextDouble();
                    Rectangle retangulo = new Rectangle(altura, base);
                    System.out.println("Área do retângulo: " + retangulo.getArea());
                }
                case 3 -> {
                    System.out.print("Informe o raio: ");
                    double raio = scanner.nextDouble();
                    Circle circulo = new Circle(raio);
                    System.out.println("Área do círculo: " + circulo.getArea());
                }
                case 4 -> {
                    continuar = false;
                    System.out.println("Encerrando...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}