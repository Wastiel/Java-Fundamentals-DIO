# Praticando com Collections e outras cosias úteis do java


# 🧾 Listagens e Coleções em Java

## 📦 Arrays

- Devem ser **inicializados com tamanho fixo**.
- A contagem de posições **sempre começa em 0**.
- Exemplo:
  ```java
  int[] numeros = new int[5]; // posições de 0 a 4
  ```

---

## 📚 Listas em Java (Interface `List`)

A interface `List` permite trabalhar com coleções de forma dinâmica, diferentemente dos arrays fixos.

### Métodos comuns:
- `add(element)`: adiciona elemento
- `contains(element)`: verifica se existe
- `size()`: retorna o tamanho
- `isEmpty()`: verifica se está vazia
- `get(index)`: retorna o item da posição
- `equals(list2)`: compara listas

---

## 🔢 `ArrayList`

- Baseada em um **array dinâmico**.
- Mais eficiente em operações de **leitura/acesso rápido** (`get(index)`).
- **Desempenho menor** para inserções/remoções no meio da lista.

### Exemplo:
```java
List<String> nomes = new ArrayList<>();
nomes.add("Ana");
```

---

## 🔗 `LinkedList`

- Baseada em **lista duplamente encadeada**.
- Melhor desempenho para **inserções/remoções** frequentes, especialmente no início ou meio da lista.
- Acesso por índice (`get(index)`) é mais lento.

---

## 💥 `Vector`

- Semelhante ao `ArrayList`, mas:
  - É **síncrono**, ou seja, **thread-safe**.
  - Ideal para **ambientes com múltiplas threads**.
  - Mais lento que `ArrayList` em operações simples, pois sincroniza acesso.

---

## 🧬 Tipo `Object`

- É a **superclasse de todas as classes** em Java.
- Todas as classes herdam de `Object`, o que permite tratar qualquer tipo como objeto.
- Métodos comuns herdados:
  - `toString()`
  - `equals()`
  - `hashCode()`

---

# 🌳 Trabalhando com `Set` em Java

## 🔐 Interface `Set<>`

- Um `Set` é uma **coleção que não permite elementos duplicados**.
- Cada elemento no `Set` **deve ser único**.
- Interfaces comuns que implementam `Set`:
  - `HashSet`
  - `LinkedHashSet`
  - `TreeSet`

---

## 🚀 Como o `Set` garante unicidade?

- A maioria das implementações de `Set`, como o `HashSet`, utiliza o **método `hashCode()`** para acelerar buscas e detectar duplicações.
- Para isso, os métodos `equals()` e `hashCode()` devem estar **bem implementados** nos objetos inseridos.

---

## 📌 Diferença entre `equals` e `hashCode`

### `equals()`
- Compara a **igualdade lógica** entre dois objetos.
- Exemplo: dois objetos com mesmo CPF, nome e idade podem ser considerados "iguais".

### `hashCode()`
- Gera um número inteiro que representa o **código hash** do objeto.
- Usado por estruturas como `HashSet` e `HashMap` para **localizar rapidamente** um item.
- Objetos diferentes podem, em **casos raros**, ter o mesmo hashCode (colisão).

---

## 🌲 `TreeSet`

- `TreeSet` é uma implementação de `Set` que **mantém os elementos ordenados**.
- Internamente, usa uma **árvore binária de busca** (Red-Black Tree).
- Requer que os objetos inseridos sejam **comparáveis**.

### Como funciona a ordenação?
- Os elementos precisam implementar a interface `Comparable` **ou** fornecer um `Comparator`.
- O método `compareTo()` determina a ordenação dos elementos.

```java
public class Produto implements Comparable<Produto> {
    private String nome;
    private double preco;

    @Override
    public int compareTo(Produto outro) {
        return this.nome.compareTo(outro.nome); // ordena por nome
    }
}
```

---

## 🎯 Boas práticas

- Avaliar **quais atributos** devem influenciar o resultado de `equals()` e `hashCode()`.
- Considerar usar **apenas atributos imutáveis** para garantir a integridade da coleção.

---
# Questionario: Revisando Collections e Set

### 1. Qual das alternativas descreve corretamente o funcionamento do método `add` em um `ArrayList`?

- [ ] Insere um elemento e duplica o tamanho do array interno imediatamente.  
- [ ] Insere um elemento somente se ele não for nulo.  
- [ ] Insere um elemento e organiza automaticamente a lista em ordem crescente.  
- [ ] Insere um elemento sempre na posição inicial da lista.  
- ✅ **Insere um elemento na posição final da lista e redimensiona o array interno apenas quando necessário.**

---

### 2. Qual método é essencial para que um objeto funcione corretamente em coleções baseadas em `HashSet`?

