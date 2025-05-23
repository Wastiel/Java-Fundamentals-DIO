# Introdução ao Java e seu Ambiente de Desenvolvimento

## Apresentação

### Instrutor: 
    - Instrutor:José Luiz Abreu Cardoso
    - Desenvolvedor BackEnd Java
    - Técnico, Graduado e Pós Graduado

### Conteudo Programático:

    - Conteitos Básicos
    - Programação orientada a objetos
    - Gerenciamento de exceções, IO e gerenciador de dependências
    - Técnicas avançadas, Pad~roes e Persistência

## História e evolução do java

    - 1991 a Sun Microsystem criou o Green Team para atuar em um projeto de conexão de dispositivos em residencias.
    - Primeiro desafio do time foi criar uma linguagem de programação independente de S.O., surgindo o GreenTalk.
    - Do GreenTalk, foi criado StarSeven um controle remoto para interagir com equipamentos (Mercado não curtiu muito).
    - 1994 com a internete se tornando popular e o http a GreenTeam viu oportunidade de mercado e surgiu o navegador WebRunner.
    - O navegador rodava "Aplicativos", algo bem revolucionário para a epóca, mudando o nome do navegador par HotJava, em função de direitos autorais.
    - Escreva uma vez e execute em qualquer lugar, slogan utilizado. 
    - 1996 foi lançada uma versao da linguagem com diversas atualizações chamada de JDK (Java Development Kit)
    - Java no iniciou enjessado, demorava com atualizações.
    - Sun Vendeu o Java e o formato de lançamento de versões mudou.
    - Lançamento e fim do suporte, por mais tempo.
    - JDK 21 que vamos utilizar no curso
    - Java com fama de lento em funão da versão 5
 
 ### Emrpesas que usam Java

    - Netflix
    - Slack
    - PayPal
    - PicPay (Começou com PHP mas migrou em função de threads)
    - Linkedin
    - Microsoft (Concorrente, usa java)
    - airbnb

### Java é legado?

    - Não, se atualiza frequentemente
    - Empresas adotam java como principal linguagem
    - Dificilmente linguagens java morrem.

## Instalando o Java no Windows

Instalação do java em uma maquina Windows

