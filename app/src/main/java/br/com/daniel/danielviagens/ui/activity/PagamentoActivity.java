package br.com.daniel.danielviagens.ui.activity;

import static br.com.daniel.danielviagens.ui.activity.PacoteActivityConstante.CHAVE_PACOTE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.daniel.danielviagens.R;
import br.com.daniel.danielviagens.model.Pacote;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR_PAGAMENTO = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR_PAGAMENTO);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);
            configuraBotaoFinalizaCompra(pacote);
        }
    }

    private void configuraBotaoFinalizaCompra(Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacoteSaoPaulo) {
        TextView preco = findViewById(R.id.pagamento_compra_preco);
        preco.setText(pacoteSaoPaulo.getPreco());
    }
}