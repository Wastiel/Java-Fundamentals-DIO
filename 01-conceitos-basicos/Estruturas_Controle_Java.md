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