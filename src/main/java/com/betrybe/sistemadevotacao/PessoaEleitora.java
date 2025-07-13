package com.betrybe.sistemadevotacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Pessoa eleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    if (!validarCPF(cpf)) {
      throw new IllegalArgumentException("O CPF informado não é válido.");
    }

    this.cpf = cpf;
    this.nome = nome;
  }

  /**
   * Gets cpf.
   *
   * @return the cpf
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * Sets cpf.
   *
   * @param cpf the cpf
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  private boolean validarCPF(String cpf) {
    String cpfLimpo = cpf.replaceAll("[-.]", "");
    String cpfRegex = "^(?!(\\d)\\1{10}$)\\d{11}$";
    Pattern pattern = Pattern.compile(cpfRegex);
    Matcher matcher = pattern.matcher(cpfLimpo);

    if(!matcher.matches()) {
      return false;
    }

    class CalculoBase {
      public int calcularDigito(String parteCpf) {
        int soma = 0;

        int pesoInicial = parteCpf.length() + 1;

        for (int index = 0; index < parteCpf.length(); index += 1) {
          char caractereDigito = parteCpf.charAt(index);
          int digito = Character.getNumericValue(caractereDigito);

          soma += digito * (pesoInicial - index);
        }

        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
      }
    }
    String primeirosNoveDigitos = cpfLimpo.substring(0, 9);
    String primeirosDezDigitos = cpfLimpo.substring(0, 10);
    char dv1Char = cpfLimpo.charAt(9);
    char dv2Char = cpfLimpo.charAt(10);
    int dv1 = Character.getNumericValue(dv1Char);
    int dv2 = Character.getNumericValue(dv2Char);
    CalculoBase calculoBase = new CalculoBase();

    int digito1Calculado = calculoBase.calcularDigito(primeirosNoveDigitos);
    int digito2Calculado = calculoBase.calcularDigito(primeirosDezDigitos);

    if (digito1Calculado != dv1) return false;

    if (digito2Calculado != dv2) return false;

    return true;
  }
}
