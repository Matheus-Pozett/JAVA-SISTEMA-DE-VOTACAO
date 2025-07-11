package com.betrybe.sistemadevotacao;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (pessoasCandidatas.stream().anyMatch(p -> p.getNumero() == numero)) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoaCandidata);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (pessoasEleitoras.stream().anyMatch(p -> p.getCpf().equals(cpf))) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoaEleitora);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.stream().anyMatch(cpf -> cpf.equals(cpfPessoaEleitora))) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    } else {
      List<PessoaCandidata> candidato = pessoasCandidatas.stream()
              .filter(p -> p.getNumero() == numeroPessoaCandidata).findFirst();

      candidato.receberVoto();
      cpfsComputados.add(cpfPessoaEleitora);
    }
  }

  @Override
  public void mostrarResultado() {
    int totalDeVotos = cpfsComputados.size();

    pessoasCandidatas.stream()
            .forEach(candidato -> {
              double votosDoCandidato = candidato.getVotos();
              double porcentagemDecimal = (votosDoCandidato / totalDeVotos) * 100.0;
              int porcentagemInt = (int) Math.round(porcentagemDecimal);

              System.out.printf("Nome: %s - %d votos (%d%%)%n",
                      candidato.getNome(),
                      candidato.getVotos(),
                      porcentagemInt);
            });
    System.out.println("Total de votos: " + totalDeVotos);
  }
}
