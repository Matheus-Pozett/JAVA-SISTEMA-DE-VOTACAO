# Sistema de Votação em Java

![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java)
![Maven](https://img.shields.io/badge/Maven-4.0.0-red?style=for-the-badge&logo=apache-maven)


## 📖 Sobre o Projeto

Este é um sistema de votação simples, desenvolvido em Java e executado via console (terminal). O projeto simula o processo de uma eleição, permitindo o cadastro de pessoas candidatas e eleitoras, o registro de votos e a apuração dos resultados em tempo real.

O principal objetivo do projeto é aplicar conceitos fundamentais de Programação Orientada a Objetos (POO), como abstração, encapsulamento, herança e polimorfismo, além de boas práticas de programação, como tratamento de exceções e a utilização de estruturas de dados eficientes.

## ✨ Funcionalidades

O sistema possui as seguintes funcionalidades:

-   **Cadastro de Candidatos:** Permite registrar pessoas candidatas com nome e número. O sistema impede o cadastro de candidatos com o mesmo número.
-   **Cadastro de Eleitores:** Permite registrar pessoas eleitoras com nome e CPF. O sistema impede o cadastro de eleitores com o mesmo CPF.
-   **Validação de CPF:** O CPF da pessoa eleitora é validado no momento do cadastro para garantir sua autenticidade.
-   **Registro de Votos:** Permite que um eleitor vote em um candidato através de seu CPF e do número do candidato.
-   **Segurança da Votação:**
    -   Garante que cada pessoa eleitora possa votar apenas uma vez.
    -   O voto só é computado se o CPF e o número do candidato existirem no sistema.
-   **Apuração de Resultados:** Exibe um resultado parcial ou final da votação, mostrando o total de votos de cada candidato e a sua porcentagem correspondente.

## 🛠️ Tecnologias Utilizadas

-   **Java 17**
-   **Maven** (Gerenciador de Dependências)

## 🚀 Como Executar o Projeto

Certifique-se de ter o **Java 17** e o **Maven** instalados em sua máquina.

1.  **Clone o repositório:**
    ```bash
    git clone git@github.com:Matheus-Pozett/JAVA-SISTEMA-DE-VOTACAO.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd java-sistema-de-votacao
    ```

3.  **Compile o projeto com o Maven:**
    ```bash
    mvn install
    ```

4.  **Execute a aplicação:**
    ```bash
    mvn exec:java -Dexec.mainClass="com.betrybe.sistemadevotacao.Principal"
    ```

## ⚙️ Como Usar

Ao executar o projeto, um menu interativo guiará você através das opções:

1.  **Cadastro de Candidatos:** O programa primeiro perguntará se você deseja cadastrar candidatos. Informe o nome e o número para cada um.
2.  **Cadastro de Eleitores:** Em seguida, o programa perguntará se deseja cadastrar eleitores. Informe o nome e o CPF para cada um.
3.  **Menu de Votação:** Após os cadastros, o menu principal será exibido com as seguintes opções:
    -   `1 - Votar`: Solicita o CPF do eleitor e o número do candidato.
    -   `2 - Resultado Parcial`: Mostra o status atual da votação.
    -   `3 - Finalizar Votação`: Encerra a aplicação e exibe o resultado final.

Desenvolvido por [Matheus Pozett](https://www.linkedin.com/in/matheus-pozett/)