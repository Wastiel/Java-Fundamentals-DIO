# Herança e Polimorfismo em Java

## Introdução a Herança e Polimorfismo

## 🧬 Herança

Herança é um princípio da programação orientada a objetos em que uma classe (filho) herda atributos e comportamentos de outra classe (pai). Isso permite o reuso de código e modelagem mais próxima do mundo real.

### Exemplo: Classe Pai e Filho

```java
class Pai {
    public void falar() {
        System.out.println("Pai falando...");
    }
}

class Filho extends Pai {
    public void brincar() {
        System.out.println("Filho brincando...");
    }
}

public class Main {
    public static void main(String[] args) {
        Filho filho = new Filho();
        filho.falar();   // Herdado do Pai
        filho.brincar(); // Específico do Filho
    }
}
```

## 🧬 Polimorfismo

Polimorfismo permite que objetos de diferentes classes sejam tratados como objetos de uma superclasse comum. Um método pode ter comportamentos diferentes dependendo do tipo do objeto que o invoca.

### Exemplo: Máquina e Cartões

```java
class Cartao {
    public void pagar() {
        System.out.println("Pagamento genérico");
    }
}

class CartaoCredito extends Cartao {
    public void pagar() {
        System.out.println("Pagamento com crédito");
    }
}

class CartaoDebito extends Cartao {
    public void pagar() {
        System.out.println("Pagamento com débito");
    }
}

public class Maquina {
    public void processarPagamento(Cartao cartao) {
        cartao.pagar();
    }

    public static void main(String[] args) {
        Maquina m = new Maquina();
        m.processarPagamento(new CartaoCredito()); // Pagamento com crédito
        m.processarPagamento(new CartaoDebito());  // Pagamento com débito
    }
}
```

## 🧱 Modificadores de Classe

### 🔒 `final`
- Uma classe `final` **não pode ser estendida**.
- Um método `final` **não pode ser sobrescrito**.
- Uma variável `final` **não pode ter seu valor alterado** após atribuição.

```java
final class Pai {
    // esta classe não pode ser herdada
}
```

### 🧩 `abstract`
- Uma classe `abstract` **não pode ser instanciada**.
- Pode conter **métodos abstratos**, que devem ser implementados pelas subclasses.

```java
abstract class Pai {
    abstract void trabalhar();
}

class Filho extends Pai {
    void trabalhar() {
        System.out.println("Filho trabalhando...");
    }
}
```

### 🪪 `sealed`, `non-sealed`, `permits` (Java 17+)
- `sealed`: restringe quais classes podem herdar da classe pai.
- `permits`: especifica quais subclasses são permitidas.
- `non-sealed`: permite herança aberta a partir de uma subclasse.

```java
sealed class Pai permits Filho1, Filho2 {}

final class Filho1 extends Pai {}

non-sealed class Filho2 extends Pai {}

class Neto extends Filho2 {} // Permitido porque Filho2 é non-sealed
```

---

## Explorando Herança e Polimorfismo

## 1. Conceitos Fundamentais

### Herança
Herança permite que uma classe (subclasse) herde atributos e comportamentos (métodos) de outra classe (superclasse).

Exemplo:
```java
public class Employee {
    protected String code;
    protected String name;
    // ...
}
public class Manager extends Employee {
    private String login;
    private String password;
    // ...
}
```

### Polimorfismo
Polimorfismo permite que objetos sejam tratados de forma genérica por suas superclasses, mas executem comportamentos específicos em tempo de execução.

Exemplo:
```java
Employee e = new Manager();
```

## 2. Cast e `instanceof`

### Antes do Java 16
```java
if (employee instanceof Manager) {
    Manager manager = (Manager) employee;
    manager.setPassword("123456");
}
```

### A partir do Java 16+ (Pattern Matching)
```java
if (employee instanceof Manager manager) {
    manager.setPassword("123456");
}
```

## 3. `switch` com `instanceof` (Java 17+)
```java
switch (employee) {
    case Manager manager -> {
        manager.setLogin("joao");
        manager.setPassword("123456");
    }
    case Salesman salesman -> {
        salesman.setPercentPerSold(10);
    }
}
```

> Obs: O `switch` sem `default` é possível aqui porque `Employee` é uma classe `sealed`, e o compilador sabe que só existem dois possíveis filhos.

