package com.examen.preparacionexamenlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    ImageView imagenpatitaanimada;
    TextView imagentexto;
    ImageView Imagenpatitarotacion;
    ImageView imagenpatitaescala;
    ImageView imagenPatitaFadeOut;
    ImageView imagenPatitaBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imagenpatitaanimada=findViewById(R.id.imagenPatitaAnimada);
        Animation translate = AnimationUtils.loadAnimation(this,R.anim.translacion);
        imagenpatitaanimada.startAnimation(translate);

        imagenpatitaescala=findViewById(R.id.imagenPatitaEscala);
        Animation scale = AnimationUtils.loadAnimation(this,R.anim.escala);
        imagenpatitaescala.startAnimation(scale);

        Imagenpatitarotacion=findViewById(R.id.imagenPatitaRotacion);
        Animation rotation = AnimationUtils.loadAnimation(this,R.anim.rotacion);
        Imagenpatitarotacion.startAnimation(rotation);

        imagenPatitaFadeOut=findViewById(R.id.imagenPatitaFadeOut);
        Animation fadeout = AnimationUtils.loadAnimation(this,R.anim.desaparecer_opacidad_fadeout);
        imagenPatitaFadeOut.startAnimation(fadeout);

        imagenPatitaBlink=findViewById(R.id.imagenPatitaBLink);
        Animation blink = AnimationUtils.loadAnimation(this,R.anim.blink);
        imagenPatitaBlink.startAnimation(blink);

        imagentexto=findViewById(R.id.textocoronavirus);
        Animation fadeIn = AnimationUtils.loadAnimation(this,R.anim.aparecer_opacidad_fadein);
        imagentexto.startAnimation(fadeIn);


        openApp();
    }

    private void openApp() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;

                intent = new Intent(Splash.this, LoginActivity.class);

                startActivity(intent);
                finish();
            }
        }, 3500);

    }
}
