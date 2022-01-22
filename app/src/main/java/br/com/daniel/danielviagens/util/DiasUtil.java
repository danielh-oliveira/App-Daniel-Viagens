package br.com.daniel.danielviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.daniel.danielviagens.model.Pacote;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";
    public static final String DIA_MES = "dd/MM";

    @NonNull
    public static String formataEmTexto(int numeroDeDias) {
        if (numeroDeDias > 1) {
            return numeroDeDias + PLURAL;
        }
        return numeroDeDias + SINGULAR;
    }

    public static String formatarDatas(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);

        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_MES);
        String dataIdaFromatada = formatoBrasileiro.format(dataIda.getTime());
        String dataVoltaFormatada = formatoBrasileiro.format(dataVolta.getTime());
        return dataIdaFromatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
    }
}
