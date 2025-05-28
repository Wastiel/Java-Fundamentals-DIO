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

Vamos entender quais operadores temos disponiveis para utilizar no java.

**Operadores Lógicos**

| Operador | Significado   | Exemplo    |
|----------|---------------|------------|
| &&       | E lógico (AND) | a && b     |
| II       | OU lógico (OR) | a II b     |
| !        | NÃO lógico     | !a         |

**Operador de atribuição**

| Operador | Exemplo  | Equivalente a |
|----------|----------|----------------|
| =        | a = b    | -              |
| +=       | a += b   | a = a + b      |
| -=       | a -= b   | a = a - b      |
| *=       | a *= b   | a = a * b      |
| /=       | a /= b   | a = a / b      |
| %=       | a %= b   | a = a % b      |

**Operador de comparação**

| Operador | Significado       | Exemplo  |
|----------|-------------------|----------|
| ==       | Igual a           | a == b   |
| !=       | Diferente de      | a != b   |
| >        | Maior que         | a > b    |
| <        | Menor que         | a < b    |
| >=       | Maior ou igual    | a >= b   |
| <=       | Menor ou igual    | a <= b   |


## Trabalhando com Operadores Aritiméticos


**Operadores Aritiméticos:** 

| Operador | Significado     | Exemplo   |
|----------|-----------------|-----------|
| +        | Adição          | a + b     |
| -        | Subtração       | a - b     |
| *        | Multiplicação   | a * b     |
| /        | Divisão         | a / b     |
| %        | Módulo (resto)  | a % b     |

**Operadores de Incremento/Decremento**

| Operador | Significado     | Exemplo     |
|----------|-----------------|-------------|
| ++       | Incremento (+1) | a++ ou ++a  |
| --       | Decremento (-1) | a-- ou --a  |

```java
import java.util.Scanner;

public class OperadoresAritimeticos {

    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro número:");
        var value1 = scanner.nextInt();
        System.out.println("Informe o o segundo número:");
        var value2 = scanner.nextInt();
        //Operador de soma
        System.out.printf("%s + %s = %s \n", value1, value2, value1 + value2);
        // Concatenção com String's, a concatenação acaba por ser diferente
        System.out.println(value1 + " + " + value2 + " = " + value1 + value2);
        // Parenteses ele resolve antes, temos um resultado diferente
        System.out.println(value1 + " + " + value2 + " = " + (value1 + value2));
        //Operador de subtração
        System.out.printf("%s + %s = %s \n", value1, value2, value1 - value2);
        //divisao numero inteiro, para dividir  com resultado correto, temos que utilizar o float como recebimento de valor
        System.out.printf("%s + %s = %s \n", value1, value2, value1 / value2);
        //Resto da divisão
        System.out.printf("%s + %s = %s \n", value1, value2, value1 % value2);
        //Multiplicação
        System.out.printf("%s + %s = %s \n", value1, value2, value1 * value2);
        //precedencia, multiplicação e divisao sempre vao rodar primeiro
        System.out.println(5 + 9 * 10 - 5/2);
        // Potencia com função java
        System.out.printf("A potencia de %s é %s\n", value1, Math.pow(value1, 10));
        //somatorio
        var somatorio = 50;
        //Somatório
        System.out.println(++somatorio);
        //Subtração 
        System.out.println(--somatorio);            

    }
}

```

## Trabalhando com Operadores Bitwise (bit-a-bit)

Operadores para trabalhar bit a bit no código.
Em resumo as comparações são feitas focadas no bit da operação. 

# Operadores Bitwise em Java

| Operador | Nome                   | Símbolo | Exemplo     | Resultado (binário)       | Resultado (decimal) | Descrição                                                                 |
|----------|------------------------|---------|-------------|----------------------------|----------------------|---------------------------------------------------------------------------|
| AND      | E bit a bit            | `&`     | `5 & 3`     | `0101 & 0011 = 0001`       | `1`                  | Retorna 1 se ambos os bits forem 1.                                       |
| OR       | Ou bit a bit           | `I`     | `5 I 3`     | `0101 | 0011 = 0111`       | `7`                  | Retorna 1 se ao menos um dos bits for 1.                                  |
| XOR      | Ou exclusivo           | `^`     | `5 ^ 3`     | `0101 ^ 0011 = 0110`       | `6`                  | Retorna 1 se os bits forem diferentes.                                    |
| NOT      | Negação bit a bit      | `~`     | `~5`        | `~00000101 = 11111010`     | `-6`                 | Inverte todos os bits (complemento de 1 em dois).                         |
| Shift Esquerda | Desloca à esquerda | `<<`    | `5 << 1`    | `00000101 << 1 = 00001010` | `10`                 | Move os bits à esquerda, insere 0 à direita.                              |
| Shift Direita  | Desloca à direita  | `>>`    | `5 >> 1`    | `00000101 >> 1 = 00000010` | `2`                  | Move os bits à direita, mantendo o sinal à esquerda.                      |
| Shift Direita Lógico | Direita sem sinal | `>>>`   | `-5 >>> 1` | depende dos bits de -5     | grande positivo      | Move à direita preenchendo com 0 (mesmo para números negativos).          |



