# Fundamentos da Linguagem de Programação Java

## Padrões de desenvolvimento e conceitos

- No java se trabalha com o padrão de Maiuscola as primeiras letras de palavras, como o exemplo abaixo:
    - MyClass
- Nome de metodos, seguimos o primeiro nome todo minuscolo e os demais com a primeira letra do nome maiuscola:
    - mainMatodo
- Java não tem problema a tabs ou identação. Mas sempre devemos manter a identação no melhor fluxo.
- Importe, é um recurso que utilizamos outro package dentro da nossa classe.
    ```java
    import java.util.Scanner;

        public class VariaveisComentariosPackages {

            public static void main(String[] args) {
                Scanner scanner;
                
            }
        }
    ```
    - Nao é recomendado realizar importes de packages com *, para evitar importação desnecessária
- Se criarmos um package, semrpe colocamos a nomenclatura contraria:
    - br.com.dio
- Comentario seguimos os dois padrões:]
    ```java
     // comentario de uma linha
        
        /* Comentario em bloco
        * 
        * 
        * */
    ```
- Escrevendo um programa simples em java, com captura de valores
    ```java
    import java.util.Scanner;

        public class VariaveisComentariosPackages {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                //println quebra a linha após o texto
                System.out.println("Olá, informe o seu nome: ");
                //Capturamos o nome digitado
                String name = scanner.next();
                System.out.println("Olá, informe o sua idade: ");
                //Capturamos a idade digitada
                int age = scanner.nextInt();
                //Escrevemos com concatençaõ
                System.out.println("Olá " + name
                        + " sua idade é: " + age);
                //Escrevemos com parametros
                System.out.printf("Olá %s sua idade é: %s  ", name, age);
            }
        }

    ```
- O java é de tipagem estática e forte, você nao consegue mudar a tipagem.
    ```java
    import java.util.Scanner;

        public class VariaveisComentariosPackages {

            public static void main(String[] args) {
                var scanner = new Scanner(System.in);
                //println quebra a linha após o texto
                System.out.println("Olá, informe o seu nome: ");
                //Capturamos o nome digitado
                var name = scanner.next();
                System.out.println("Olá, informe o sua idade: ");
                //Capturamos a idade digitada
                var age = scanner.nextInt();
                //Escrevemos com concatençaõ
                System.out.println("Olá " + name
                        + " sua idade é: " + age);
                //Escrevemos com parametros
                System.out.printf("Olá %s sua idade é: %s  ", name, age);
            }
        }

    ```
- Java é case sensitive, diferencia maiuscolo de minuscolo
- Constantes no java são variaveis que não mudam de acordo com o decorrer do programa:
    ```java
        import java.util.Scanner;

            public class VariaveisComentariosPackages {

                private final static String WELCOME_MESSAGE = "Olá, informe o seu nome";
                private final static String AGE_MESSAGE = "Olá, informe o sua idade: ";

                public static void main(String[] args) {
                    var scanner = new Scanner(System.in);
                    //println quebra a linha após o texto
                    System.out.println(WELCOME_MESSAGE);
                    //Capturamos o nome digitado
                    var name = scanner.next();
                    System.out.println(AGE_MESSAGE);
                    //Capturamos a idade digitada
                    var age = scanner.nextInt();
                    //Escrevemos com concatençaõ
                    System.out.println("Olá " + name
                            + " sua idade é: " + age);
                    //Escrevemos com parametros
                    System.out.printf("Olá %s sua idade é: %s  ", name, age);
                }
            }

    ```

## Keywords e tipos primitivos

Existem diversas palavaras reservadas do java ao qual temos que ter cuidado. [Java Keywords do site w3schools](https://www.w3schools.com/java/java_ref_keywords.asp)

Em java os dados mais básicos são os tipos primitivos [Link Dio tipos Primitivos](https://www.dio.me/articles/java-tipos-primitivos): 

- byte
- short
- int
- long
- float
- double
- char
- boolean

Exemplos de usos: 

```java
byte idade = 25;
short ano = 2025;
int populacao = 2147483647;
long distancia = 9876543210L;

float preco = 19.99f;
double pi = 3.141592653589793;

char letra = 'A';
var letra = 'A'; // Aspas simples sinaliza que é char, aspas duplas, nesta declaração sinalizaria string 
boolean ligado = true;
```

## Trabalhando com Operadores de Atribuição e Lógicos