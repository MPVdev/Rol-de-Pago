package com.hpdp.roldepago;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class RolDePago extends AppCompatActivity {
    TextView lblSueldo, lblAntiguedad, lblHijos, lblHoras, lblSeguro, lblTotal, lblNombre, lblCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol_de_pago);
        lblAntiguedad = findViewById(R.id.lblAntiguedad);
        lblSueldo = findViewById(R.id.lblSueldo);
        lblHijos = findViewById(R.id.lblRHijos);
        lblHoras = findViewById(R.id.lblHorasExtras);
        lblSeguro = findViewById(R.id.lblSeguro);
        lblTotal = findViewById(R.id.lblTotal);
        lblCargo = findViewById(R.id.lblCargo2);
        lblNombre = findViewById(R.id.lblNombres);

        Bundle datos = getIntent().getExtras();

        String Cargo = datos.getString("Cargo");
        int Antiguedad = datos.getInt("Antiguedad");
        int Hijos = datos.getInt("Hijos");
        int Horas = datos.getInt("Horas");
        String Nombre = datos.getString("Nombre");

        lblNombre.setText(Nombre);
        lblCargo.setText(Cargo);

        int SueldoFijo = 0;
        if (Cargo.equalsIgnoreCase("junior")) {
            SueldoFijo = 680;
        } else if (Cargo.equalsIgnoreCase("semisenior")) {
            SueldoFijo = 980;
        } else if (Cargo.equalsIgnoreCase("senior")) {
            SueldoFijo = 1200;
        }

        lblSueldo.setText("Sueldo Fijo: " + SueldoFijo + " Dolares");

        int Basico = 420;
        Double BonoxHijo = 0.02 * Basico;
        Double BonoHijos = BonoxHijo * Hijos;

        lblHijos.setText("Bono por hijos: " + BonoHijos + "Dolares por " + Hijos + " hijos");

        double BonoxAnio = 0.08 * SueldoFijo;
        double BonoAntiguedad = BonoxAnio * Antiguedad;

        lblAntiguedad.setText("Bono por Antiguedad: " + BonoAntiguedad + " Dolares por " + Antiguedad + " Años");

        double SueldoDia = SueldoFijo / 30;
        double SueldoHora = SueldoDia / 8;
        double BonoHoras = SueldoHora * Horas;

        lblHoras.setText("Bono por Horas Extras: " + BonoHoras + "Dolares por " + Horas + " Horas");

        double Seguro = 0.0891 * SueldoFijo;

        lblSeguro.setText("Seguro Social: " + Seguro + " Dolares");

        double Total = (SueldoFijo + BonoAntiguedad + BonoHijos + BonoHoras) - Seguro;

        lblTotal.setText("Recibira " + Total + " Dolares este mes");
    }
}