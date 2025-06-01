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

Essas estruturas são usadas para **repetir tarefas** enquanto certas condições são verdadeiras.

## 🔄 `while`: repete **enquanto** a condição for verdadeira

```java
while (condição) {
    // código que será executado várias vezes
}
```

- A condição é testada **antes de cada repetição**.
- Se a condição for falsa no começo, o bloco **nunca é executado**.

### Exemplo:

```java
int contador = 0;
while (contador < 3) {
    System.out.println("Contando: " + contador);
    contador++;
}
```

---

## 🔁 `do-while`: repete **pelo menos uma vez**

```java
do {
    // código executado pelo menos uma vez
} while (condição);
```

- A condição é testada **depois da repetição**.
- O bloco será executado **pelo menos uma vez**, mesmo que a condição seja falsa.

### Exemplo:

```java
int contador = 0;
do {
    System.out.println("Contando: " + contador);
    contador++;
} while (contador < 3);
```

---

## ✋ `break`: interrompe o loop

```java
while (condição) {
    if (algo) {
        break;
    }
}
```

- Sai imediatamente do loop.
- Pode ser usado tanto em `while`, `do-while` quanto em `for`.

### Exemplo:

```java
int i = 0;
while (true) {
    if (i == 5) {
        break;
    }
    System.out.println(i);
    i++;
}
```

---

## ⏭️ `continue`: pula para a próxima repetição

```java
while (condição) {
    if (algo) {
        continue;
    }
    // restante do código
}
```

- Pula o resto do código no loop e vai direto para a próxima repetição.

### Exemplo:

```java
int i = 0;
while (i < 5) {
    i++;
    if (i == 3) {
        continue;
    }
    System.out.println(i);
}
```

> Neste exemplo, o número 3 **não será impresso**, porque `continue` pula essa volta.

---

## 📝 Resumo Rápido

| Estrutura         | Descrição                                             |
|-------------------|--------------------------------------------------------|
| `while`           | Repete enquanto a condição for verdadeira              |
| `do-while`        | Sempre executa pelo menos uma vez                      |
| `break`           | Encerra o loop imediatamente                          |
| `continue`        | Pula o resto do loop e vai para a próxima repetição    |

---

## 👶 Dica para Iniciantes

- Use `while` quando **não souber quantas vezes** o código precisa repetir.
- Use `do-while` quando precisar rodar **pelo menos uma vez**.
- Use `break` para **parar tudo**.
- Use `continue` para **pular uma volta** do loop.

---

## Exercícios 

1. Escreva um código onde o usuário entra com um número e seja gerada a tabuada de 1 até 10 desse número;

```java
package ExerciciosEstruturaControleRepeticao;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args){

        /*
        1. Escreva um código onde o usuário entra com um número e seja gerada a tabuada de 1 até 10 desse número;
         */
        var scanner = new Scanner(System.in);
        System.out.println("Digite um numero e veja a tabuada acontecer!!");
        var number = scanner.nextInt();

        for (int i = 1;i <=10; i++){
            var tabuada = number * i;
            System.out.printf("%s x %s = %s \n", number,  i, tabuada);
        }
    }
}

```

2. Escreva um código onde o usuário entra com sua altura e peso, seja feito o calculo do seu IMC(IMC = peso/(altura * altura)) e seja exibida a mensagem de acordo com o resultado:
   - Se for menor ou igual a 18,5 "Abaixo do peso";
   - se for entre 18,6 e 24,9 "Peso ideal";
   - Se for entre 25,0 e 29,9 "Levemente acima do peso";
   - Se for entre 30,0 e 34,9 "Obesidade Grau I";
   - Se for entre 35,0 e 39,9 "Obesidade Grau II (Severa)";
   - Se for maior ou igual a 40,0 "Obesidade III (Mórbida)";

```java
package ExerciciosEstruturaControleRepeticao;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){

        /*
        2. Escreva um código onde o usuário entra com sua altura e peso, seja feito o calculo do seu IMC(IMC = peso/(altura * altura)) e seja exibida a mensagem de acordo com o resultado:
       - Se for menor ou igual a 18,5 "Abaixo do peso";
       - se for entre 18,6 e 24,9 "Peso ideal";
       - Se for entre 25,0 e 29,9 "Levemente acima do peso";
       - Se for entre 30,0 e 34,9 "Obesidade Grau I";
       - Se for entre 35,0 e 39,9 "Obesidade Grau II (Severa)";
       - Se for maior ou igual a 40,0 "Obesidade III (Mórbida)";
         */

        var scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao programa de IMC!!");
        System.out.println("Digite sua altura: ");
        var weight = scanner.nextDouble();
        System.out.println("Digite seu peso: ");
        var height = scanner.nextDouble();

        var IMC = height / ( weight * weight);
        String classification;

        if(IMC >= 40){
            classification = "Obesidade III (Mórbida)";
        } else if (IMC >= 35) {
            classification = "Obesidade Grau II (Severa)";
        } else if (IMC >= 30) {
            classification = "Obesidade Grau I";
        } else if (IMC >= 25) {
            classification = "Levemente acima do peso";
        } else if (IMC >= 18.6) {
            classification = "Peso ideal";
        } else {
            classification = "Abaixo do peso";
        }

        System.out.printf("Seu IMC é %.2f e sua flassificação conforme OMS é %s", IMC, classification);
    }
}

```

