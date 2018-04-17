package com.example.victorruelas.practica007;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class Practica007 extends AppCompatActivity {

    ImageView imagen;
    SeekBar seekBar;

    private int iWidth=65;
    private int iHeight=52;
    float density;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica007);

        DisplayMetrics displayMetrics= getResources().getDisplayMetrics();
        density=displayMetrics.densityDpi;

        //BUSCAMOS LAS VARIABLES

        imagen=(ImageView) findViewById(R.id.imageView);
        seekBar=(SeekBar)findViewById(R.id.seekBar);

        //EVENTO PARA REDIMENSIONAR LA PANTALLA

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.e("Valor: ", "ya" + progress);

                float ancho = (progress + iWidth) * density / 160;
                float alto = (progress + iHeight) * density / 160;


                if (progress==100)
                Toast.makeText(Practica007.this, "Estas en el limite", Toast.LENGTH_LONG).show();
                if (progress==0)
                    Toast.makeText(Practica007.this, "Estas en el limite", Toast.LENGTH_LONG).show();

                imagen.getLayoutParams().height = (int) alto;
                imagen.getLayoutParams().width = (int) ancho;
                imagen.requestLayout();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