- [ ] clone  
- [ ] toString  
- [ ] equalsIgnoreCase  
- ✅ **hashCode**  
- [ ] finalize

---

### 3. Qual implementação de `Set` mantém os elementos na ordem de inserção?

- [ ] ImmutableSet  
- [ ] ArraySet  
- ✅ **LinkedHashSet**  
- [ ] TreeSet  
- [ ] HashSet

---

### 4. Qual é a principal diferença entre `ArrayList` e `LinkedList` no Java?

- [ ] Ambas têm a mesma performance em todos os casos.  
- [ ] `ArrayList` é mais eficiente para operações de inserção e remoção em grandes volumes de dados.  
- ✅ **`ArrayList` é ideal para cenários com muitas buscas e poucas alterações estruturais.**  
- [ ] `LinkedList` não suporta elementos duplicados.  
- [ ] `LinkedList` usa um array interno para armazenar elementos.

---

# Trabalhando com Map

# 🧭 Uso do `Map` em Java — Estrutura de Dados e Transporte de Informações

## 📌 1. O que é o `Map<K, V>` em Java?

- A interface `Map<K, V>` representa uma **estrutura de chave-valor**.
- `K` representa o tipo da **chave**.
- `V` representa o tipo do **valor**.

Você pode usar qualquer tipo de objeto como chave e valor, mas há **boas práticas** para isso.

## ✅ Tipos recomendados como chave

- Objetos **imutáveis** (`String`, `Integer`, `UUID` etc).
- Objetos com `equals()` e `hashCode()` **corretamente implementados**.
- Para ordenação (`TreeMap`), os objetos devem ser `Comparable` ou ter um `Comparator`.

---

## 🎯 2. Qual a principal utilidade de um `Map`?

- Armazenar pares **chave-valor** com acesso rápido ao valor via chave.
- Ideal quando você precisa **buscar por identificador único**.

### Exemplo:

```java
Map<String, String> capitais = new HashMap<>();
capitais.put("Brasil", "Brasília");
capitais.put("França", "Paris");

System.out.println(capitais.get("França")); // Paris
```

---

## 🌲 3. O que é `TreeMap`?

- Implementação de `Map` que **mantém as chaves ordenadas**.
- Utiliza uma **árvore binária de busca (Red-Black Tree)**.
- As chaves devem implementar `Comparable` ou receber um `Comparator`.

### Exemplo:

```java
Map<String, String> ordenado = new TreeMap<>();
ordenado.put("C", "Letra C");
ordenado.put("A", "Letra A");
ordenado.put("B", "Letra B");

System.out.println(ordenado); // {A=Letra A, B=Letra B, C=Letra C}
```

---

## 📊 4. Comparativo entre implementações

| Implementação     | Ordem mantida       | Estrutura Interna     | Permite chave `null` |
|-------------------|----------------------|------------------------|------------------------|
| `HashMap`         | ❌ Não               | Tabela hash            | ✅ Sim (1 chave)       |
| `LinkedHashMap`   | ✅ Ordem de inserção | Hash + Lista ligada    | ✅ Sim                 |
| `TreeMap`         | ✅ Ordenação natural | Árvore binária         | ❌ Não                 |

---

## 🚀 5. `Map` como transporte de dados em APIs

### ❓ Pode usar `Map` para transportar dados em APIs?
**Sim**, mas **não é a melhor prática**.

### 🔥 Quando vemos `Map<String, Object>` em APIs?
Em frameworks como **Spring**, `Map` é usado para:
- Receber **JSONs dinâmicos** (`@RequestBody Map<String, Object>`)
- Retornar respostas rápidas **sem criar classes DTO**
- Evitar exposição direta de entidades de banco

### Exemplo:

```java
@PostMapping("/usuario")
public ResponseEntity<?> salvar(@RequestBody Map<String, Object> dados) {
    String nome = (String) dados.get("nome");
    Integer idade = (Integer) dados.get("idade");
    // processa os dados
}
```

---

## ⚠️ 6. Boas práticas: prefira `DTOs` a `Map`

| Ruim (`Map`)                      | Melhor (`DTO`)                          |
|----------------------------------|-----------------------------------------|
| Dados soltos e inseguros         | Dados validados por tipo e estrutura    |
| Difícil de validar               | Compilador e IDE ajudam na verificação  |
| Difícil de documentar/testar     | Ideal para Swagger/OpenAPI              |
| Exposição de atributos sensíveis | Controle total dos dados expostos       |

### Exemplo DTO:

```java
public record UsuarioDTO(String nome, String email) {}
```

---

## ✅ Conclusão