3. Escreva um código que o usuário entre com um primeiro número, um segundo número maior que o primeiro e escolhe entre a opção par e impar, com isso o código deve informar todos os números pares ou ímpares (de acordo com a seleção inicial) no intervalo de números informados, incluindo os números informados e em ordem decrescente;


```java
package ExerciciosEstruturaControleRepeticao;

import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args){

        /*
        3. Escreva um código que o usuário entre com um primeiro número, um segundo número maior que o primeiro e escolhe entre a opção par e impar,
        com isso o código deve informar todos os números pares ou ímpares (de acordo com a seleção inicial) no intervalo de números informados, incluindo os números informados e em ordem decrescente;

         */
        var scanner = new Scanner(System.in);
        System.out.println("Programa de validação de numeros, digite dois numeros onde o segundo deve ser menor que o primeiro!!");
        System.out.println("Digite o primeiro número para validação!! ");
        var number1 = scanner.nextInt();
        int number2;
        String choice = "String";

        do {
            System.out.println("Digite o segundo número para validação!! ");
            number2 = scanner.nextInt();

            if(number1 > number2){
                System.out.println("Numero inválido, o segundo número deve ser maior que o primeiro!");
            }

        } while (number1>number2);

        do {
            System.out.println("Escolha Par ou Impar (P/I)");
            choice = scanner.next();

            if(!choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("I")){
                System.out.println("Opção inválida, digite novamente");
            }

        } while (!choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("I"));

        System.out.printf("Agora vamos mostrar todos os numeros pares e impares entre os números %s e  %s: \n",number1, number2);
        for(int x = number2; x >= number1; x-- ){
            if ((x % 2 == 0) && (choice.equalsIgnoreCase("P"))){
                System.out.printf("O número %s é par \n" , x);
            } else if((x % 2 != 0) && (choice.equalsIgnoreCase("I"))){
                System.out.printf("O número %s é impar \n", x);
            }
        }
        /*
        Lógica melhor e refatorada, mais simples.
        for (int x = number1; x <= number2; x++) {
            boolean isPar = x % 2 == 0;

            if ((choice.equalsIgnoreCase("P") && isPar) ||
                    (choice.equalsIgnoreCase("I") && !isPar)) {

                System.out.printf("O número %d é %s\n", x, isPar ? "par" : "ímpar");
            }
        }
         */

        System.out.println("Fim do programa");

    }
}

```

4. Escreva um código onde o usuário informa um número inicial, posteriormente irá informar outros N números, a execução do código irá continuar até que o número informado dividido pelo primeiro número tenha resto diferente de  0 na divisão, números menores que o primeiro número devem ser ignorados

```java
package ExerciciosEstruturaControleRepeticao;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args){

        /*
        4. Escreva um código onde o usuário informa um número inicial, posteriormente irá informar outros N números, a execução do código irá continuar até que
        o número informado dividido pelo primeiro número tenha resto diferente de  0 na divisão, números menores que o primeiro número devem ser ignorados
         */

        var scanner = new Scanner(System.in);
        System.out.println("Programa que valida resultado diferente de 0!!");
        System.out.println("Digite o primeiro número");
        var number1 = scanner.nextInt();
        int number2;
        boolean finalizar = true;

        do{
            System.out.println("Digite o segundo número");
            number2 = scanner.nextInt();

            if(number1>=number2){
                System.out.println("Número inválido!!");
                finalizar = false;
            }else{
                finalizar = number2 % number1 != 0;
            }

        }while(!finalizar);

    System.out.printf("O numero %s divido pelo numero %s, da resto de divisao diferente de 0", number2, number1);

    }
}


```

## Especial Git Hub

