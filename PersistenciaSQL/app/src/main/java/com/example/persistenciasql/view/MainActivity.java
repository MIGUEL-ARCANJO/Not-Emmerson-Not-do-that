package com.example.persistenciasql.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.persistenciasql.R;
import com.example.persistenciasql.conexion.ConexaoFactory;
import com.example.persistenciasql.model.Pessoa;
import com.example.persistenciasql.respository.PessoaRepository;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ConexaoFactory conexaoFactory;
    private SQLiteDatabase database;
    private PessoaRepository repository;

    /**
     * Variaveis da View
     */

    private EditText txtNome, txtCargo;
    private Button btnCadastrar;
    private ListView listView;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createConexion();
        initComponents();

        adapter = new ArrayAdapter<Pessoa>(this,
                android.R.layout.simple_list_item_1, this.repository.listAll());
        listView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        btnCadastrar.setOnClickListener(view -> {
            String nomeVal = txtNome.getText().toString().trim(),
                    cargoVal = txtCargo.getText().toString().trim();

            if (validateCampos(nomeVal, cargoVal)) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nomeVal);
                pessoa.setCargo(cargoVal);
                repository.criar(pessoa);

                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Pessoa criada com sucesso!", Toast.LENGTH_SHORT).show();
            }

        });
        super.onStart();
    }

    public boolean validateCampos(String nome, String cargo) {
        boolean isTrue = true;

        if (nome.isEmpty()) {
            txtNome.setError("O campo 'Nome' não pode estar vazio!");
            isTrue = false;
        }
        if (cargo.isEmpty()) {
            txtCargo.setError("O campo 'Cargo' não pode estar vazio!");
            isTrue = false;
        }

        return isTrue;
    }

    private void initComponents() {
        txtNome = findViewById(R.id.nome);
        txtCargo = findViewById(R.id.cargo);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        listView = findViewById(R.id.listaView);
    }


    public void createConexion() {
        try {
            conexaoFactory = new ConexaoFactory(this);
            database = conexaoFactory.getWritableDatabase();

            repository = new PessoaRepository(database);

            Toast.makeText(this, "Conexão criada", Toast.LENGTH_SHORT).show();

        } catch (SQLException ex) {
            Toast.makeText(this, ex + "", Toast.LENGTH_SHORT).show();
        }
    }

}