- `Map` é essencial como **estrutura de dados de chave-valor**.
- Pode ser usado como transporte de dados, mas **DTOs são preferíveis** por segurança, clareza e validação.
- Em APIs Java profissionais, `Map` deve ser **exceção**, não a regra.


## Tipos Primitivos e Wrapper Classes em Java

Em Java, existem duas maneiras de lidar com dados: **tipos primitivos** e **Wrapper Classes**.

-----

### Tipos Primitivos

Os tipos primitivos são os blocos de construção fundamentais de dados em Java. Eles representam valores simples, não são objetos e consomem menos memória.

**Características:**

  * **Básicos e Fundamentais:** Usados para valores simples.
  * **Não são Objetos:** Não possuem métodos associados.
  * **Eficiência de Memória:** Ocupam menos espaço na memória.

**Lista dos Tipos Primitivos:**

| Tipo      | Tamanho | Valor Padrão | Exemplo                       |
| :-------- | :------ | :----------- | :---------------------------- |
| `byte`    | 8 bits  | 0            | `byte idade = 25;`            |
| `short`   | 16 bits | 0            | `short pontos = 3000;`        |
| `int`     | 32 bits | 0            | `int numero = 10;`            |
| `long`    | 64 bits | `0L`         | `long populacao = 123456789L;` |
| `float`   | 32 bits | `0.0f`       | `float preco = 19.99f;`       |
| `double`  | 64 bits | `0.0`        | `double saldo = 1234.56;`     |
| `char`    | 16 bits | `'\u0000'`   | `char letra = 'A';`           |
| `boolean` | 1 bit   | `false`      | `boolean ativo = true;`       |

-----

### Wrapper Classes

As Wrapper Classes são classes que "embrulham" (encapsulam) os tipos primitivos em objetos. Elas pertencem ao pacote `java.lang` e permitem que os valores primitivos sejam tratados como objetos.

**Para que servem?**

  * **Coleções:** Estruturas de dados como `List`, `Set` e `Map` só aceitam objetos, não tipos primitivos. Por exemplo, `List<Integer>` é permitido, mas `List<int>` não.
  * **Métodos Utilitários:** Oferecem métodos úteis para conversão e manipulação de valores, como `Integer.parseInt("123")` ou `Double.valueOf("3.14")`.
  * **Representar `null`:** Tipos primitivos não podem ser `null`, mas suas Wrapper Classes sim, o que é útil para indicar a ausência de um valor.

**Tabela de Primitivos e Wrappers Correspondentes:**

| Primitivo | Wrapper   |
| :-------- | :-------- |
| `byte`    | `Byte`    |
| `short`   | `Short`   |
| `int`     | `Integer` |
| `long`    | `Long`    |
| `float`   | `Float`   |
| `double`  | `Double`  |
| `char`    | `Character` |
| `boolean` | `Boolean` |

-----

### Autoboxing e Unboxing

Java facilita a transição entre tipos primitivos e Wrapper Classes através de dois mecanismos automáticos:

  * **Autoboxing (primitivo → objeto):** Ocorre quando um tipo primitivo é automaticamente convertido para sua Wrapper Class correspondente.
    ```java
    int idade = 30;
    Integer idadeWrapper = idade; // Autoboxing
    ```
  * **Unboxing (objeto → primitivo):** Ocorre quando uma Wrapper Class é automaticamente convertida para seu tipo primitivo correspondente.
    ```java
    Integer pontos = 100;
    int valor = pontos; // Unboxing
    ```

-----

### Boas Práticas

  * **Priorize Primitivos:** Sempre que possível, use **tipos primitivos**, pois são mais eficientes em termos de velocidade e uso de memória.
  * **Use Wrappers em Contextos Específicos:** Recorra às **Wrapper Classes** quando precisar trabalhar com coleções ou quando a ausência de um valor precisar ser representada por `null`.
  * **Evite Misturas Desnecessárias:** Não misture primitivos e Wrappers no mesmo contexto sem um motivo claro, pois isso pode levar a operações de autoboxing/unboxing desnecessárias e impactar a performance.

-----

Claro! Aqui estão as perguntas que você pediu formatadas em Markdown conforme o modelo indicado:

---
### 1. O que é autoboxing em Java?

* [ ] É um mecanismo que impede o uso de valores nulos em Wrappers.
* [ ] É a criação automática de objetos a partir de qualquer valor literal.
* ✅ **É o processo de converter um tipo primitivo em seu tipo Wrapper.**
* [ ] É a capacidade de realizar operações matemáticas com Wrappers.
* [ ] É o processo de converter um tipo Wrapper em seu tipo primitivo.

---

### 2. Qual implementação de `Map` mantém as chaves em ordem natural ou definida por um comparador?

