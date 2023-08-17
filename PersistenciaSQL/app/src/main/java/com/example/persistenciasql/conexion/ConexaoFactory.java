package com.example.persistenciasql.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class ConexaoFactory extends SQLiteOpenHelper {

    public ConexaoFactory(Context context) {
        super(context, "pessoa",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS pessoa("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", nome TEXT NOT NULL" +
                ", cargo NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
