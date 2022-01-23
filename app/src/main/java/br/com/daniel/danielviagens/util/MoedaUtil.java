package br.com.daniel.danielviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static String formataParaBrasileiro(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        return formatoBrasileiro.format(valor);
        //        Na aula o instrutor fez assim mas no meu caso não foi preciso.
        //        String moedaBrasileira = formatoBrasileiro.format(precoDoPacote).replace("R$", "R$ ");
    }

}
