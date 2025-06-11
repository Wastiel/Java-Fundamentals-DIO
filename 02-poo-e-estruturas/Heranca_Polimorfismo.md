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

cast de um timpo para outro tipo

verifica instancia:  if(employee instanceof Manager)

Verifica pega as propriedades do manager ((Manager) employee).setPassword("123456");

No java 17,mmudou para 

if(employee instanceof Manager manager) {
            employee.setName("João");
            manager.setLogin("joao");
            manager.setPassword("123456");

            System.out.println(employee.getName());
            System.out.println(manager.getLogin());
            System.out.println(manager.getPassword());

        }

System.out.printf("-----%s-----\n", employee.getClass().getCanonicalName());


```java
package HerancaPolimorfismo;

public class Main {

    public static void main(String[] args){

        Employee manager = new Manager();

        printEmployee(new Manager());
        printEmployee(new Salesman());
    }

    public static void printEmployee(Employee employee){

        System.out.printf("-----%s-----\n", employee.getClass().getCanonicalName());
        if(employee instanceof Manager manager) {


        }

        switch (employee){
            case Manager manager ->{
                manager.setCode("123");
                manager.setName("João");
                manager.setSalary(5000);
                manager.setLogin("joao");
                manager.setPassword("123456");
                manager.setCommission(15);;

                System.out.println(manager.getCode());
                System.out.println(manager.getSalary());
                System.out.println(manager.getName());
                System.out.println(manager.getCommission());
                System.out.println(manager.getLogin());
                System.out.println(manager.getPassword());
            }
            case Salesman salesman ->{
                salesman.setCode("123");
                salesman.setName("Lucas");
                salesman.setSalary(2800);
                salesman.setPercentPerSold(10);

                System.out.println(salesman.getCode());
                System.out.println(salesman.getSalary());
                System.out.println(salesman.getName());
                System.out.println(salesman.getPercentPerSold());
            }
        }
        System.out.println("----------");
    }
}
```

So ta permitindo um case sem default pq a nossa classe está selada. 

record nao pode ter clausula extends

record nao pode ter propridades dentro dele, a nao ser static e o que for static nao pode passar por herança.

public Manager(String code,
                   String name,
                   String address,
                   String age,
                   double salary,
                   String login,
                   String password,
                   double commission) {
        super(code, name, address, age, salary);
        this.login = login;
        this.password = password;
        this.commission = commission;
    }

    Sempre que vermos super é em uma cadeia de herança é para acionar um comprotamento da classe pai. 


    sobrescrita

        @Override
    public String getCode(){
        return "SL" + super.getCode();
    }

    COnseguimos sobrescrever um compoirtamento da nossa classe utilizando um comportamento da nossa classe abstrata, sendo opicional

    Se precisarmos acessar diretamente um atributo privado na cadeia de herança 

    protected ele é mais restritivo publico e mais acesso que o privated. Nao permite acesso de fora da sua classe a nao ser que a classe que está acessando este código está herdando.

    consegue acessar propriedades dentro do mesmo package

    metodo abstrato que nao tem corpo, mas ele esta ali, a responsabilidad de fazer este método é de quem heerda ele.

    pelo fato de ser abstrato a nossa função abaixo pode ser chamada no main:
        @Override
    public double getFullSalary(){
        return this.salary + (souldAmount * percentPerSold / 100);
    }


    Abaixo é sobrecarga de método, podemos ter quantas assinaturas quisermos. mesmo nome com comportamentos diferentes. 

        @Override
    public double getFullSalary(){
        return this.salary + this.commission;
    }

    public double getFullSalary(double extra){
        return this.salary + this.commission;
    }

    Sobre escrita é quando pegamos um comportamento da classe pai e alteramos na classe filho

    

    