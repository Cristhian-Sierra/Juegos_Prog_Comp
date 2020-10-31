package com.example.juegos;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button btn_begin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nombre1,nombre2;
        nombre1=(EditText)findViewById(R.id.txt_name1);
        nombre2=(EditText)findViewById(R.id.txt_name2);
        btn_begin = (Button) findViewById(R.id.btn_begin);
        btn_begin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Opciones.class);
                intent.putExtra("name1", nombre1.getText().toString());
                intent.putExtra("name2", nombre2.getText().toString());
                startActivityForResult(intent, 0);
            }

        });
    }
}