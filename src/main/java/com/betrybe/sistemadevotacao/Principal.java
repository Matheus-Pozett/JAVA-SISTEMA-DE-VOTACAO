package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidato = scanner.next();

        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = scanner.nextInt();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    } while (opcao != 2);

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitor = scanner.next();

        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitor = scanner.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      }
    } while (opcao != 2);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpfEleitor = scanner.next();

          System.out.println("Entre com o número da pessoa candidata:");
          int numeroCandidato = scanner.nextInt();

          gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);
          break;
        case 2:
          gerenciamentoVotacao.mostrarResultado();
          break;
        case 3:
          gerenciamentoVotacao.mostrarResultado();
          break;
        default:
          break;
      }
    } while (opcao != 3);
  }
}


