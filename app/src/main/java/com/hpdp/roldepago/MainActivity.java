package com.hpdp.roldepago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edCargo, edAntiguedad, edHijos, edHoras, edNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edCargo = findViewById(R.id.txtCargo);
        edAntiguedad = findViewById(R.id.txtAntiguedad);
        edHijos = findViewById(R.id.txtHijos);
        edHoras = findViewById(R.id.txtHorasExtras);
        edNombre = findViewById(R.id.txtNombre);
    }

    public void Enviar(View view){
        Bundle Rol = new Bundle();

        Rol.putString("Cargo", edCargo.getText().toString());
        Rol.putInt("Antiguedad", Integer.parseInt(edAntiguedad.getText().toString()));
        Rol.putInt("Hijos", Integer.parseInt(edHijos.getText().toString()));
        Rol.putInt("Horas", Integer.parseInt(edHoras.getText().toString()));
        Rol.putString("Nombre", edNombre.getText().toString());


        Intent i = new Intent(this, RolDePago.class);
        i.putExtras(Rol);
        startActivity(i);
    }
}