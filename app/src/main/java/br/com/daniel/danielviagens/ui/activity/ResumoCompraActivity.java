package br.com.daniel.danielviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.daniel.danielviagens.R;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR_RESUMO_COMPRA = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR_RESUMO_COMPRA);
    }
}