Download git: [Site oficial do Git](https://git-scm.com)

Verfificar a versão do git: 

```bash
git --version
```

Criar a conta no github: [GitHub](https://github.com/)

### 📦 Criar um Novo Repositório no GitHub

- Acesse github.com e faça login.
- Clique em "New" ou vá para: Criar novo repositório
    - Preencha as informações:
    - Nome do repositório
    - Descrição (opcional)
    - Visibilidade (público ou privado)
- Clique em "Create repository"


### 🔗 Clonar com HTTPS
Copie o link HTTPS (ex: https://github.com/usuario/repositorio.git)

No terminal:
```bash
git clone https://github.com/usuario/repositorio.git
```

###  🔐 Clonar com SSH

1. Gerar Chave SSH
- Se ainda não tem uma, gere com:

```bash
ssh-keygen -t ed25519 -C "seu-email@example.com"
```
2. Adicionar a Chave ao GitHub
Copie a chave pública:

```bash
cat ~/.ssh/id_ed25519.pub
Vá em: GitHub > Settings > SSH and GPG keys
```

Clique em "New SSH key", cole a chave e salve

3. Clonar com SSH
bash

```bash
git clone git@github.com:usuario/repositorio.git
```

### 🚀 Enviar Projeto Local para o GitHub
Se já tem o projeto na máquina:

```bash
git init
git add .
git commit -m "Primeiro commit"
git remote add origin https://github.com/usuario/repositorio.git  # ou SSH
git push -u origin main
```

## Recursos Adicionais

Materiais adicionais

- [Repositório dos exercícios de Java básico (DIO)](https://github.com/digitalinnovationone/exercicios-java-basico)
- [Site oficial do Git](https://git-scm.com)
- [Gerando sua chave SSH (Git Book)](https://git-scm.com/book/en/v2/Git-on-the-Server-Generating-Your-SSH-Public-Key)


## Questionário - Fundamentos da Linguagem de Programação Java

# Perguntas e Respostas sobre Java

### **1. Qual a função da keyword `break`?**
- **Serve para dentro de um loop continuar a execução indo para a próxima interação e ignorar o código abaixo.**
- **Quando usado no case no formato mais antigo do Java é para sair do switch sem entrar nos cases abaixo e em uma estrutura de repetição para sair da mesma.** ✅
- **Nenhuma das alternativas.**
- **Interrompe a execução do código.**
- **Informa um ponto de interrupção do código para continuar a execução.**

---

### **2. Quando usamos o `case` no formato mais antigo (case: ) e não usamos o `break` em cada condição o que acontece?**
- **O código não funciona, porque a declaração do `case` é obrigatória.**
- **O código entra em loop infinito.**
- **O código irá rodar normalmente e sair do `switch` assim que concluir o `case`.**
- **Um erro é gerado.**
- **Quando o código termina o primeiro `case`, ao invés dele sair da estrutura `switch`, ele irá rodar todos os `cases` abaixo desse.** ✅

---

### **3. Qual a função do `if`?**
- **Avaliar uma expressão booleana e entrar na estrutura se a condição for verdadeira.** ✅
- **Nenhuma das alternativas.**
- **Avaliar uma expressão booleana e entrar na estrutura se a condição for falsa.**
- **Não existe estrutura `if` no Java.**
- **Executar um determinado código `x` vezes, onde `x` é o valor informado na estrutura `if(x)`.**

---

### **4. Qual a diferença do `while` e `do while`?**
- **O `while` executa somente se a condição informada for verdadeira e o `do while` executa a primeira vez e depois verifica a condição informada.** ✅
- **Os 2 fazem a mesma coisa, a diferença é que o `do while` é a forma mais antiga e o `while` é uma nova implementação.**
- **O `while` itera sobre uma coleção enquanto o `do while` utiliza uma variável contadora para realizar a iteração.**
- **O Java não tem `do while`, somente o `while`.**
- **O `while` executa a primeira vez e depois verifica a condição informada e o `do while` executa somente se a condição informada for verdadeira.**

---

### **5. Qual dos exemplos representa o uso do Elvis Operator?**
- **Nenhuma das alternativas.**
- **var ex = if (<CONDICAO>) <VALOR_PARA_ATRIBUIR_SE_VERDADEIRO> else <VALOR_PARA_ATRIBUIR_SE_FALSO>**
- **var ex = <CONDICAO> ? <VALOR_PARA ATRIBUIR_SE_VERDADEIRO> : <VALOR_PARA_ATRIBUIR_SE_FALSO>** ✅
- **var ex = <CONDICAO> ? <VALOR_PARA_ATRIBUIR_SE_E> : <VALOR_PARA_ATRIBUIR_SE_VERDADEIRO**
- **var ex = <CONDICAO> : <VALOR_PARA_ATRIBUIR_SE_VERDADEIRO> ? <VALOR_PARA_ATRIBUIR_SE_FALSO>**

---

### **6. Quando usar o `for(int i; i < 100; i++)` e `for (String arg : args)`?**
- **O primeiro é usado somente para listas e o segundo não é recomendado com listas.**
- **O primeiro não é recomendado utilizar em conjunto com coleções e o segundo é específico para isso.**
- **A segunda forma foi implementada no Java 21 e é mais performática.**
- **O primeiro é recomendado quando é importante para seu código o índice de uma coleção ou precisa de um contador e o segundo quando você só precisa iterar em uma coleção e não precisa do índice.** ✅
- **Ambos fazem a mesma coisa.**

---

### **7. Qual a função da keyword `continue`?**
- **Continuar a execução de um loop indo para a próxima iteração e ignorando o código abaixo do mesmo.** ✅
- **Quando usado no `case` no formato mais antigo do Java, é para sair do `switch` sem entrar nos `cases` abaixo e em uma estrutura de repetição para sair da mesma.**
- **Continua a execução de um código de um determinado ponto que foi interrompido por um erro.**
- **Informa onde a execução de um código continua após anteriormente ser chamado um `break`.**
- **Nenhuma das alternativas.**

---

### **8. Quando usamos um `case` com arrow (→) e precisamos de mais de uma linha, qual palavra reservada usamos para indicar o retorno?**
- **yield** ✅
- **return**
- **break**
- **continue**
- **switch**