## 4. Palavra-chave `super`
Usada para acessar atributos ou métodos da superclasse:
```java
@Override
public String getCode() {
    return "MN" + super.getCode();
}
```

## 5. Modificadores de Acesso
- `private`: visível apenas na própria classe.
- `protected`: visível no mesmo pacote e em subclasses.
- `public`: visível em qualquer lugar.

## 6. Métodos Abstratos
Definidos em uma classe abstrata sem implementação:
```java
public abstract double getFullSalary();
```
A implementação é obrigatória nas subclasses.

## 7. Sobrescrita (Override)
Substitui o comportamento da superclasse:
```java
@Override
public double getFullSalary() {
    return this.salary + this.commission;
}
```

## 8. Sobrecarga (Overload)
Mesma assinatura de nome com parâmetros diferentes:
```java
public double getFullSalary() {
    return this.salary + this.commission;
}

public double getFullSalary(double extra) {
    return this.salary + this.commission + extra;
}
```

---

## 9. Classes Utilizadas no Exemplo

### Classe `Employee` (abstrata e selada)
```java
public sealed abstract class Employee permits Manager, Salesman {
    protected String code;
    protected String name;
    protected String address;
    protected String age;
    protected double salary;

    public abstract double getFullSalary();
    // getters e setters omitidos
}
```

### Classe `Manager`
```java
public non-sealed class Manager extends Employee {
    private String login;
    private String password;
    private double commission;

    @Override
    public double getFullSalary() {
        return this.salary + this.commission;
    }

    public double getFullSalary(double extra) {
        return this.salary + this.commission + extra;
    }
}
```

### Classe `Salesman`
```java
public non-sealed class Salesman extends Employee {
    private double percentPerSold;
    private double souldAmount;

    @Override
    public double getFullSalary() {
        return this.salary + (souldAmount * percentPerSold / 100);
    }
}
```

## 10. Exemplo de Execução
```java
public static void printEmployee(Employee employee) {
    switch (employee) {
        case Manager manager -> {
            manager.setLogin("joao");
            manager.setPassword("123456");
            System.out.println(manager.getFullSalary());
        }
        case Salesman salesman -> {
            salesman.setPercentPerSold(10);
            salesman.setSouldAmount(1000);
            System.out.println(salesman.getFullSalary());
        }
    }
}
```

## 11. Limitações de `record`
- `record` não pode herdar de outra classe (não pode usar `extends`).
- Só pode ter membros `static`, que não são herdáveis.


## Reforçando Herança e Polimorfismo Java

O istanceof no java valida se um objeto telação de hierarquia com outro objeto. 

## Questionário:

# Perguntas sobre Herança, Polimorfismo e Classes em Java

## 🔁 Herança

Herança é o mecanismo que permite que uma classe (subclasse ou classe filha) herde atributos e comportamentos (métodos) de outra classe (superclasse ou classe pai).

Exemplo básico:

```java
public class Animal {
    public void fazerSom() {
        System.out.println("Algum som...");
    }
}

public class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Latido");
    }
}
```

---

## 🔄 Polimorfismo

Polimorfismo significa que podemos usar uma referência de uma superclasse para apontar para um objeto de qualquer subclasse, e ainda assim invocar métodos que foram sobrescritos.

```java
Animal meuAnimal = new Cachorro();
meuAnimal.fazerSom(); // Saída: Latido
```

O método sobrescrito é chamado mesmo com a variável sendo do tipo `Animal`.

---

## 🔍 instanceof no Java

O operador `instanceof` é usado para verificar se um objeto é uma instância de uma classe específica ou se ele pertence a uma hierarquia de classes.

### ✅ Sintaxe antiga:

```java
if (meuAnimal instanceof Cachorro) {
    Cachorro dog = (Cachorro) meuAnimal;
    dog.fazerSom();
}
```

### ✅ Sintaxe moderna (Java 16+):

```java
if (meuAnimal instanceof Cachorro dog) {
    dog.fazerSom();
}
```

### 💡 Importante:

`instanceof` não testa igualdade de tipos, mas sim relacionamento de herança.  
Ou seja, verifica se o objeto pode ser considerado do tipo especificado, mesmo que a referência seja da superclasse.

---

## 🧠 Por que instanceof é útil?

Em códigos que trabalham com polimorfismo, muitas vezes você quer tratar objetos de formas diferentes com base em sua classe real.  
O `instanceof` permite essa diferenciação sem quebrar o princípio do polimorfismo.

