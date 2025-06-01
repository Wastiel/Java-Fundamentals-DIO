# Desafio de código


## Desafio 1


### Descrição do Programa

 Crie um programa que receba a idade de uma pessoa e determine se ela é **menor de idade**, **maior de idade** ou **idosa**. Considere como referência:

- **Menor de idade**: menos de 18 anos
- **Maior de idade**: de 18 a 64 anos
- **Idoso**: 65 anos ou mais

#### Entrada

A entrada deve receber um único número **inteiro** representando a **idade** da pessoa.

#### Saída

Deverá retornar uma mensagem indicando a classificação da pessoa, como:

- **"Menor de idade"**
- **"Maior de idade"**
- **"Idoso"**

#### Exemplos

A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada | Saída         |
|---------|---------------|
| 15      | Menor de idade|
| 30      | Maior de idade|
| 70      | Idoso         |

---

### Código Exemplo em Java

```java
import java.util.Scanner;

public class ClassificacaoIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if(idade >= 65){
            System.out.println("Idoso");
        } else if (idade >= 18) {
            System.out.println("Maior de idade");
        } else{
            System.out.println("Menor de idade");
        }
        
        scanner.close();
    }
}
```

## Desafio 2

### Descrição do Programa

Escreva um programa que receba dois números inteiros e exiba a **soma**, **subtração**, **multiplicação**, **divisão inteira** e o **resto da divisão** entre eles.

### Entrada

A entrada deve receber **dois números inteiros** separados por espaço.

### Saída

Deverá retornar os resultados das operações aritméticas solicitadas em linhas separadas, na seguinte ordem:
1. **Soma**
2. **Subtração**
3. **Multiplicação**
4. **Divisão inteira**
5. **Resto da divisão**

### Exemplos

A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada | Saída |
|---------|-------|
| 10 2    | 12    |
|         | 8     |
|         | 20    |
|         | 5     |
|         | 0     |
| 15 4    | 19    |
|         | 11    |
|         | 60    |
|         | 3     |
|         | 3     |
| 7 3     | 10    |
|         | 4     |
|         | 21    |
|         | 2     |
|         | 1     |

---

### Código Exemplo em Java

```java
import java.util.Scanner;

public class OperacoesAritmeticas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada
        System.out.print("Digite dois números inteiros: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // Soma
        System.out.println(num1 + num2);

        // Subtração
        System.out.println(num1 - num2);

        // Multiplicação
        System.out.println(num1 * num2);

        // Divisão inteira
        System.out.println(num1 / num2);

        // Resto da divisão
        System.out.println(num1 % num2);
        
        scanner.close();
    }
}

```

## Desafio 3

### Descrição do Programa

Implemente um programa que receba a **nota** de um estudante (de 0 a 10) e informe se ele foi **"Reprovado"** (nota < 5), está em **"Recuperação"** (nota entre 5 e 6.9), ou foi **"Aprovado"** (nota ≥ 7).

### Entrada

A entrada deve receber um número **decimal** representando a **nota** do estudante.

### Saída

Deverá retornar uma mensagem indicando o **status** do estudante:

- **"Reprovado"**: Se a nota for menor que 5.
- **"Recuperação"**: Se a nota for entre 5 e 6.9 (inclusive).
- **"Aprovado"**: Se a nota for maior ou igual a 7.

### Exemplos

A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada | Saída     |
|---------|-----------|
| 4.5     | Reprovado |
| 5.5     | Recuperacao |
| 7.0     | Aprovado  |

---

### Código Exemplo em Java

```java
import java.util.Scanner;

public class StatusEstudante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada
        System.out.print("Digite a nota do estudante: ");
        double nota = scanner.nextDouble();

        // Verificação do status
        if (nota < 5) {
            System.out.println("Reprovado");
        } else if (nota >= 5 && nota <= 6.9) {
            System.out.println("Recuperacao");
        } else {
            System.out.println("Aprovado");
        }

        scanner.close();
    }
}

```