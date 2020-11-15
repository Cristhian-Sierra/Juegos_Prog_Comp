package com.example.juegos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.widget.*;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button btn_begin;
    private EditText txt_name1;
    private EditText txt_name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nombre1,nombre2;

        txt_name1 =(EditText)findViewById(R.id.txt_name1);
        txt_name2 =(EditText)findViewById(R.id.txt_name2);
        btn_begin = (Button) findViewById(R.id.btn_begin);
        nombre1= txt_name1;
        nombre2= txt_name2;

        btn_begin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(txt_name1.getText().equals("") && txt_name2.getText().equals("")){
                    AlertDialog.Builder alerta= new AlertDialog.Builder(MainActivity.this);//Mensaje en cuadro de texto en alerta
                    alerta.setMessage("Por favor ingrese los nombre de los jugadores")
                            .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                            .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog titulo= alerta.create();
                    titulo.setTitle("Campos vacios");
                    titulo.show();
                }
                else{
                    Intent intent = new Intent(v.getContext(), Opciones.class);
                    Bundle miBundle= new Bundle();
                    miBundle.putString("name1",nombre1.getText().toString());
                    miBundle.putString("name2",nombre2.getText().toString());
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }

        });
    }
}