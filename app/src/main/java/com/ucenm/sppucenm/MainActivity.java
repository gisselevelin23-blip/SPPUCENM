package com.ucenm.sppucenm;

import android.content.ContentValues;
import android.database.Cursor; // Importante
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.ucenm.sppucenm.configuraciones.SQLiteConexion;
import com.ucenm.sppucenm.configuraciones.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText nombres, apellidos, correo, edad, etIdBusqueda;
    Button btnagregar, btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        correo = (EditText) findViewById(R.id.correo);
        edad = (EditText) findViewById(R.id.edad);
        btnagregar = (Button) findViewById(R.id.btnagregar);
        etIdBusqueda = (EditText) findViewById(R.id.etIdBusqueda);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersona();
            }
        });


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etIdBusqueda.getText().toString().isEmpty()) {
                    BuscarPersona();
                } else {
                    Toast.makeText(MainActivity.this, "Escriba un ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void BuscarPersona() {
        try {
            SQLiteConexion conexion = new SQLiteConexion(getApplicationContext(),
                    Transacciones.DBNAME, null, Transacciones.DBVERSION);
            SQLiteDatabase db = conexion.getReadableDatabase();

            String[] params = {etIdBusqueda.getText().toString()};

            String[] campos = {
                    Transacciones.col_nombres,
                    "apellidos",
                    "edad",
                    "correo"
            };

            Cursor cursor = db.query(Transacciones.TABLEUSERS, campos, Transacciones.col_id + "=?", params, null, null, null);

            if (cursor.moveToFirst()) {
                nombres.setText(cursor.getString(0));
                apellidos.setText(cursor.getString(1));
                edad.setText(cursor.getString(2));
                correo.setText(cursor.getString(3));
            } else {
                Toast.makeText(getApplicationContext(), "ID no encontrado en la base de datos", Toast.LENGTH_LONG).show();
                LimpiarCampos();
            }
            cursor.close();
            db.close();

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void AgregarPersona() {
        try {
            SQLiteConexion conexion = new SQLiteConexion(getApplicationContext(),
                    Transacciones.DBNAME, null, Transacciones.DBVERSION);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.col_nombres, nombres.getText().toString());
            valores.put("apellidos", apellidos.getText().toString());
            valores.put("correo", correo.getText().toString());
            valores.put("edad", edad.getText().toString());

            Long resultado = db.insert(Transacciones.TABLEUSERS, Transacciones.col_id, valores);

            if (resultado > 0) {
                Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
                LimpiarCampos();
            }
            db.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error al insertar", Toast.LENGTH_SHORT).show();
        }
    }

    private void LimpiarCampos() {
        nombres.setText("");
        apellidos.setText("");
        correo.setText("");
        edad.setText("");
    }
}