Exemplo de or em Java, precisando de um valor verdadeiro para retornar verdadeiro.

```java
public class Bitwise {
    public static void main(String[] args){
        var value1 = 6;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value1, binary1);
        var value2 = 5;
        var binary2 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value2, binary2);
        var result = value1 | value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf(" %s | %s = %s (Representação binária %s)\n", value1, value2, result, binaryResult);
    }
}
```

Exmeplo de E em java, precisando de dois valores verdadeiros para gerar um verdadeiro. 

```java
public class Bitwise {
    public static void main(String[] args){
        var value1 = 6;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value1, binary1);
        var value2 = 5;
        var binary2 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value2, binary2);
        var result = value1 & value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf(" %s & %s = %s (Representação binária %s)\n", value1, value2, result, binaryResult);
    }
}
```

Exmeplo de Xor em java, Se forem iguais os bits ele retorna 0, se forem diferentes ele retorna 1 . 

```java
public class Bitwise {
    public static void main(String[] args){
        var value1 = 6;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value1, binary1);
        var value2 = 5;
        var binary2 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value2, binary2);
        var result = value1 ^ value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf(" %s ^ %s = %s (Representação binária %s)\n", value1, value2, result, binaryResult);
    }
}
```

Exemplo de negação, ele inverte o valor do bit.

```java
public class Bitwise {
    public static void main(String[] args){
        var value1 = 6;
        var resultNegacao = ~value1;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf(" ~%s = %s (Representação binária %s)\n", value1, result, binaryResult);
            }
}
```

Exemplo de shift operator, desloca os bits e posterior preenche os mesmos com 0. As setas indicam para qual direção vai o deslocamento.

Deslocamento a esquerda <<:

```java
public class Bitwise {
    public static void main(String[] args){
        var value1 = 6;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value1, binary1);
        var value2 = 5;
        var binary2 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value2, binary2);
        var result = value1 << value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf(" %s << %s = %s (Representação binária %s)\n", value1, value2, result, binaryResult);
    }
}
```

Deslocamento a direita >>, porém com uma variação de mudança em numeros, se for negativo preenche com 1's e se for positivo com zeros:

```java
public class Bitwise {
    public static void main(String[] args){
        var value1 = 6;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value1, binary1);
        var value2 = 5;
        var binary2 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value2, binary2);
        var result = value1 << value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf(" %s << %s = %s (Representação binária %s)\n", value1, value2, result, binaryResult);
    }
}
```

shift direto lógico >>>, desloca os bites para a direita e joga 00 nos espaços de sobra:

```java
public class Bitwise {
    public static void main(String[] args){
        var value1 = 6;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value1, binary1);
        var value2 = 5;
        var binary2 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro Número da operação %s (Representação binária %s)\n", value2, binary2);
        var result = value1 >>> value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf(" %s >>> %s = %s (Representação binária %s)\n", value1, value2, result, binaryResult);
    }
}
```

## Exercícios:

1. Escreva um código que receba o nome e o ano de nascimento de alguém e imprima na tela a seguinte mensagem: "Olá "Fulano" Você tem X anos

```java

import java.time.OffsetDateTime;
import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args){
        /*
        1. Escreva um código que receba o nome e o ano de nascimento de alguém e imprima na tela a seguinte mensagem:
        "Olá "Fulano" Você tem X anos
         */
        var baseYear = OffsetDateTime.now().getYear();
        var scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        var name = scanner.next();
        System.out.println("Digite seu ano de nascimento:");
        var year = scanner.nextInt();
        var age = baseYear - year;
        System.out.printf("Olá %s, você tem %s anos de vida", name, age);
    }
}

```

2. Escreva um código que receba o tamanho do lado de um quadrado, calcule sua área e exiba na tela.
    - Formula: área = lado x lado

```java
import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args){

        /*
        2. Escreva um código que receba o tamanho do lado de um quadrado, calcule sua área e exiba na tela.
    - Formula: área = lado x lado
         */
        var scanner = new Scanner(System.in);
        System.out.println("Digie quando mede o lado do quadrado:");
        var side = scanner.nextInt();
        System.out.printf("A área do quadrado é: %s", side*side);

    }
}
```

3. Escreva um código que receba a base e a altura de um retângulo, calcule sua área e exiba na tela.
    - Fórmula: área = base X altura

