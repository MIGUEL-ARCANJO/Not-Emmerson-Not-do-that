package com.example.persistenciasql.respository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.persistenciasql.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository implements CrudRepository<Pessoa> {

    private SQLiteDatabase database;

    public PessoaRepository(SQLiteDatabase database) {
        this.database = database;
    }

    @Override
    public Long criar(Pessoa pessoa) {

        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("cargo", pessoa.getCargo());

        return database.insertOrThrow("pessoa", null, values);
    }

    @Override
    public List listAll() {
        List<Pessoa> pessoasList = new ArrayList<>();

        String sql = "SELECT * FROM pessoa";

        Cursor result = database.rawQuery(sql, null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(result.getInt(0));
                pessoa.setNome(result.getString(1));
                pessoa.setCargo(result.getString(2));
                pessoasList.add(pessoa);
                
            } while (result.moveToNext());

        }

        return pessoasList;
    }

    @Override
    public void updateObject() {

    }

    @Override
    public void deleteObject() {

    }
}