---

## 📦 Exemplo completo:

```java
public abstract class Funcionario {
    public abstract void trabalhar();
}

public class Gerente extends Funcionario {
    public void trabalhar() {
        System.out.println("Gerenciando equipe...");
    }

    public void aprovarFolga() {
        System.out.println("Folga aprovada!");
    }
}

public class Desenvolvedor extends Funcionario {
    public void trabalhar() {
        System.out.println("Escrevendo código...");
    }
}
```

```java
public class Teste {
    public static void main(String[] args) {
        Funcionario f1 = new Gerente();
        Funcionario f2 = new Desenvolvedor();

        testarFuncionario(f1);
        testarFuncionario(f2);
    }

    public static void testarFuncionario(Funcionario f) {
        f.trabalhar();

        if (f instanceof Gerente gerente) {
            gerente.aprovarFolga(); // Só Gerente tem esse método
        }
    }
}
```

---

## 📌 Resumo

- ✅ Herança permite que classes compartilhem código.

- ✅ Polimorfismo permite tratar diferentes classes como se fossem do mesmo tipo.

- ✅ `instanceof` verifica se um objeto faz parte da hierarquia de uma classe.

- ✅ A sintaxe moderna do `instanceof` é mais limpa e segura, pois evita casting manual.


---

### 1. Além de estar contida na lista da cláusula `permits` de uma classe `sealed`, qual outra condição a classe filha deve atender?

- ✅ **A classe deve ser marcada como `final`, `sealed` ou `non-sealed`**  
- [ ] A classe deve ser marcada como `final` ou `sealed`  
- [ ] Nenhuma das alternativas  
- [ ] A classe deve ter um construtor que recebe como argumentos as propriedades da classe pai, pois a classe `sealed` só pode ter propriedades finais  
- [ ] A classe deve ser marcada como `final` e `non-sealed`  

---

### 2. Qual a diferença entre uma classe `sealed` e uma classe `final`?

- ✅ **A classe `sealed` só pode ser estendida por classes contidas na cláusula `permits` e a classe `final` não pode ser estendida por nenhuma**  
- [ ] A classe `sealed` se herdada define que as classes filhas só tenham os mesmos métodos e atributos que ela possui e a classe `final` não pode ser herdade por nenhuma classe  
- [ ] Nenhuma das alternativas  
- [ ] A classe `sealed` é uma classe usada nos tipos internos do Java e a classe `final` indica a classe que está mais abaixo da hierarquia das heranças  
- [ ] A classe `final` só pode ser estendida por classes contidas na cláusula `permits`. A classe `sealed` não pode ser estendida por nenhuma  

---

### 3. O que é herança?

- [ ] Nenhuma das alternativas  
- [ ] É a capacidade de uma classe poder herdar propriedades de métodos de uma outra classe. No Java temos suporte para trabalhar com herança múltipla  
- ✅ **É a capacidade de uma classe poder herdar propriedades de métodos de uma outra classe. No Java as classes só podem herdar de 1 classe**  
- [ ] É a capacidade de uma classe herdar as propriedades de uma outra classe. No Java não temos suporte para herança múltipla  
- [ ] É a capacidade de uma classe herdar os métodos de uma outra classe. No Java não temos suporte para herança múltipla  

---

### 4. O que é uma classe abstrata?

- [ ] É uma classe que não pode ser instanciada, somente classes abstratas podem ser herdadas  
- [ ] É uma classe que não pode ser herdada  
- [ ] É uma classe que só pode ser herdada por classes contidas na cláusula `permits`  
- ✅ **É uma classe que não pode ser instanciada, somente as classes que estendem da mesma que não são abstratas**  
- [ ] Nenhuma das alternativas  


## Exercício: Herança e Polimorfismo em java

1. Crie uma hierarquia de classes para tratar os tipos de ingresso que podem ser comercializados em um cinema. O ingresso deve ter um valor, nome do filme e informar se é dublado ou legendado. A partir desse ingresso devem ser criados os tipos Meia entrada e ingresso família. Cada ingresso deve ter um método que retorna o seu valor real ( baseado no valor informado na criação do ingresso) para os de meia entrada o seu valor deve ser de metade do valor, para os ingressos família deve-se retornar o valor multiplicado pelo número de pessoas e fornecer um desconto de 5% quando o número de pessoas for maior que 3.

