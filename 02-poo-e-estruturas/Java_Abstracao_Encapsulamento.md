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

## 📌 O que é um `record`?

O `record` foi introduzido no Java 14 como uma forma simplificada de declarar **classes imutáveis**, muito útil para representar objetos de dados (como DTOs, respostas de APIs, etc).

### ✅ Características principais:

- Ideal para **objetos imutáveis**
- Todos os atributos são `private final` e **só leitura**
- Não permite `setters`
- Gera automaticamente:
  - Construtor
  - Métodos `get` com o nome do campo (ex: `nome()`)
  - `equals`, `hashCode` e `toString`
- Permite declarar **métodos adicionais**
- Permite construtores:
  - Compactos (com validações)
  - Secundários (com sobrecarga)

---

## 🧪 Exemplo prático: `Pessoa`

### Usando `record`:

```java
public record Pessoa(String nome, int idade) {

    // Construtor compacto: usado para validação ou lógica extra
    public Pessoa {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa");
        }
    }

    // Método adicional
    public String saudacao() {
        return "Olá, " + nome + "!";
    }

    // Construtor secundário (sobrecarga)
    public Pessoa(String nome) {
        this(nome, 0); // idade padrão = 0
    }
}
```

### Uso no código:

```java
public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("João", 25);
        Pessoa p2 = new Pessoa("Ana");

        System.out.println(p1.nome()); // João
        System.out.println(p1.idade()); // 25
        System.out.println(p1.saudacao()); // Olá, João!

        // p1.nome = "Carlos"; // ❌ Erro! Campos são imutáveis
    }
}
```

---

## 🔁 Comparação com classe tradicional

### Classe comum (sem `record`):

```java
public class Pessoa {
    private final String nome;
    private final int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }

    // toString, equals, hashCode... precisam ser gerados manualmente
}
```

Com `record`, eliminamos a repetição de código e ganhamos um estilo mais funcional.

---

## 🎯 Quando usar um `record`?

✅ Use `record` quando:
- Você quer **objetos de dados simples e imutáveis**
- Precisa de uma estrutura leve, com validação opcional
- Está lidando com **DTOs**, respostas de APIs, registros lógicos

🚫 Evite usar `record` quando:
- Precisa de herança ou lógica interna complexa
- Precisa modificar os dados após a criação (mutabilidade)
- Precisa implementar interfaces com muito estado ou comportamento

---

## 📎 Observações

- `record` **não pode estender outras classes**, mas pode implementar interfaces.
- Todos os campos declarados são automaticamente utilizados no construtor.
- Você **não pode criar novos campos** dentro do corpo do `record`.

---


## Questionário - Java e a Arte da Abstração com Classes e Encapsulamento

# Quiz de Java - Fundamentos da Programação Orientada a Objetos

---

### 1. Como chamamos o construtor padrão de uma classe no Java?

- [ ] Object.new();
- [ ] Object();
- [ ] Object.constructor();
- [ ] Nenhuma das anteriores
- ✅ **new Object();**

---

### 2. O que é um objeto?

- [ ] É uma estrutura que define características e comportamentos de classes criados a partir dela  
- [ ] É o método que usamos para realizar a leitura de uma propriedade da classe  
- [ ] É o método que usamos para realizar a escrita de uma propriedade da classe  
- [ ] Nenhuma das anteriores  
- ✅ **É a instância de uma classe, uma variável criada a partir da classe que tem todas as suas características e comportamentos**

---

### 3. O que é encapsulamento?

- [ ] É um tipo especial do Java que definimos seu valor uma vez e não poderá mais ser alterado  
- [ ] É uma técnica que usamos para esconder as propriedades de nossa classe e só permitir acesso pelos métodos getter e setter da propriedade  
- [ ] Nenhuma das anteriores  
- [ ] Técnica que usamos para agrupar informações relacionadas para a partir disso definir um objeto  
- ✅ **É a técnica que usamos para esconder as propriedades de nossa classe e somente disponibilizar o acesso as mesmas seguindo as regras de negócio do nosso software**

---

### 4. O que é uma classe?

- [ ] É uma instancia criada a partir do objeto, com todas as suas características e comportamentos  
- ✅ **É uma estrutura que define características e comportamentos de objetos criados a partir dela**  
- [ ] Nenhuma das anteriores  
- [ ] É o método que usamos para realizar a escrita de uma propriedade do objeto  
- [ ] É o método que usamos para realizar a leitura de uma propriedade do objeto  


# Exercícios: Classes e Encapsulamento

# Exercícios

## todos os execicios devem ter um menu de interativo para chamar as funções e ter uma opção de sair para finalizar a execução

1. Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
    - Consultar saldo
    - consultar cheque especial
    - Depositar dinheiro;
    - Sacar dinheiro;
    - Pagar um boleto.
    - Verificar se a conta está usando cheque especial.

Siga as seguintes regras para implementar
   - A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
   - O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
   - Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
   - Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
   - Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.

- [Resultado da ativiodade criada do zero](./Exercicios_Abstracao_Encapsulamento/ContaBancaria/)
- [Resultado da ativiodade refatorada com dicas do GPT](./Exercicios_Abstracao_Encapsulamento/ContaBancaria_Refatorada/)
--------

