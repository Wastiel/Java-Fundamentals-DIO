# Estruturas de Controle em Java

## Estrutura Condicional If else e else If

Em Java, usamos estruturas condicionais para **tomar decisões** no nosso código.

---

### ✅ `if`: a decisão simples

```java
if (condição) {
    // código que será executado se a condição for verdadeira
}
```

- O `if` verifica se **algo é verdadeiro**.
- Se for, executa o bloco de código entre `{ }`.
- Se não for, **simplesmente ignora** o bloco.

#### Exemplo simples:

```java
int idade = 20;
if (idade >= 18) {
    System.out.println("Você é maior de idade.");
}
```

---

### ✅ `if` com `else`: duas possibilidades

```java
if (condição) {
    // se a condição for verdadeira
} else {
    // se a condição for falsa
}
```

- O `else` é usado para tratar o **caso contrário**.
- Se a condição do `if` for falsa, o `else` será executado.

#### Exemplo:

```java
int idade = 16;
if (idade >= 18) {
    System.out.println("Pode dirigir.");
} else {
    System.out.println("Não pode dirigir.");
}
```

---

### ✅ `if`, `else if`, `else`: múltiplas escolhas

```java
if (condição1) {
    // se a condição1 for verdadeira
} else if (condição2) {
    // se a condição2 for verdadeira
} else {
    // se nenhuma das anteriores for verdadeira
}
```

- Permite verificar **mais de uma condição diferente**.
- Avalia de cima pra baixo, e **só executa o primeiro bloco verdadeiro**.

#### Exemplo:

```java
int nota = 70;

if (nota >= 90) {
    System.out.println("Excelente");
} else if (nota >= 70) {
    System.out.println("Aprovado");
} else {
    System.out.println("Reprovado");
}
```

---

### ✅ Operadores lógicos em condições

Você pode combinar condições com:

- `&&` (E): todas as condições devem ser verdadeiras.
- `||` (OU): basta **uma** ser verdadeira.

#### Exemplo:

```java
int idade = 17;
boolean emancipado = true;

if (idade >= 18 || emancipado) {
    System.out.println("Pode dirigir.");
}
```

---

### ✅ Usando uma variável booleana para guardar a condição

```java
boolean podeEntrar = idade >= 18;

if (podeEntrar) {
    System.out.println("Seja bem-vindo!");
}
```

- Torna o código mais limpo e fácil de entender.
- Útil quando você usa a mesma condição várias vezes.

---

### ✅ Operador Ternário `? :` (também chamado de Elvis Operation)

```java
variavel = (condição) ? valor_se_verdadeiro : valor_se_falso;
```

- Forma resumida de um `if/else`.
- Ideal quando você quer **escolher um valor** com base numa condição simples.

#### Exemplo:

```java
int idade = 20;
String resultado = (idade >= 18) ? "Maior de idade" : "Menor de idade";
System.out.println(resultado);
```

---

### ✅ Resumo Rápido

| Estrutura          | Uso principal                        | Exemplo curto                                  |
|--------------------|---------------------------------------|-------------------------------------------------|
| `if`               | Executar se for verdadeiro            | `if (x > 0) { ... }`                            |
| `if` + `else`      | Escolher entre verdadeiro/falso       | `if (x > 0) { ... } else { ... }`              |
| `if` + `else if`   | Múltiplas condições diferentes        | `if (...) { } else if (...) { } else { }`     |
| `? :` (ternário)   | Escolher entre dois valores simples   | `String r = (x > 0) ? "Sim" : "Não";`          |
| `&&` e `||`        | Combinar mais de uma condição         | `if (x > 0 && y < 10) { ... }`                 |

---


