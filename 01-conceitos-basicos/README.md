# Conceitos Básicos para Começar a Programar em Java

Este módulo aborda os primeiros passos na programação com Java. Aqui você encontrará 4 atividades fundamentais para desenvolver lógica, sintaxe e estrutura de programas Java.

## ✅ Tópicos
1. Introdução ao Java e seu Ambiente de Desenvolvimento
2. Fundamentos da Linguagem de Programação Java
3. Estruturas de Controle em Java
4. Fundamentos da Linguagem de Programação Java


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