* ✅ **TreeMap**
* [ ] HashMap
* [ ] LinkedHashMap
* [ ] ConcurrentHashMap
* [ ] WeakHashMap

---

### 3. Qual é a função do método `put` em um `Map`?

* [ ] Retorna o valor associado à chave fornecida.
* [ ] Remove a chave fornecida e o valor associado.
* [ ] Verifica se uma chave ou valor existe no `Map`.
* [ ] Ordena os pares chave-valor do `Map`.
* ✅ **Adiciona um par chave-valor ao `Map`, sobrescrevendo o valor anterior caso a chave já exista.**

---

### 4. Qual das opções abaixo **não** é um tipo primitivo em Java?

* [ ] `char`
* [ ] `boolean`
* ✅ **`Integer`**
* [ ] `double`
* [ ] `int`

---


## Classes String, StringBuilder e StringBuffer


### Classes String e StringBuffer

# 🧵 Strings em Java

As **Strings** em Java são objetos imutáveis, ou seja, uma vez criadas, não podem ser modificadas. Toda alteração em uma `String` gera um **novo objeto**.

A classe `String` pertence ao pacote `java.lang` e possui vários métodos úteis para manipulação de textos.

---

## ✂️ `substring(int beginIndex, int endIndex)`

Retorna uma nova string que é um **recorte** da original.

```java
String nome = "Java Developer";
String parte = nome.substring(0, 4); // "Java"
```

> `beginIndex` é inclusivo e `endIndex` é exclusivo.

---

## 🔁 `replace(CharSequence oldChar, CharSequence newChar)`

Substitui todas as ocorrências de um trecho por outro.

```java
String texto = "banana";
String novo = texto.replace("a", "o"); // "bonono"
```

---

## ✂️🔁 `replaceAll(String regex, String replacement)`

Semelhante ao `replace`, mas aceita expressões regulares:

```java
String dados = "123-456-789";
String limpo = dados.replaceAll("-", ""); // "123456789"
```

---

## 💨 `split(String regex)`

Divide uma `String` com base em um separador (regex) e retorna um array:

```java
String csv = "João,Maria,José";
String[] nomes = csv.split(",");

// nomes[0] = "João"
// nomes[1] = "Maria"
// nomes[2] = "José"
```

---

## 🤪 `equals(String anotherString)` e `equalsIgnoreCase`

Compara o conteúdo de duas Strings:

```java
"Java".equals("Java")           // true
"Java".equals("java")           // false
"Java".equalsIgnoreCase("java") // true
```

---

## 🪄 `trim()`

Remove espaços em branco do início e do fim da string:

```java
String nome = "   Ana   ";
nome.trim(); // "Ana"
```

---

## 🔤 `toUpperCase()` / `toLowerCase()`

Transforma a string em **maiúsculas** ou **minúsculas**:

```java
"Java".toUpperCase(); // "JAVA"
"Java".toLowerCase(); // "java"
```

---

## 🔍 `contains(CharSequence seq)`

Verifica se um trecho está presente:

```java
"Hello World".contains("World"); // true
```

---

## 🤩 `startsWith()` e `endsWith()`

Verifica o início ou fim da String:

```java
"banana".startsWith("ba"); // true
"banana".endsWith("na");   // true
```

---

## 📏 `length()`

Retorna o número de caracteres:

```java
"Olá".length(); // 3
```

---

## 🔢 `charAt(int index)`

Acessa um caractere da string pela posição:

```java
String palavra = "café";
char letra = palavra.charAt(1); // 'a'
```

---

## 🔁 Exemplo de JSON com `"""` (triple aspas) – Java 15+

A partir do Java 15, é possível usar **text blocks** com `"""` para facilitar strings multilinha (ideal para JSON ou HTML):

```java
String json = """
{
  "nome": "João",
  "idade": 30,
  "ativo": true
}
""";
System.out.println(json);
```

---

## ⚠️ Dica Final

Por serem **imutáveis**, quando precisar **modificar uma string várias vezes**, prefira usar a classe `StringBuilder` para evitar criação excessiva de objetos.

```java
StringBuilder sb = new StringBuilder("Olá");
sb.append(" mundo");
System.out.println(sb.toString()); // "Olá mundo"
```

---

# Classes StringBuilder e StringBuffer

# 🧵 Strings em Java

As **Strings** em Java são objetos imutáveis, ou seja, uma vez criadas, não podem ser modificadas. Toda alteração em uma `String` gera um **novo objeto**.

A classe `String` pertence ao pacote `java.lang` e possui vários métodos úteis para manipulação de textos.

---

## 📌 Imutabilidade e alternativas: StringBuilder e StringBuffer

