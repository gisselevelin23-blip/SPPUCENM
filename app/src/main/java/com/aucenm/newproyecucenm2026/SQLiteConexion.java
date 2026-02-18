package com.aucenm.newproyecucenm2026;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConexion extends SQLiteOpenHelper {


    private SQLiteDatabase sqLiteDatabase;

    public SQLiteConexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase SQLiteDatabase) {
        SQLiteDatabase.execSQL(Transacciones.CREATE_STMT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase SQLiteDatabase, int i, int i1)  {
        SQLiteDatabase.execSQL(Transacciones.DROP_STMT);
        onCreate(sqLiteDatabase);

    }
}
