package com.examen.preparacionexamenlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity {
   // ImageView imagenPerro;
    Button LOGIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //imagenPerro=(ImageView)findViewById(R.id.imagenPerro);Insertar una imagen con glide si es una imagen de alta resolucion
        //Glide.with(this).load(R.drawable.perro).apply(new RequestOptions().centerInside()).into(imagenPerro);

        //Para pasar a un nuevo activity clickando un boton, hacmeos lo siguiente:

        //Primero buscamos el boton en el activity
        LOGIN = findViewById(R.id.button1);
        //Ahora le asignamos en evento onCLick para pasar de una actividad a otra
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                startActivity(intent);
            }
        });


    }
}