Exemplo na prática abordado na aula.
```java
import java.util.Scanner;

public class CondicaoIfElse {

    public static void main(String[] args){

        var scanner = new Scanner(System.in);
        System.out.println("Informe seu nome:");
        var name = scanner.next();
        System.out.println("Informe sua idade:");
        var age = scanner.nextInt();
        System.out.println("Você é emancipado? (s/n)");
        var isEmancipated = scanner.next().equalsIgnoreCase("s");
        // com um unico retorno na validação do IF, podemos ter o mesmo na estrutura abaixo:
        if (age >= 18) System.out.println("Bem Vindo ao validador de idade");
        // Caso tenhamos mais de uma linha de código, necessitamos da estrutura abaixo para o IF/else
        if (age >= 18) {
            System.out.println("Bem Vindo ao validador de idade");
            System.out.printf("%s, você tem tantos %s e pode dirigir \n", name, age);
        } else{
            System.out.printf("%s, você tem tantos %s e NAO pode dirigir \n", name, age);
        }

        //Validação com else if
        if (age >= 18) {
            System.out.println("Bem Vindo ao validador de idade");
            System.out.printf("%s, você tem tantos %s e pode dirigir \n", name, age);
        } else if(age >= 16 && isEmancipated){
            System.out.printf("%s, apesar de você não ter 18 anos, você pode dirigir \n", name);
        } else {
            System.out.printf("%s, você tem tantos %s e NAO pode dirigir \n", name, age);
        }
        //Condição composta
        if((age >=18) || (age >16 && isEmancipated)){
            System.out.printf("%s, você pode dirigir!  n", name);
        }else{
            System.out.printf("%s, você tem tantos %s e NAO pode dirigir \n", name, age);
        }
        //Condição com variavel
        var canDrive = (age >=18) || (age >16 && isEmancipated);
        if(canDrive){
            System.out.printf("%s, você pode dirigir!  n", name);
        }else{
            System.out.printf("%s, você tem tantos %s e NAO pode dirigir \n", name, age);
        }
        //condição com elvis operation ?:

        var message = canDrive ?
                name + ", você pode dirigir \n" :
                name + ", você não pode dirigir \n";

            System.out.println(message);
            System.out.println("Fime da execução do programa");
    }
}

```

## Estruturra condicional switch case

O switch case é uma estrutura de controle usada para tomar decisões com base no valor de uma variável. Ele é uma alternativa ao uso de múltiplos if-else.

```java
switch (variavel) {
    case valor1:
        // código se variavel == valor1
        break;
    case valor2:
        // código se variavel == valor2
        break;
    default:
        // código se nenhum valor anterior for igual
}

```

Switch case a partir da versão 14:

```java
int dia = 3;

switch (dia) {
    case 1 -> System.out.println("Domingo");
    case 2 -> System.out.println("Segunda");
    case 3 -> System.out.println("Terça");
    default -> System.out.println("Dia inválido");
}
```

Switch case com variavel:

```java
int dia = 3;

String retorno = switch (dia) {
    case 1 -> "Domingo";
    case 2 -> "Segunda";
    case 3 -> "Terça";
    case 4 -> "Quarta";
    case 5 -> "Quinta";
    case 6 -> "Sexta";
    case 7 -> "Sábado";
    default -> "Dia inválido";
};

System.out.println(retorno);
```

Exemplo simples:

```java
int dia = 3;

switch (dia) {
    case 1:
        System.out.println("Domingo");
        break;
    case 2:
        System.out.println("Segunda");
        break;
    case 3:
        System.out.println("Terça");
        break;
    default:
        System.out.println("Dia inválido");
}

```

## Estrutura de repetição For

O for é uma estrutura de repetição usada para executar um bloco de código várias vezes, geralmente com base em uma contagem ou condição.

Sintaxe Tradicional:

```java
for (inicialização; condição; incremento) {
    // código a ser repetido
}
```

For infinito com interrupção interna(break)

```java
for (;;) {
    System.out.println("Digite um nome: ");
    var name = scanner.next();

    if (name.equalsIgnoreCase("exit")) break;

    System.out.println(name);
}

```

For com condição de parada (break)

```java
for (var i = 1; i < 100; i++) {
    if (i == 90) break;
    System.out.println(i);
}

```

For com continue (pula para a próxima iteração)

```java
for (var i = 1; i < 100; i++) {
    if (i % 2 == 0) continue;
    System.out.println(i);
}
```

For-each (percorrer elementos de uma coleção ou array)

```java
for (var arg : args) {
    System.out.println(arg);
}
```

### 📝 Tipos de `for` em Java

| Tipo de `for`         | Quando usar                                                |
|-----------------------|------------------------------------------------------------|
| Tradicional           | Quando você sabe quantas vezes o loop vai repetir          |
| Infinito com `break`  | Quando a saída depende de uma condição externa (ex: input) |
| Com `continue`        | Para pular certas iterações (ex: ignorar números pares)    |
| For-each              | Para percorrer coleções ou arrays sem usar índice direto   |

## Estrutura de repetição while e do while

As estruturas while e do-while são usadas quando não sabemos quantas vezes o código vai repetir, e a repetição depende de uma condição lógica.

while simples