- [Resultado da ativiodade refatorada com dicas do GPT](./Exercicios_Heranca_Polimorfismo/Cinema/)

2. Crie uma hierarquia de classes que definam os tipos de usuários de um sistema, use os seguintes requisitos:

Classe Gerente que terá os atributos: Nome, Email, Senha e um atributo que informa se ele é administrador, esse último deve ser sempre verdadeiro;
Classe Vendedor que terá os seguintes atributos: Nome, Email, Senha, Quantidade de vendas e um atributo que informa se ele é administrador, esse útimo deve ser sempre falso;
Classe Atendente que terá os seguintes atributos: Nome, Email, Senha, Valor em caixa e um atributo que informa se ele é administrador, esse ultimo deve ser sempre falso.
Cada classe deve ter seus respectivos getters e setters ( para atributos que façam sentido ter) e as classes devem ter os seguintes métodos

A classe Gerente deve ter os métodos Gerar relatório financeiro, Consultar vendas, Realizar login, Realizar logff, alterar dados, alterar senha;
A classe Vendedor deve ter os métodos Realizar venda ( incrementar o número de vendas quando acionado), Consultar vendas, Realizar login, Realizar logoff, alterar dados, alterar senha;
A classe Atendente deve ter os métodos Receber pagamentos (onde o método recebe um valor que deve ser incrementado no valor em caixa), Fechar o caixa, Realizar Login, Realizar logoff, alterar dados e alterar senha;

- [Resultado da ativiodade criada do zero](./Exercicios_Heranca_Polimorfismo/Sistema/)

3. Escreve uma hierarquia de classes para criação de relógios para diferentes lugares do mundo, defina uma classe pai que tenha as propriedades Hora, minuto e segundo com seus respectivos getters e setters (atendendo as regras do funcionamento de um relógio) e um método que deverá retornar a hora no formato HH:MM:SS, a partir dessa classe crie 2 implementações, uma chamada relógio Americando e outra chamada relógio Brasileiro, lembrando que para o relógio americano não existem as horas de 13 até 24. Defina também na super classe um método que ficará por responsabilidade da classe que extende-la definir seu funcionamemnto, esse método deve receber um relógio ( independente da implementação) e deve-se extrair as informações dele e usa-la no objeto que recebeu para setar as novas informações do relógio.

- [Resultado da ativiodade criada do zero](./Exercicios_Heranca_Polimorfismo/Relogio/)

# Quiz de Java - Fundamentos da Programação Orientada a Objetos

### 1. O que faz a keyword `instanceof`?

- [ ] Nenhuma das alternativas  
- [ ] É usada para verificar se uma classe está herdando de uma outra classe  
- [ ] Ela é usada para verificar se uma classe é da mesma instância de uma outra classe  
- [ ] Ela é usada em verificações para informar se um objeto tem a mesma instância de um outro objeto  
- ✅ **Ela é usada em verificações para informar se um objeto é instância de uma determinada classe**

---

### 2. O que é um método abstrato?

- ✅ **Um método abstrato é um método que deve ser implementado por uma classe que herdar essa classe, somente classes abstratas podem conter métodos abstratos**  
- [ ] Um método abstrato é um método que deve ser implementado por uma classe que herdar essa classe, se a classe tem métodos abstratos ela obrigatoriamente deve ter classes filhas, porém não precisa ser definida como abstrata  
- [ ] É um método que não pode ser sobrescrito  
- [ ] É um método que é gerado pelo Java no tempo de execução com informações da classe  
- [ ] Nenhuma das alternativas  

---

### 3. Como podemos impedir que um método seja sobrescrito por uma subclasse?

- [ ] Usando a keyword `sealed`  
- ✅ **Usando a keyword `final`**  
- [ ] Impedindo que a classe seja herdada definindo-a como `final`  
- [ ] Usando a keyword `abstract`  
- [ ] Nenhuma das alternativas  

---

### 4. O que faz o modificador de acesso `protected`?

- ✅ **Ele define uma propriedade/método como inacessível para acessos de fora da classe ou de classes que não estão herdando dela**  
- [ ] Não existe a keyword `protected` em Java  
- [ ] Ele define uma propriedade como inacessível para acessos de fora da classe ou de classes que não estão herdando dela  
- [ ] Ele define um método como inacessível para acessos de fora da classe ou de classes que não estão herdando dela  
- [ ] Nenhuma das alternativas  

---
