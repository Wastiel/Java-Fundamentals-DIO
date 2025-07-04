
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

## Entendendo algumas KeyWords Java

# 🔑 Entendendo algumas Keywords em Java

## 🧭 1. Modificadores de Acesso

### `public`
- Permite que **qualquer classe** acesse o elemento (atributo, método ou classe).
- Visível **em qualquer lugar do projeto**.

### `default` (sem modificador)
- Quando **nenhum modificador é declarado**, o acesso é considerado **default**.
- Só é acessível **dentro do mesmo pacote**.

### `protected`
- Acesso **no mesmo pacote** **e** também para **subclasses (herança)** mesmo que estejam em outro pacote.

### `private`
- Acesso **restrito apenas à própria classe**.
- Nem mesmo subclasses ou classes do mesmo pacote conseguem acessar.

---

## 📦 2. `package`

- Define **o agrupamento lógico das classes**.
- Ajuda na organização e encapsulamento.
- Exemplo:
  
  ```java
  package br.com.meusistema.utils;
  ```

---

## ⚙️ 3. `static` vs `non-static`

### `static`
- Pertence à **classe** e **não à instância**.
- Compartilhado entre todas as instâncias.
- Útil para **métodos utilitários** e **constantes**.
  
  ```java
  public static int contador;
  ```

### `não-static` (instância)
- Pertence a **cada objeto** criado.
- Valores são **independentes** para cada instância da classe.

---

## 🧪 Exemplo:

```java
public class Exemplo {
    public static int total; // comum a todas as instâncias
    public int individual;   // cada instância tem o seu
}
```

---

## 🔒 4. `final`

- Indica que algo **não pode ser alterado**:

| Onde é usado     | O que significa                         |
|------------------|------------------------------------------|
| variável         | valor não pode ser modificado (constante)|
| método           | não pode ser sobrescrito (override)      |
| classe           | não pode ser estendida (herdada)         |

---

## 📥 5. Importação Estática (`import static`)

- Permite importar **métodos estáticos** ou **constantes** diretamente, sem precisar prefixar com a classe.

```java
import static java.lang.Math.*;

System.out.println(sqrt(25)); // não precisa escrever Math.sqrt()
```

---

## ✅ Conclusão

Essas keywords são essenciais para entender:

- **Encapsulamento e visibilidade (`public`, `protected`, `private`, `default`)**  
- **Comportamento compartilhado ou exclusivo (`static` vs não-static)**  
- **Segurança e imutabilidade (`final`)**  
- **Organização de código (`package`, `import static`)**

# Quiz de Interfaces


### 1. Qual a diferença na relação de interfaces e classes abstratas com classes concretas e records?

- [ ] Records podem implementar quantas interfaces quiser e 1 classe concreta por vez e classes só podem implementar interfaces  
- [ ] Nenhuma das alternativas  
- [ ] Somente records podem implementar interfaces e classes abstratas  
- ✅ **Records só podem implementar interfaces, enquanto classes podem implementar 1 classe por vez e quantas interfaces quiser**  
- [ ] Somente classes podem implementar interfaces e classes abstratas  

---

### 2. Qual a função da anotação `@FunctionalInterface`?

- [ ] Marcar uma interface como interface funcional, ela é obrigatória para definir uma interface funcional  
- [ ] Define que uma interface pode ser usada como lambda  
- [ ] Marca um método que pode receber uma interface funcional como parâmetro  
- ✅ **Marcar uma interface como interface funcional, porém não é requisito obrigatório para interface ser considerada funcional, porém irá gerar erros se colocada em uma interface que não atende os requisitos de uma**  
- [ ] Nenhuma das alternativas  

---

### 3. Qual das características **não** são de uma interface?

- [ ] Métodos concretos devem ser `default`  
- [ ] Métodos não `default` devem ser abstratos  
- [ ] Não pode definir construtores  
- [ ] Podem ser implementadas por records  
- ✅ **Nenhuma das alternativas**  

---

### 4. Qual a diferença de uma interface e uma interface funcional?

- [ ] Ela deve ser instanciada como classe anônima  
- [ ] Nenhuma das alternativas  
- [ ] Ela deve ser marcada com a anotação `@FunctionalInterface`  
- [ ] Para a interface ser considerada interface funcional ela deve ter somente um método `default`, porém pode ter quantos métodos que exigem implementação quiser  
- ✅ **Para a interface ser considerada interface funcional ela deve ter somente um método que exige implementação, porém ela pode ter quantos métodos `default` quiser**  

---

## Exercicios

1. - Escreva um código para enviar mensagens de marketing, para isso você deve ter a possibilidade de enviar a mesma mensagem para serviços diferentes, esses serviços devem ter um método para receber a mensagem como parâmetro, os serviços que devem estar disponíveis são:

SMS;
E-mail;
Redes Sociais;
WhatsApp;

2. - Escreva um código que calcule o valor de tributos de produtos, os produtos disponíveis devem ser dos seguintes tipos: Alimentação, Saude e bem estar, Vestuário e Cultura. Todos os produtos devem ter um método para retornar o seu valor de imposto, de acordo com seu tipo:

Alimentação 1%;
Saude e bem estar 1.5%;
Vestuário 2.5%;
Cultura 4%.

3. - Escreva um código onde seja possível calcular a área de uma figura geométrica, todas devem ter um método que retorne esse valor, as formas geométricas disponiveis devem ser as seguintes:

Quadrado: possui o valor dos seus lados;
Retângulo: possui os valores de base e altura;
Circulor: possui o atributo raio.