package br.com.daniel.danielviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.daniel.danielviagens.R;
import br.com.daniel.danielviagens.model.Pacote;
import br.com.daniel.danielviagens.util.DiasUtil;
import br.com.daniel.danielviagens.util.MoedaUtil;
import br.com.daniel.danielviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR_RESUMO = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR_RESUMO);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);
        mostraImagem(pacoteSaoPaulo);
        mostraDias(pacoteSaoPaulo);
        mostraDatas(pacoteSaoPaulo);
        mostraPreco(pacoteSaoPaulo);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        preco.setText(pacote.getPreco());
    }

    private void mostraDatas(Pacote pacote) {
        TextView datas = findViewById(R.id.resumo_pacote_datas);
        datas.setText(pacote.getDatas());
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        dias.setText(DiasUtil.diasEmTexto(pacote.getDias()));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}