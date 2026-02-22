package com.ucenm.sppucenm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ucenm.sppucenm.configuraciones.SQLiteConexion;
import com.ucenm.sppucenm.configuraciones.Transacciones;
import com.ucenm.sppucenm.configuraciones.Usuarios;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {

    private ArrayList<String> listausuario;
    private ArrayList<Usuarios> listaObjetosUsuarios;
    Spinner spcombo;
    EditText nombres, apellidos, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_combo);

        spcombo = (Spinner) findViewById(R.id.spcombo);
        nombres = (EditText) findViewById(R.id.cnombres);
        apellidos = (EditText) findViewById(R.id.capellidos);
        correo = (EditText) findViewById(R.id.ccorreo);
    }

    private void obtenerUsuarios()
    {
        try
        {
            SQLiteConexion conexion = new SQLiteConexion(getApplicationContext(),
                    Transacciones.DBNAME,
                    null,
                    Transacciones.DBVERSION);
            SQLiteDatabase db =conexion.getReadableDatabase();

            Usuarios users;
            listaObjetosUsuarios = new ArrayList<>();
            Cursor cursor = db.rawQuery(Transacciones.SELECT_STMT,null);

            while(cursor.moveToNext())
            {
                users = new Usuarios(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4)
                        );
                listaObjetosUsuarios.add(users);
            }

            cursor.close();
            db.close();
        }
        catch (Exception ex)
        {

        }
    }

}