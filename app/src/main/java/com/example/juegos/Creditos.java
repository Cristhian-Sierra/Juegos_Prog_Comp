package com.example.juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Creditos extends AppCompatActivity implements View.OnClickListener {
    Button btnnMnu;
    String nombre1;
    String nombre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            nombre1=bundle.getString("name1");
            nombre2=bundle.getString("name2");
        }
        btnnMnu = (Button)findViewById(R.id.btnMnu3);
        btnnMnu.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Boton(nombre1,nombre2,v);
    }
    public void Boton(String nom1,String nom2, View v){
    if(R.id.btnMnu3==v.getId()){
        Intent intent = new Intent(v.getContext(), Opciones.class);
        Bundle miBundle= new Bundle();
        miBundle.putString("name1",nombre1);
        miBundle.putString("name2",nombre2);
        intent.putExtras(miBundle);
        startActivity(intent);
    }
    }
}