* A classe `String` é **imutável**, ou seja, toda operação como concatenação ou substituição **gera um novo objeto na memória**.
* Ao realizar:

```java
String nome = "João";
nome += " Silva";
```

> O conteúdo original "João" não é alterado, um novo objeto com valor "João Silva" é criado.

* Para casos onde há **muitas concatenações**, é melhor usar `StringBuilder`, que é **mutável** e mais performático:

```java
StringBuilder sb = new StringBuilder("João");
sb.append(" Silva");
System.out.println(sb); // João Silva
```

* Já o `StringBuffer` é similar ao `StringBuilder`, porém **thread-safe** (sincronizado), e mais indicado para **ambientes com múltiplas threads**.

* Em **grandes volumes de dados**, a performance entre `String`, `StringBuilder` e `StringBuffer` pode ser impactada pela forma como a **JVM gerencia a memória**.

---

Para Strings é bom sempre analisarmos o melhor cenário para cado uso. 

# Questionário: 

### 1. Por que o uso de `StringBuilder` é mais eficiente do que `String` em loops que realizam múltiplas concatenações?

- [ ] Porque `StringBuilder` é imutável e não consome memória extra  
- [ ] Porque `StringBuilder` cria uma nova instância para cada concatenação, ao contrário de `String`  
- [ ] Porque `StringBuilder` é otimizado apenas para aplicações multithread  
- ✅ **Porque `StringBuilder` reutiliza o mesmo objeto na memória para todas as operações**  
- [ ] Porque `StringBuilder` é uma versão simplificada de `String`  

---

### 2. Qual é a principal diferença entre as classes `String`, `StringBuilder` e `StringBuffer` no Java?

- ✅ **`String` é imutável, enquanto `StringBuilder` e `StringBuffer` são mutáveis**  
- [ ] `String` é mutável, enquanto `StringBuilder` e `StringBuffer` são imutáveis  
- [ ] Apenas `String` suporta operações em cenários multithread  
- [ ] `StringBuffer` é mais eficiente do que `StringBuilder` para operações de concatenação em cenários single-thread  
- [ ] `String` permite acesso direto a índices, enquanto `StringBuilder` e `StringBuffer` não  

---

### 3. Dado o código abaixo, qual será o valor da string `str` após sua execução?

```java
String str = "Java";
str = str.replace("a", "o");
```

- [ ] "Java" com um erro de compilação  
- [ ] "Jvoa"  
- ✅ **"Jovo"**  
- [ ] "Java"  
- [ ] "Joaa"  

---

### 4. Considere o método `split` da classe `String`. Qual é a funcionalidade principal deste método?

- [ ] Alterar os caracteres de uma string para caixa alta ou baixa  
- [ ] Substituir todas as ocorrências de uma substring em uma string por outra  
- [ ] Remover todas as instâncias de um caractere específico em uma string  
- ✅ **Dividir uma string em um array de substrings com base em um delimitador especificado**  
- [ ] Unir várias strings em uma única string separada por um delimitador  


# Aplicando o BigDecimal, Enums e classe Otional

# 📏 Trabalhando com BigDecimal em Java

## 🧮 O que é BigDecimal?

A classe `BigDecimal` em Java é utilizada para realizar **operações matemáticas com alta precisão**, principalmente em aplicações financeiras, científicas e contábeis.

> ⚠️ `float` e `double` são tipos de ponto flutuante e **sofrem com perda de precisão** em operações decimais, o que pode gerar erros em cálculos sensíveis.

---

## 🚧 Por que não usar `double` ou `float`?

```java
System.out.println(0.1 + 0.2); // 0.30000000000000004
````

Com `BigDecimal`, temos **controle total** sobre precisão e arredondamento.

---

## ✅ Criando BigDecimal

```java
BigDecimal valor1 = new BigDecimal("0.1");
BigDecimal valor2 = new BigDecimal("0.2");
BigDecimal resultado = valor1.add(valor2);

System.out.println(resultado); // 0.3
```

> ✨ Use sempre **Strings** ao criar um BigDecimal para evitar erros de precisão.

---

## 🔢 Operações Comuns

### ➕ Soma: `add(BigDecimal)`

```java
valor1.add(valor2);
```

### ➖ Subtração: `subtract(BigDecimal)`

```java
valor1.subtract(valor2);
```

### ✖️ Multiplicação: `multiply(BigDecimal)`

```java
valor1.multiply(valor2);
```

### ➗ Divisão: `divide(BigDecimal, escala, RoundingMode)`

```java
BigDecimal total = new BigDecimal("10");
BigDecimal divisor = new BigDecimal("3");