- Abrimos o CMD para ver a versão do java no computador
```bash
    java --version
```
Realizamos o download do java 21 através do link:    [oracle.com/java/technologies/downloads/#java21](https://www.oracle.com/br/java/technologies/downloads/#java21)

Linke de Download: 🔗 [Baixar JDK 21 - Windows x64 (.msi)](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.msi)

A instalação consiste em next next finish

- Rodamos novamente o comando para verificar a versão do java, e temos o seguinte retorno: 
```bash
    java --version
```
Agora vamos configurar nossas variaveis de ambiente, para poder executar o java de qualquer diretório

Procurar o atalho "Editar as variavies de ambiente do sistema"

Adicionar a variavel para o usuário:

 - Nome da variavel: JAVA_HOME
 - Valor da Variavel: C:\Program Files\Java\jdk-21\

Adicionamos uma variavel de ambiente path:

- Adicionamos o seguinte comando: %JAVA_HOME%\bin

Abrimos um CMD para realizar um teste e ver se o caminho do java está correto:

```bash
echo %JAVA_HOME%
```

Resultado: C:\Program Files\Java\jdk-21\

## Instalando o Gradle

Instalação do gradle:

Site do Gradle:  [Gradle](https://gradle.org/install/)
Realizamos o download do gradle (Ultima versão - complete) através do link: [Gradle](https://gradle.org/releases/)
Descompactamos o gradle dentro do nosso pc c:\gradle

Para vermos a versão do gradle, executamos o seguinte comando:

```bash
gradle -v
```

Agora vamos configurar nossas variaveis de ambiente para o maven.

Procurar o atalho "Editar as variavies de ambiente do sistema"

Adicionar a variavel para o usuário:

 - Nome da variavel: GRADLE_HOME
 - Valor da Variavel: C:\gradle\gradle-8.14

Adicionamos uma variavel de ambiente path:

- Adicionamos o seguinte comando: %GRADLE_HOME%\bin

Abrimos um CMD para realizar um teste e ver se o caminho do java está correto:

```bash
gradle -v
```

Temos o seguinte retorno com mais algumas informações. 

Gradle 8.14


## Instalando o Maven

Instalação do Maven:

Site do maven:  [Maven](https://maven.apache.org/)
Realizamos o download do gradle (Ultima versão - complete) através do link: [GMaven](https://maven.apache.org/download.cgi)
Descompactamos o maven dentro do nosso pc c:\maven

Para vermos a versão do maven, executamos o seguinte comando:

```bash
mvn -version
```

Agora vamos configurar nossas variaveis de ambiente para o maven.

Procurar o atalho "Editar as variavies de ambiente do sistema"

Adicionar a variavel para o usuário:

 - Nome da variavel: GRADLE_HOME
 - Valor da Variavel: C:\gradle\gradle-8.14

Adicionamos uma variavel de ambiente path:

- Adicionamos o seguinte comando: %GRADLE_HOME%\bin

Abrimos um CMD para realizar um teste e ver se o caminho do java está correto:

```bash
gradle -v
```

Temos o seguinte retorno com mais algumas informações. 

Gradle 8.14

## Instalando JDK

Cada empresa tem seu JDK. Sempre focar em empresa grande do JDK para ter certeza que teremos suporte.

Instalamos através da versão da amazon no link [correto SDk21](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/windows-install.html).

Temos que ajustar os caminhos Java

## JDK com SDKMan

SKDMAN é um software para auxiliar a gerenciar as nossas ferramentas de desenvolvimento. 

Conseguimos seguir o passo a passo de instlação através do site: [SDKMAN](https://sdkman.io/install)

O SDK nos auxilia a gerar a instalação de diversos recursos de desenvolvimento para desenvolvedores. 

## Instalando Eclipse

Link download Eclipse:  [Eclipse](https://eclipseide.org/)

A instalção não tem mistério, next next finish.

## Instalando o VSCode

Visual Studio Code: [VSCode](https://code.visualstudio.com/)

Após podemos instalar algumas extensões que facilitam o desenvolvimento.

Extension pack for Java (Microsoft)

De maneira simples dentro do VScode conseguimos construir de maneira simples um projeto java e executar o mesmo. 

## Instalando o Intellij

Intellj community [Intellj](https://www.jetbrains.com/idea/download/?section=windows)

Modo de instalação, next next finish.

Dentro do intellij criamos um projeto java e ajustamos algumas configurações da IDE e criamos o seguinte teste:

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

## Executando o primeiro programa no Intellij

Vamos entender algumas funcionalidades do IDE e entender um pouco do java.


Primeiramente vamos pegar o código abaixo e compilar através do console.

```bash
javac src/Main.java
```

Para rodar o nosso projeto, executamos o seguinte comando abaixo:

```bash
java src/Main.java
```

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Vamos explorar alguns recursos da nossa IDE:

Criamos o alguns valores para recebermos através do args do main. O args nada mais é do que passar argumentos para o nosso código.

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Argumento 1: " + args[0]);
        System.out.println("Argumento 1: " + args[1]);
    }
}
```

Rodamos com o comando abaixo e temos a seguinte execução:

```bash
java .\src\Main.java Java JDK

Hello World
Argumento 1: Java
Argumento 1: JDK
```

Vamos colocar os argumentos para teste diretamente na abertura do nosso programa através do "More Actions"

Em build and Run colocamos os seguintes argumentos: Java JDK
Adicionamos a funcionalidad ede debug clicando na linha. Ela fica com um circulo vermelho travando a execução do código no determinado ponto. 

Ao executarmos o nosso programa java com o debug ligado, conseguimos alterar valores em tempo real, modificando o resultado mostrado em tela.

Evaluate no Intellij traz este resultado como esperado.

Dica: Não ser refem da nossa IDE. Sempre se atualizar e deixar ela como uma ferramenta de apoio e agilidade no desenvvolvimento de código.

## Executando o primeiro programa no VSCode

Vamos explorar algumas opções do nosso editor

CTRL + Shift + p = Temos os comandos que podemos executar, inclusive um novo projeto JAVA. 
Criamos o nosso primeiro projeto "Java: Create Java Project" e posterior No Build Tools

Para compilar e executar, podemmos seguir o mesmo padrão do Intellij

Primeiramente vamos pegar o código abaixo e compilar através do console.

```bash
javac src/Main.java
```

Para rodar o nosso projeto, executamos o seguinte comando abaixo:

```bash
java .\src\Main.java Java JDK
```

Para executarmos o código abaixo com argumentos, temos que fazer alguns fluxos diferentes: 

```java
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Argumento 1: " + args[0]);
        System.out.println("Argumento 1: " + args[1]);
    }
}
```

No VSCode para criarmos uma configuração de debug, temos que iniciar pelo "Run and Debug" um arquivo de configuração.

Ajustamos o arquivo com a seguinte variavel de argunmento configurada: 

```json
{
    // Use IntelliSense to learn about possible attributes.
    // Hover to view descriptions of existing attributes.
    // For more information, visit: https://go.microsoft.com/fwlink/?linkid=830387
    "version": "0.2.0",
    "configurations": [

        {
            "type": "java",
            "name": "Current File",
            "request": "launch",
            "mainClass": "${file}",
            "args": "21 java"
        },
        {
            "type": "java",
            "name": "App",
            "request": "launch",
            "mainClass": "App",
            "projectName": "Hello_9f884c78"
        }
    ]
}
```

Com isto pegamos a determinada configuração e conseguimos rodar o nosso projeto. 
Para iniciarmos o debug é muito parecido com o intellij. Clicamos na linha e o programa para nela. Podemos colocar condições para o nosso programa parar na linha do debug.

Criar Break Ponits condicionais. 

## Questionario sobre o conteudo

Dado um projeto com nome “my-project” com um arquivo MyClass.java dentro da pasta src, onde o mesmo tem o método main, qual seria o comando para compilação do projeto, caso você esteja na pasta raiz do projeto?

- javac src/MyClasss.java
- javac src/MyClass.class
- javac src/MyClass
- java src/MyClass.java
- javac src/MyClass.java - Alternativa Correta


Como funciona o versionamento usando LTS?

- As versões lançadas devem ter um longo tempo de suporte e após esse período devem ter suporte permanente para atualizações de segurança.
- São lançadas versões depois de um longo período para garantir a estabilidade do projeto.
- Versões devem ser lançadas o mais rápido possível para garantir uma atualização continua do projeto.
- São lançadas versões somente depois de a mesma acumular um certo número de novas features estáveis.
- Temos o lançamento de versões com menor tempo de suporte para inclusão de novas features e o lançamento de uma versão LTS que irá incluir as features estáveis e prontas para produção. - Alternativa Correta


No método a seguir: public static void main(String[] args) qual é a utilização do args?
Receber informações do ambiente onde o código é executado ( S.O., processador, etc.)

- O método está escrito de forma errada, ele não recebe nenhum parâmetro
- Receber parâmetros de inicialização do código, onde os mesmos são separados por “ ” - Alternativa Correta
- Receber parâmetros de inicialização do código, onde os mesmos são separados por “;”
- Receber parâmetros de inicialização do código, onde os mesmos são separados por “,”

Qual das opções a seguir não são um IDE/editor de textos que dão suporte para desenvolvimento Java?

- Visual Studio - Alternativa Correta
- Visual Studio Code
- Eclipse
- Intellij
- Sublime


Dado um projeto com nome “my-project” com um arquivo MyClass.java dentro da pasta src, onde o mesmo tem o método main e tenhamos o arquivo MyClass.class também localizado na pasta src, qual seria o comando para execução do código, caso você esteja na pasta raiz do projeto?

- java src.MyClass.java
- java src/MyClass
- java src/MyClass.class
- javac src/MyClass.java
- java src/MyClass.java - Alternativa Correta