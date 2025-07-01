
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

Se quiser, posso adicionar exemplos com `default`, `static`, ou `@FunctionalInterface` também!