BigDecimal resultado = total.divide(divisor, 2, RoundingMode.HALF_UP);
System.out.println(resultado); // 3.33
```

---

## 🎯 Escala e Arredondamento

* `.setScale(int casasDecimais, RoundingMode modo)`

```java
BigDecimal numero = new BigDecimal("3.14159");
BigDecimal arredondado = numero.setScale(2, RoundingMode.HALF_UP); // 3.14
```

### Principais RoundingModes:

* `HALF_UP`: Arredonda para o mais próximo. Em caso de empate, sobe (1.5 → 2).
* `HALF_DOWN`: Arredonda para o mais próximo. Em empate, desce (1.5 → 1).
* `UP`: Sempre arredonda para cima.
* `DOWN`: Sempre arredonda para baixo.
* `CEILING`: Arredonda para cima se positivo.
* `FLOOR`: Arredonda para baixo se positivo.

---

## ✅ Comparações

Use os métodos abaixo para comparar BigDecimals:

```java
valor1.compareTo(valor2); // retorna -1, 0 ou 1
valor1.equals(valor2);    // verifica igualdade com mesma escala
```

---

## 🚫 Evite isto:

```java
BigDecimal errado = new BigDecimal(0.1); // pode causar imprecisão!
```

Use:

```java
BigDecimal correto = new BigDecimal("0.1");
```

---

## 📦 Exemplo completo

```java
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExemploBigDecimal {
    public static void main(String[] args) {
        BigDecimal preco = new BigDecimal("19.99");
        BigDecimal desconto = new BigDecimal("5.00");

        BigDecimal total = preco.subtract(desconto);
        BigDecimal imposto = total.multiply(new BigDecimal("0.1"));
        BigDecimal finalComImposto = total.add(imposto).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Total com imposto: " + finalComImposto); // 16.49 + 1.649 = 18.14
    }
}
```

---

## 💡 Quando usar BigDecimal?

* Cálculos financeiros ou fiscais
* Aplicações bancárias
* Arredondamentos precisos
* Quando `float` e `double` causarem erro de precisão

---

# Enums

# 🧮 Enums em Java com Exemplo de Calculadora

## 📚 O que é um `enum` em Java?

Em Java, `enum` ( abreviação de **enumeration**) é um **tipo especial de classe** usado para **representar um conjunto fixo de constantes**.

> Ex: dias da semana, estados de um sistema, operações matemáticas, etc.

```java
public enum DiaDaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;
}
```

---

## 💡 Características do `enum`:

- Pode ter atributos, construtores e métodos.
- Pode ser usado em `switch`, `if`, etc.
- É **imutável**.
- Pode implementar interfaces (mas não herdar classes).
- Cada valor do `enum` é um objeto singleton da própria classe `enum`.

---

## 🧮 Exemplo prático: Calculadora com `enum`

Vamos criar um `enum` com as **operações matemáticas** e uma classe `Calculadora` que usa ele:

### 1. Criando o enum `Operacao`

```java
public enum Operacao {
    SOMA("+") {
        public double aplicar(double x, double y) {
            return x + y;
        }
    },
    SUBTRACAO("-") {
        public double aplicar(double x, double y) {
            return x - y;
        }
    },
    MULTIPLICACAO("*") {
        public double aplicar(double x, double y) {
            return x * y;
        }
    },
    DIVISAO("/") {
        public double aplicar(double x, double y) {
            return x / y;
        }
    };

    private final String simbolo;

    Operacao(String simbolo) {
        this.simbolo = simbolo;
    }

    public abstract double aplicar(double x, double y);

    @Override
    public String toString() {
        return simbolo;
    }
}
```

---

### 2. Classe `Calculadora`

```java
public class Calculadora {
    public static void main(String[] args) {
        double a = 10;
        double b = 2;

        for (Operacao op : Operacao.values()) {
            double resultado = op.aplicar(a, b);
            System.out.printf("%f %s %f = %f%n", a, op, b, resultado);
        }
    }
}
```

### 🔎 Saída esperada:

```
10.000000 + 2.000000 = 12.000000
10.000000 - 2.000000 = 8.000000
10.000000 * 2.000000 = 20.000000
10.000000 / 2.000000 = 5.000000
```

---

## 📦 Por que usar `enum` aqui?

- Elegante e organizado.
- Permite encapsular lógica diretamente nas constantes.
- Facilita manutenção: para adicionar uma nova operação, basta criar um novo `enum`.


# ❓ Optional em Java

## 📚 O que é a classe `Optional`?

A classe `Optional<T>` foi introduzida no Java 8 para ajudar a **evitar o uso excessivo de `null`** e reduzir os erros de `NullPointerException`. Ela representa um **contêiner que pode ou não conter um valor não-nulo**.

---

## 🧰 Principais métodos de `Optional`

### ✔️ `Optional.of(T value)`
Cria um `Optional` contendo um valor **não-nulo**.

```java
Optional<String> nome = Optional.of("Java");
````

