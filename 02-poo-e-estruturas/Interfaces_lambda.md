
# Interfaces e Lambda

## 🧬 Interfaces em Java

Interfaces em Java são uma forma de garantir que uma classe implemente certos métodos, sem definir como esses métodos funcionam. Elas funcionam como **contratos**: quem implementa uma interface é **obrigado a fornecer as implementações dos métodos definidos nela**.

---

### 📌 Características principais das interfaces

- **Não possuem implementação de métodos** (exceto métodos `default` e `static`, desde o Java 8).
- Todos os métodos são implicitamente:
  - `public`
  - `abstract` (a não ser que seja `default` ou `static`)
- Todas as variáveis são implicitamente:
  - `public`
  - `static`
  - `final`
- **Não têm construtores** (não podem ser instanciadas).
- Uma **classe pode implementar várias interfaces** (ao contrário da herança de classes, que é única).
- **Classes anônimas** podem ser usadas para implementar interfaces no momento da execução.
- Interfaces **não são classes abstratas**, embora também possam ter métodos não implementados.

---

### 💡 Diferença entre Interface e Classe Abstrata

| Característica               | Interface                           | Classe Abstrata              |
|-----------------------------|--------------------------------------|------------------------------|
| Métodos                     | Apenas assinatura (sem corpo)        | Pode ter métodos com corpo   |
| Herança múltipla            | Permitida                            | Não permitida                |
| Construtor                  | Não tem                              | Pode ter                     |
| Atributos                   | Sempre `public static final`         | Pode ter qualquer modificador|
| Implementação               | Obrigatória em classes concretas     | Pode ou não ser sobrescrita  |

---

## 🎧 Exemplo de Interfaces

```java
public interface MusicPlayer {
    void playMusic();
    void pauseMusic();
    void stopMusic();
}

public interface VideoPlayer {
    void playVideo();
    void pauseVideo();
    void stopVideo();
}
```

---

## 📱 Classe que implementa múltiplas interfaces

```java
public class SmartPhone implements MusicPlayer, VideoPlayer {

    @Override
    public void playMusic() {
        System.out.println("O smartphone está tocando música");
    }

    @Override
    public void pauseMusic() {
        System.out.println("O smartphone está pausando a música");
    }

    @Override
    public void stopMusic() {
        System.out.println("O smartphone parou a música");
    }

    @Override
    public void playVideo() {
        System.out.println("O smartphone está tocando um vídeo");
    }

    @Override
    public void pauseVideo() {
        System.out.println("O smartphone está pausando o vídeo");
    }

    @Override
    public void stopVideo() {
        System.out.println("O smartphone parou o vídeo");
    }
}
```

---

## 🔄 Lambda e Interfaces Funcionais (spoiler)

Interfaces com **um único método abstrato** podem ser usadas com **expressões lambda**, como:

```java
@FunctionalInterface
public interface Operacao {
    int executar(int a, int b);
}

Operacao soma = (a, b) -> a + b;
System.out.println(soma.executar(2, 3)); // Saída: 5
```

---

## ✅ Resumo Final

- Interfaces definem **o que uma classe deve fazer**, mas **não como**.
- São ideais quando você precisa aplicar **herança múltipla de comportamentos**.
- Muito usadas para **polimorfismo**, **inversão de dependência**, **testes**, e **eventos**.

---

## Interfaces Funcionais

A classe list é uma interface. Se criarmos uma variavel lista a gente vai criar uma classe através de uma interface

Interface tem que ter um metodo para implementar somente um e o resto vai ser default. 

Lambda, o que é lambda? 


# ☕ Interfaces Funcionais e Lambda em Java

## 🧩 O que é uma Interface Funcional?

Uma **interface funcional** em Java é uma interface que possui **apenas um método abstrato**.

Isso é importante porque **expressões lambda** só funcionam com esse tipo de interface!

### ✅ Exemplo de Interface Funcional:

```java
@FunctionalInterface
public interface Operacao {
    int executar(int a, int b);
}
```

> ⚠️ Ela pode ter outros métodos `default` ou `static`, mas **só um método abstrato é permitido**.

---

## ⚡ O que é uma expressão Lambda?

Uma **expressão lambda** é uma forma **compacta e elegante** de implementar uma interface funcional **sem criar uma classe anônima ou concreta**.

### 🧠 Sintaxe básica:

```java
(parâmetros) -> { corpo }
```

---

### 📌 Exemplo com Lambda

```java
Operacao soma = (a, b) -> a + b;
System.out.println(soma.executar(2, 3)); // Saída: 5
```

---

## 🎓 Relação com a interface `List`

```java
List<String> nomes = new ArrayList<>();
```

- `List` é uma **interface**.
- `ArrayList` é uma **classe concreta** que a implementa.
- Quando você escreve `List<String> nomes = new ArrayList<>();`, você está **criando uma variável com o tipo da interface** e **instanciando uma classe que implementa essa interface**.

> Isso é um exemplo de **programação orientada à interface**, o que favorece o **polimorfismo**.

---

## 🧪 Aplicação com métodos de coleção

Você pode usar **lambdas** com coleções Java como `List`, especialmente com métodos como `.forEach()` e `.removeIf()`:

```java
List<String> nomes = List.of("Ana", "Beto", "Carlos");

nomes.forEach(nome -> System.out.println("Olá, " + nome));
```

---

## 🧠 Comparando: classe anônima vs lambda

### 🔸 Classe anônima:

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Executando!");
    }
};
```

### 🔹 Lambda (versão simplificada):

```java
Runnable r = () -> System.out.println("Executando!");
```

> Ambas funcionam, mas a lambda é mais limpa e moderna!

---

## ✅ Conclusão

- Interfaces funcionais têm **apenas um método abstrato**.
- Lambdas são **funções anônimas** que implementam esse método.
- **List é uma interface**, e você sempre instancia uma classe concreta como `ArrayList` para usá-la.
- Interfaces com métodos `default` não impedem o uso de lambdas, desde que haja **só um método abstrato**.

---

## Entendendo algumas KeyWords
