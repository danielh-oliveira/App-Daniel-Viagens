package br.com.daniel.danielviagens.ui.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.daniel.danielviagens.util.DiasUtil;
import br.com.daniel.danielviagens.util.MoedaUtil;
import br.com.daniel.danielviagens.R;
import br.com.daniel.danielviagens.util.ResourcesUtil;
import br.com.daniel.danielviagens.model.Pacote;

public class ListaPacotresAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

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

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        //pegar preco do pacote e jogar na view
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = pacote.getPreco();
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        //pegar dias do pacote e jogar na view
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String quantidadeDeDias = DiasUtil.diasEmTexto(pacote.getDias());
        dias.setText(quantidadeDeDias);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        //pegar imagem do pacote e jogar na view
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourcesUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
        //Socorro
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        //pegar nome do pacote e jogar na view
        TextView nome = viewCriada.findViewById(R.id.item_pacote_nome_cidade);
        nome.setText(pacote.getLocal());
    }
}