> Lança `NullPointerException` se o valor for `null`.

---

### ❔ `Optional.ofNullable(T value)`

Cria um `Optional` que **pode conter** um valor ou estar vazio.

```java
Optional<String> nome = Optional.ofNullable(null); // Ok
```

---

### ❌ `Optional.empty()`

Cria um `Optional` vazio.

```java
Optional<String> vazio = Optional.empty();
```

---

### 🔎 `isPresent()` e `isEmpty()`

Verificam se há ou não valor no `Optional`.

```java
if (nome.isPresent()) {
    System.out.println("Existe valor!");
}
```

---

### 🧾 `get()`

Retorna o valor contido, se existir, ou lança `NoSuchElementException`.

```java
Optional<String> nome = Optional.of("Java");
System.out.println(nome.get()); // "Java"
```

---

### 🧰 `orElse()`, `orElseGet()` e `orElseThrow()`

* `orElse()` retorna um valor padrão se estiver vazio.
* `orElseGet()` executa uma `Supplier` como fallback.
* `orElseThrow()` lança exceção se estiver vazio.

```java
String resultado = nome.orElse("Valor padrão");
```

---

### 🧪 `ifPresent(Consumer<T>)`

Executa um código **apenas se houver valor**:

```java
nome.ifPresent(n -> System.out.println("Olá " + n));
```

---

## 💡 Exemplo prático

```java
public class ExemploOptional {
    public static Optional<String> buscarNomePorId(int id) {
        if (id == 1) return Optional.of("Ana");
        return Optional.empty();
    }

    public static void main(String[] args) {
        Optional<String> nome = buscarNomePorId(1);

        nome.ifPresentOrElse(
            n -> System.out.println("Nome encontrado: " + n),
            () -> System.out.println("Nome não encontrado")
        );
    }
}
```

---

## 🧠 Por que usar `Optional`?

* Evita `null` explícito.
* Torna o código mais legível e seguro.
* Força o tratamento de ausência de valor.



## Questionário:

### 1. Qual é a principal finalidade da classe `BigDecimal` no Java?

- [ ] Representar valores binários em cálculos matemáticos.  
- [ ] Facilitar a conversão de números inteiros para strings.  
- ✅ **Realizar cálculos com alta precisão, especialmente em contextos financeiros.**  
- [ ] Substituir os tipos primitivos `double` e `float` em todas as situações.  
- [ ] Armazenar números inteiros de forma eficiente.  

---

### 2. Sobre o tipo `Optional` no Java, qual das alternativas é verdadeira?

- [ ] `Optional` foi introduzido no Java 11 para substituir exceções em tempo de execução.  
- [ ] O método `orElseThrow` retorna um valor padrão se o `Optional` estiver vazio.  
- [ ] Não é possível mapear o conteúdo de um `Optional` para outro tipo.  
- [ ] O método `get` do `Optional` sempre retorna um valor, mesmo que ele seja nulo.  
- ✅ **A principal funcionalidade do `Optional` é evitar o uso de valores nulos.**  

---

### 3. Considere o seguinte código usando Optional:

```java
Optional<String> optional = Optional.of("Java");
String result = optional.orElse("Default");
````

* [ ] Lançará uma exceção de tipo `NoSuchElementException`.
* ✅ **"Java"**
* [ ] null
* [ ] "Default"
* [ ] Lançará uma exceção de tipo `NullPointerException`.

---

### 4. Qual das seguintes características é verdadeira sobre a enumeração (`enum`) no Java?

* ✅ **Um `enum` pode conter métodos e atributos.**
* [ ] O `enum` não pode ser utilizado para armazenar valores constantes.
* [ ] Os elementos de um `enum` são mutáveis por padrão.
* [ ] Um `enum` não pode ser usado como um tipo de dado em uma classe.
* [ ] O `enum` só pode ser utilizado com números inteiros.


# API de Streams e Generics

## Introdução a API de Streams

# 🚀 Java Streams API e Generics

## ☕ Streams API

A **Streams API** do Java, introduzida no Java 8, permite trabalhar com **coleções de forma funcional**, utilizando uma **pipeline** de operações como `map`, `filter`, `peek`, `collect`, entre outras.

### 🔁 Conceito de Stream

Stream representa uma **sequência de elementos** que permite realizar operações de forma **declarativa** e **mais legível**, ao invés de loops tradicionais.

Exemplo básico:

```java
List<String> nomes = List.of("Ana", "Pedro", "Lucas");

