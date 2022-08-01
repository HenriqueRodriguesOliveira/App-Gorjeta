package com.cursoandroid.estudo6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorgeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor          = findViewById(R.id.editValor);
        textPorcentagem    = findViewById(R.id.textPorcentagem);
        textGorgeta        = findViewById(R.id.textGorgeta);
        textTotal          = findViewById(R.id.textTotal);
        seekBarGorjeta     = findViewById(R.id.seekBarGorjeta);


        //Adicionar listener SeekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                porcentagem = progress;
                textPorcentagem.setText( porcentagem + " %" );
                textPorcentagem.setText( Math.round( porcentagem ) + "%" );
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){

    String valorRecuperado = editValor.getText().toString();
    if ( valorRecuperado == null || valorRecuperado.equals("")){
        Toast.makeText(
                getApplicationContext(),
                "Digite um valor primeiro!",
                Toast.LENGTH_LONG
        ).show();
    }else {

        //Converter string para double
        double valorDigitado = Double.parseDouble( valorRecuperado );

        //calculo da gorjeta total
        double gorjeta = valorDigitado * (porcentagem/100);
        double total = gorjeta + valorDigitado;

        //exibe a gorgeta e total
        //textGorgeta.setText("R$ " + Math.round(gorjeta) );
        textGorgeta.setText("R$ " + gorjeta );
        textTotal.setText("R$ " + total );
    }

    }
}