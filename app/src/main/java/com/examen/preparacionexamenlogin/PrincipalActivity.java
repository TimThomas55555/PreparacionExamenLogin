package com.examen.preparacionexamenlogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class PrincipalActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipelayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        swipelayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipelayout.setOnRefreshListener(mOnRefreshListener);



        button = findViewById(R.id.button);
        //Ahora le asignamos en evento onCLick para pasar de una actividad a otra
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogButtonClicked(PrincipalActivity.this);
            }
        });


        //SEÑECCIONO EL TEXTVIEW AL QUE LE VOY A METER EL MENUPULSADO
        TextView mycontext = (TextView) findViewById(R.id.textViewMenuPulsado);
        registerForContextMenu(mycontext);

    }







    //Creamos una funcion para el SwipeRefreshLayout, que es la barra de refrescar creada en el activity_principal

    //    construimos el Swipe y aplicamos un Listener que lanza un SnackBar y desactiva a continuación del Swipe la animación
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

//    opción TOAST
//
//          Toast toast0 = Toast.makeText(MainContextActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
//          toast0.show();


//   opción SNACKBAR

            final RelativeLayout mrelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

            Snackbar snackbar = Snackbar
                    .make(mrelativeLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mrelativeLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipelayout.setRefreshing(false);

        }
    };





    //CREAMOS EL MENU CON SUS ICONOS Y SUS OPCIONES DENTRO DEL MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.error) {
            showAlertDialogButtonClicked(PrincipalActivity.this);
        }
        if (id == R.id.camera) {
            Toast toast = Toast.makeText(this,"has clicado en la imagen de camara",Toast.LENGTH_LONG );
            toast.show();
        }
        if (id == R.id.otro) {
            Toast toast = Toast.makeText(this,"has clicado en la imagen de otro",Toast.LENGTH_LONG );
            toast.show();
        }
        if (id == R.id.action_settings) {
            showAlertDialogButtonClicked(PrincipalActivity.this);
        }
        if (id == R.id.action_settings1) {
            Toast toast = Toast.makeText(this,"has clicado en action_settings",Toast.LENGTH_LONG );
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }








    //CCREAMOS UNA FUNCION PARA CREAR LA VENTANA DE ALERTA, PODEMOS PONERLA DONDE QUERAMOS
    //EN ESTE CASO LO HEMOS METIDO EN BOTONES DEL MEN
    public void showAlertDialogButtonClicked(PrincipalActivity view) {

        // Creamos la ventana de alertar
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        //SI DESCOMENTO ESTAS 3 LINEAS Y COMENTO LA 4
      //  builder.setTitle("Achtung!");
      //  builder.setMessage("Where do you go?");
      //  builder.setIcon(R.drawable.ic_error);
        builder.setView(getLayoutInflater().inflate(R.layout.ventanaemergente, null));
    //EN LA LINEA DE ARRIBA CARGO EL XML PARA CARGAR LAS IMAGENES ETC...
        // add the buttons
        builder.setPositiveButton("Glide", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("ChatBot", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                startActivity(intent);

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("MotionLayout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                startActivity(intent);

                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }






    //MENU PULSADO

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pulsado, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.item:
                Toast toast = Toast.makeText(this,"going CONTEXT ITEM",
                        Toast.LENGTH_LONG );
                toast.show();
                return true;
            case R.id.action_settings:
                Toast toast2 = Toast.makeText(this,"going CONTEXT SETTINGS",
                        Toast.LENGTH_LONG );
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
