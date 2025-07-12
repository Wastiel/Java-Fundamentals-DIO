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