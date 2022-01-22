package br.com.daniel.danielviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.daniel.danielviagens.R;
import br.com.daniel.danielviagens.model.Pacote;
import br.com.daniel.danielviagens.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR_RESUMO_COMPRA = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR_RESUMO_COMPRA);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraImagem(pacoteSaoPaulo);
        mostraLocal(pacoteSaoPaulo);
        mostraDatas(pacoteSaoPaulo);
        mostraPreco(pacoteSaoPaulo);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        preco.setText(pacote.getPreco());
    }

    private void mostraDatas(Pacote pacote) {
        TextView datas = findViewById(R.id.resumo_compra_data);
        datas.setText(pacote.getDatas());
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacoteSaoPaulo) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem);
        Drawable drawableImagem = ResourcesUtil.devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableImagem);
    }
}