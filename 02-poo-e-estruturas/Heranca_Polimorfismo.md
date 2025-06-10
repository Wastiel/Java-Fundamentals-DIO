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

Esses conceitos ajudam a organizar e entender os princípios da orientação a objetos.

## 