```java
import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args){

        /*
            3. Escreva um código que receba a base e a altura de um retângulo, calcule sua área e exiba na tela.
    - Fórmula: área = base X altura
         */

        var scanner = new Scanner(System.in);
        System.out.println("Digie a base do retangulo: ");
        var base = scanner.nextInt();
        System.out.println("Altura a base do retangulo: ");
        var altura = scanner.nextInt();
        System.out.printf("A área do retangulo é %s", base * altura);

    }
}
```

4. Escreva um código que receba o nome e a idade de 2 pessoas e imprima a diferença de idade entre elas.

```java
import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args){

        /*
        4. Escreva um código que receba o nome e a idade de 2 pessoas e imprima a diferença de idade entre elas.
         */

        var scanner = new Scanner(System.in);
        System.out.println("Digite o nome da primeira pessoa: ");
        var pessoa1 = scanner.next();
        System.out.printf("Digite a idade de %s :\n ", pessoa1);
        var pessoa1Idade = scanner.nextInt();

        System.out.println("Digite o nome da segunda pessoa: ");
        var pessoa2 = scanner.next();
        System.out.printf("Digite a idade de %s :\n ", pessoa2);
        var pessoa2Idade = scanner.nextInt();

        System.out.printf("A diferença de idade entre %s e %s é: %s", pessoa1, pessoa2, Math.abs(pessoa1Idade-pessoa2Idade));

    }

}

```


## Material de apoio

## Recursos Adicionais

Para ajudá-lo a aprofundar o conhecimento, disponibilizamos a seguir alguns materiais complementares específicos:

- [Repositório no GitHub – Exercícios resolvidos Java Básico](https://github.com/digitalinnovationone/exercicios-java-basico)
- [W3Schools – Java Keywords](https://www.w3schools.com/java/java_ref_keywords.asp)
- [DIO – Java: Tipos Primitivos](https://www.dio.me/articles/java-tipos-primitivos)
- [Baeldung – Bitwise Operators em Java](https://www.baeldung.com/java-bitwise-operators)



## Questionário - Fundamentos da Linguagem de Programação Java

**Qual a diferença das linhas de código a seguir: var a = b++; var c = ++b;**

- Ambas fazem a mesma coisa, incrementam 1 ao valor da variavel b e atribuem o valor para variavel
- Nenhuma das linhas representam código Java válido
- A primeira linha irá incrementar + 1 em ‘b’ e atribuir o valor de ‘b’ em ‘a’ e a segunda linha irá atribuir o valor de ‘b’ em ‘c’ e depois incrementar ‘b’
- A primeira linha incrementa 1 ao valor de ‘b’ e a segunda torna o valor de ‘b’ um número positivo
- **A primeira linha irá atribuir o valor de ‘b’ para ‘a’ e depois incrementar + 1 em ‘b‘ e ‘a’ segunda linha ira incrementar + 1 em ‘b’ e depois atribuir o valor de ‘b’ em ‘c’. Correta**



**Qual a diferença do operador / e do operador %**

- / retorna o resto da divisão e % retorna o valor inteiro da divisão
- % não é um operador Java e / realiza divisão
- / não é um operador Java e % realiza divisão
- Ambos fazem divisão, porém o primeiro é para tipos inteiros e o segundo para pontos flutuantes
- **% retorna o resto da divisão e / retorna o valor inteiro da divisão**

**Qual das opções não se trata de um tipo primitivo em Java?**

- long
- boolean
- char
- int
- **bool**

**Qual das opções não se trata de uma keyword em Java?**

- public
- import
- final
- **export**
- private

**Qual a diferença entre && e &**

- Ambos pegam o resultado da expressão da direita e esquerda e retornam true se pelo menos 1 delas for true, porém o operador && irá retornar true se a experssão da esquerda for true, sem avaliar a expressão da direita
- Ambos os operadores fazem a mesma coisa
- Não são operadores válidos em Java
- Somente o primeiro operador é válido em Java e ele avalia as operações a sua esquerda e direita e retorna false se pelo menos 1 delas retornar false
- **Ambos pegam o resultado da expressão da direita e esquerda e retornam false se pelo menos 1 delas for false, porém o operador && irá retornar false se a expressão da esquerda for false, sem avaliar a expressão da direita**


**Como fazer uma operação de soma ou subtração ter precedência sobre uma operação de divisão e multiplicação**

- Envolver a operação com { }
- **Envolver a operação com ( )**
- Não é possível, pois multiplicação e divisão sempre tem precedência sobre soma e subtração
- Envolver a operação com {}
- Envolver a multiplicação com ( )


**Quais as formas de se criar comentários em Java?**

- /* e */ para comentários de 1 linha e // para comentários de multiplas linhas
- <! -- e → para comentários tanto de 1 linha como multiplas linhas
- \\ para comentários de 1 linha, \* e *\ para comentários de multiplas linhas
- para comentários de 1 linha, =begin e =end para comentários de múltiplas linhas
- **// para comentários de 1 linha, /* e */ para comentários de multiplas linhas**