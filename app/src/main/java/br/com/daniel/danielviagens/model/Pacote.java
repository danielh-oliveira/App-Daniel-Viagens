package br.com.daniel.danielviagens.model;

import java.math.BigDecimal;

import br.com.daniel.danielviagens.util.DiasUtil;

public class Pacote {

    private final String local;
    private final String imagem;
    private final int dias;
    private final BigDecimal preco;

    public Pacote(String local, String imagem, int dias, BigDecimal preco) {
        this.local = local;
        this.imagem = imagem;
        this.dias = dias;
        this.preco = preco;
    }

    public String getLocal() {
        return local;
    }

    public String getImagem() {
        return imagem;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDatas() {
        return DiasUtil.formatarDatas(dias);
    }

}