nomes.stream()
     .filter(n -> n.startsWith("A"))
     .forEach(System.out::println);
````

---

### 🔍 `filter(Predicate<T>)`

Filtra os elementos com base em uma **condição (lambda)**.

```java
List<Integer> numeros = List.of(1, 2, 3, 4, 5);

numeros.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println); // imprime 2 e 4
```

---

### 👀 `peek(Consumer<T>)`

Permite **espiar** os elementos no meio da pipeline — geralmente usado para **debug**.

```java
List<String> nomes = List.of("Ana", "Bruno", "Clara");

nomes.stream()
     .peek(nome -> System.out.println("Antes do filtro: " + nome))
     .filter(nome -> nome.length() > 3)
     .peek(nome -> System.out.println("Depois do filtro: " + nome))
     .collect(Collectors.toList());
```

> ⚠️ O `peek()` **não modifica** os elementos. Ele apenas executa uma ação intermediária (como log).

---

### ✅ Benefícios do uso de Streams

* Código mais conciso e legível
* Fácil de aplicar filtros, transformações e agregações
* Possibilidade de execução paralela (`parallelStream()`)

---

## 🧬 Generics em Java

Os **Generics** permitem que classes, interfaces e métodos trabalhem com **tipos parametrizados** (sem precisar escrever o mesmo código várias vezes).

### 📦 Exemplo de Classe Genérica

```java
public class Caixa<T> {
    private T conteudo;

    public void guardar(T item) {
        this.conteudo = item;
    }

    public T abrir() {
        return conteudo;
    }
}
```

Uso:

```java
Caixa<String> caixaDeTexto = new Caixa<>();
caixaDeTexto.guardar("Olá");
System.out.println(caixaDeTexto.abrir()); // Olá

Caixa<Integer> caixaDeNumero = new Caixa<>();
caixaDeNumero.guardar(42);
System.out.println(caixaDeNumero.abrir()); // 42
```

---

### 💡 Vantagens dos Generics

* Evitam **casts** desnecessários
* Promovem **reutilização de código**
* Aumentam a **segurança de tipo** em tempo de compilação

---

### 📎 Generics com Collections

```java
List<String> nomes = new ArrayList<>();
nomes.add("João");
// nomes.add(123); // erro de compilação!
```

---

### 🔒 Limites de Generics (Wildcard)

```java
List<? extends Number> listaNumeros; // Aceita Integer, Double, etc.
List<? super Integer> listaSuperInteiros; // Aceita Integer ou supertipos
```

---

# Questionario Streams

### 1. Em relação ao método `flatMap` da API de Streams, qual é a principal funcionalidade dele?

- [ ] Ordenar os elementos de uma Stream em ordem ascendente  
- [ ] Converter uma Stream de objetos em uma coleção, como um `Set`  
- [ ] Filtrar elementos de uma Stream com base em um predicado lógico  
- ✅ **Combinar múltiplas Streams em uma única Stream de objetos**  
- [ ] Mapear cada elemento de uma Stream para um único valor escalar  

### 2. Sobre a implementação de classes genéricas em Java, qual das opções é verdadeira?

- [ ] Não é possível criar métodos genéricos em uma classe não genérica  
- [ ] A classe genérica deve ser instanciada sempre com um tipo definido no momento da declaração  
- [ ] Uma classe genérica pode aceitar qualquer tipo de argumento, incluindo tipos primitivos como `int` e `float`  
- [ ] O operador `instanceof` pode ser usado diretamente em parâmetros genéricos para verificar seu tipo  
- ✅ **O uso de `extends` em parâmetros genéricos permite limitar o tipo que uma classe ou método pode aceitar**  


### 3. Sobre a API de Streams do Java, qual das afirmações abaixo é correta?

- [ ] Streams não podem ser convertidas para coleções, como `List` ou `Set`  
- [ ] A operação `filter` é uma operação terminal  
- [ ] A operação `reduce` é usada apenas para somar números em uma Stream de inteiros  
- ✅ **As operações intermediárias de Streams, como `filter` e `map`, retornam uma nova Stream para processamento posterior**  
- [ ] A API de Streams é usada exclusivamente para operações de I/O em arquivos  

### 4. Considerando a utilização de Generics no Java, qual vantagem principal eles proporcionam?

- ✅ **Permitem maior reutilização de código e segurança de tipo em tempo de compilação**  
- [ ] Substituem a necessidade de herança em Java  
- [ ] Eliminam a necessidade de criar classes ou interfaces  
- [ ] Garantem que os métodos aceitem apenas tipos primitivos  
- [ ] Garantem que o código seja sempre mais rápido em execução  


## Classe Date e Calendar

