package br.com.daniel.danielviagens.util;

import androidx.annotation.NonNull;

import br.com.daniel.danielviagens.model.Pacote;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int numeroDeDias) {
        if (numeroDeDias > 1) {
            return numeroDeDias + PLURAL;
        }
        return numeroDeDias + SINGULAR;
    }
}
