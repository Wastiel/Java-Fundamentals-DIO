# Java e a Arte da Abstração com Classes e Encapsulamento

## Criando a primeira classe

O que é uma classe?
Na programação orientada a objetos, a gente pega coisas do mundo real e representa dentro do nosso software. A forma como fazemos isso é criando classes.

Pensa numa linha de produção de potes. Você tem uma forma onde coloca o material ainda mole, e essa forma dá o formato final ao pote. Ou seja, a forma é o molde. Tudo que passar por ela vai sair com o mesmo formato, só mudando talvez a cor, o tamanho, o peso... Mas a estrutura é a mesma.

Na programação, essa forma é a classe. Ela define o que um tipo de objeto vai ter e fazer. Por exemplo, se quisermos representar uma pessoa, criamos uma classe chamada Person (Pessoa). Toda pessoa criada por essa classe vai ter as mesmas características básicas, como nome, idade, altura etc.


✅ Entendendo os conceitos de Objeto/Classe com base na classe Person

```java
public class Person {

    private String name;
    private int age;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

}
```

---
🟩 public, private, void, static — o que significam?
- public: significa que algo é público, ou seja, pode ser acessado de qualquer lugar do programa. Ex: public class Person ou public String getName().
- private: significa que algo é privado, ou seja, só pode ser acessado dentro da própria classe. Ex: private String name — outras classes não conseguem acessar esse atributo diretamente, só usando os métodos get e set.
- void: é usado quando um método não retorna nenhum valor. Ex: public void setName(String name) — ele altera o nome, mas não devolve nada.
- static: indica que o método ou atributo pertence à classe e não ao objeto. Ou seja, você não precisa criar um objeto para usar.
    - ⚠ Métodos static não têm acesso direto a atributos ou métodos não-static (como name e age), porque esses pertencem a objetos específicos.

Exemplo de método static:

```java
public static void dizerOla(){
    System.out.println("Olá!");
}

```

Você chama ele assim, sem precisar criar um objeto:

```java
Person.dizerOla();
```

---

🟩 Construtor
- O construtor é um método especial que é chamado automaticamente quando criamos um novo objeto da classe.
- Ele tem o mesmo nome da classe e não tem tipo de retorno.


```java
public Person(String name){
    this.name = name;
}
```

QUando realizamos o código abaixo Ele executa o construtor e já define o nome da pessoa como "Maria": 

```java
Person p = new Person("Maria");
```
---

🟩 final — constante
- A palavra-chave final é usada para criar constantes, ou seja, valores que não podem ser alterados depois de definidos.
- Pode ser usado em variáveis, métodos ou classes.

Como no exemplo abaixo country sempre será "Brasil". Você não pode mudar ele depois da criação.
```java
public class Person {
    private final String country = "Brasil";
}
```
Outra forma (Depois do ocorrido abaixo o id nunca mais pode ser alterado.):

```java
private final int id;

public Person(int id) {
    this.id = id; // Só pode definir aqui, no construtor
}
```

---

🟩 Getters e Setters
- Getters são usados para pegar/consultar valores de atributos privados.
- Setters são usados para alterar esses valores, mas com controle (ex: verificar se a idade é válida antes de aceitar).

```java
public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}
```

---

🔵 Outros conceitos úteis:
- ➕ Sobrecarga de construtor (Overload)
Você pode ter mais de um construtor na mesma classe:

```java
public Person(String name) {
    this.name = name;
}

public Person(String name, int age) {
    this.name = name;
    this.age = age;
}

```

---

➕ Encapsulamento
- É a ideia de proteger os dados do objeto, tornando atributos privados e usando métodos públicos (get/set) para acessá-los de forma segura.

---

Exemplo simples de classe usando as estruturas explicadas acima: 

```java
public class Person {
    private String name;
    private int age;
    private final String country = "Brasil"; // constante

    public Person(String name) {
        this.name = name;
    }

    // Método static - não precisa de objeto para chamar
    public static void saudacao() {
        System.out.println("\nOlá! Seja bem-vindo!");
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter para o final
    public String getCountry() {
        return country;
    }
}

```

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando uma pessoa com nome via entrada do usuário
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        Person pessoa = new Person(nome); // usando o construtor

        // Definindo a idade com o setter
        System.out.print("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();
        pessoa.setAge(idade);

        // Mostrando os dados da pessoa
        System.out.println("\nInformações da pessoa:");
        System.out.println("Nome: " + pessoa.getName());
        System.out.println("Idade: " + pessoa.getAge());

        // Usando um método static sem precisar criar objeto
        Person.saudacao();

        scanner.close();
    }
}
```



🔍 O que esse exemplo mostra?
- Uso do método main para iniciar o programa.
- Criação de objeto com o construtor.
- Uso de getter e setter para acessar e alterar dados.
- final: country nunca pode mudar.
- static: método saudacao() chamado direto pela classe.
- Entrada do usuário com Scanner.


## Trabalhanco com Records

## Questionário - Java e a Arte da Abstração com Classes e Encapsulamento



