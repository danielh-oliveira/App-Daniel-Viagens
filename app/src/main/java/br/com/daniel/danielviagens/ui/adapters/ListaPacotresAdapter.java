package br.com.daniel.danielviagens.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.daniel.danielviagens.R;
import br.com.daniel.danielviagens.model.Pacote;

public class ListaPacotresAdapter extends BaseAdapter {

    private List<Pacote> pacotes;
    private Context context;

    public ListaPacotresAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context = context;
    }


    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Object getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        //pegar nome do pacote e jogar na view
        TextView nome = viewCriada.findViewById(R.id.item_pacote_nome_cidade);
        nome.setText(pacote.getLocal());

        //pegar imagem do pacote e jogar na view
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        //pegar dias do pacote e jogar na view
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        int pacoteDias = pacote.getDias();
        String quantidadeDeDias = "";
        if (pacoteDias > 1) {
            quantidadeDeDias = pacoteDias + " dias";
        } else {
            quantidadeDeDias = pacoteDias + " dia";
        }
        dias.setText(quantidadeDeDias);

        //pegar preco do pacote e jogar na view
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        BigDecimal precoDoPacote = pacote.getPreco();
        String moedaBrasileira = formatoBrasileiro.format(precoDoPacote);
        //        Na aula o instrutor fez assim mas no meu caso não foi preciso.
        //        String moedaBrasileira = formatoBrasileiro.format(precoDoPacote).replace("R$", "R$ ");
        preco.setText(moedaBrasileira);

        return viewCriada;
    }
}
