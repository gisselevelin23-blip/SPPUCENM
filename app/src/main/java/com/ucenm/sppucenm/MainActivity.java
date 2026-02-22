package com.ucenm.sppucenm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ucenm.sppucenm.configuraciones.SQLiteConexion;
import com.ucenm.sppucenm.configuraciones.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText nombres, apellidos, correo, edad;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        correo = (EditText) findViewById(R.id.correo);
        edad =  (EditText) findViewById(R.id.edad);
        btnagregar = (Button) findViewById(R.id.btnagregar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersona();
            }
        });

    }

    private void AgregarPersona()
    {
        try
        {
            SQLiteConexion conexion = new SQLiteConexion(getApplicationContext(),
                    Transacciones.DBNAME,
                    null,
                    Transacciones.DBVERSION);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.col_nombres, nombres.getText().toString());
            valores.put("apellidos", apellidos.getText().toString());
            valores.put("correo", correo.getText().toString());
            valores.put("edad", edad.getText().toString());

            Long resultado = db.insert(Transacciones.TABLEUSERS, Transacciones.col_id, valores);

            if (resultado > 0)
            {
                Toast.makeText(getApplicationContext(), "Insertado correctamente", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Registro no insertado", Toast.LENGTH_LONG).show();
            }

            db.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
}