2. Escreva um código onde controlamos as funções de um carro, ele deve ter as seguintes funções:
   - Ligar o carro;
   - Desligar o carro;
   - Acelerar;
   - diminuir velocidade;
   - virar para esquerda/direita
   - verificar velocidade;
   - trocar a marcha

Siga as seguintes regras na implementação
  - Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade em 0
  - O carro desligado não pode realizar nenhuma função;
  - Quando o carro for acelerado ele deve incrementar 1km em sua velocidade (pode chegar no máximo a 120km);
  - Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade (pode chegar no minimo a 0km);
  - o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
  - A velocidade do carro deve respeitar os seguintes limites para cada velocidade
     - se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar
     - se estiver na 1ª marcha sua velocidade pode estar entre 0km e 20km
     - se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km
     - se estiver na 3ª marcha sua velocidade pode estar entre 41km e 60km
     - se estiver na 4ª marcha sua velocidade pode estar entre 61km e 80km
     - se estiver na 5ª marcha sua velocidade pode estar entre 81km e 100km
     - se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km
   - O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em 0 km
   - O carro só pode virar para esquerda/direita se sua velocidade for de no mínimi 1km e no máximo 40km;

- [Resultado da ativiodade criada do zero](./Exercicios_Abstracao_Encapsulamento/Carro/)
- [Resultado da ativiodade refatorada com dicas do GPT](./Exercicios_Abstracao_Encapsulamento/Carro_Refatorado/)

-------------

3. Escreva um código onde temos o controle de banho de um petshop, a maquina de banhos dos pets deve ter as seguintes operações:
   - Dar banho no pet;
   - Abastecer com água;
   - Abastecer com shampoo;
   - verificar nivel de água;
   - verificar nivel de shampoo;
   - verificar se tem pet no banho;
   - colocar pet na maquina;
   - retirar pet da máquina;
   - limpar maquina.

Siga as seguintes regras para implementação

   - A maquina de banho deve permitir somente 1 pet por vez;
   - Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
   - A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
   - Se o pet for retirado da maquina sem estar limpo será necessário limpar a máquina para permitir a entrada de outro pet;
   - A limpeza da máquina ira consumir 3 litros de água e 1 litro de shampoo;
   - O abastecimento de água e shampoo deve permitir 2 litros por vez que for acionado;

- [Resultado da ativiodade criada do zero](./Exercicios_Abstracao_Encapsulamento/PetShop/)
- [Resultado da ativiodade refatorada com dicas do GPT](./Exercicios_Abstracao_Encapsulamento/PetShopRefatorado/)

## Questionário

# Quiz de Java - Fundamentos da Programação Orientada a Objetos

---

### 1. Como chamamos o construtor padrão de uma classe no Java?

- [ ] Object.new();
- [ ] Object();
- [ ] Object.constructor();
- [ ] Nenhuma das anteriores  
- ✅ **new Object();**

---

### 2. O que é um `record` no Java?

- [ ] É um tipo do Java que serve para armazenar o estado atual da sua aplicação  
- ✅ **É um tipo de classe introduzido no Java que por padrão tem um construtor com argumento e uma vez instanciada não pode mais ter suas propriedades alteradas, é uma classe imutável**  
- [ ] É um tipo de classe no Java com um construtor sem argumentos, que depois de definir a primeira vez uma propriedade via setter, ela não pode mais ser alterada, uma classe imutável  
- [ ] Nenhuma das anteriores  
- [ ] É uma forma mais enxuta de se criar classes e pode substituir totalmente o antigo padrão usando a keyword class  

---

### 3. Como declarar um objeto da classe `Pessoa` em Java?

- ✅ **Pessoa pessoa = new Pessoa();**  
- [ ] new Pessoa pessoa;  
- [ ] Pessoa pessoa = Pessoa();  
- [ ] Pessoa pessoa; pessoa = Pessoa();  
- [ ] Pessoa pessoa();  

---

### 4. Considere o seguinte código:

```java
public class Person {
    private String name;
    // considerar que existe o get e set da propriedade name
}

final var person = new Person();
person.setName("João");
System.out.println(person.getName());
```

Qual será o resultado da execução?

- [ ] O código não roda porque a classe Person não tem um construtor definido  
- [ ] O código não roda porque a variável person é final e não pode ter seus valores alterados  
- [ ] O código irá rodar, porém o nome será nulo porque a variável person é imutável  
- ✅ **O objeto person é instanciado como final (imutável), sua propriedade name recebe o valor de “João” (pois o objeto é final, mas sua propriedade não é) e é exibido no console**  
- [ ] Nenhuma das anteriores  

---

### 5. Qual a função da keyword `final` no Java?

- [ ] Usamos a keyword final para marcar o final de um método void  
- [ ] Nenhuma das anteriores  
- [ ] Java não trabalha com keyword final, para valores constantes devemos usar const  
- ✅ **Essa keyword torna uma variável ou propriedade imutável. No caso de variáveis, ela recebe um valor e não poderá mais ser alterado. Para propriedades de uma classe, a mesma só pode ser definida via construtor e irá assumir durante todo ciclo de vida da classe**  
- [ ] É uma keyword usada para marcar o final do ciclo de vida de uma variável no fluxo do código  
