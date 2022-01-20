package br.com.daniel.danielviagens.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.daniel.danielviagens.R;
import br.com.daniel.danielviagens.dao.PacoteDAO;
import br.com.daniel.danielviagens.model.Pacote;
import br.com.daniel.danielviagens.ui.adapters.ListaPacotresAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String NOME_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(NOME_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotresAdapter(pacotes, this));
    }
}