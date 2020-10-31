package com.example.juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;
import android.content.Intent;

public class Opciones extends AppCompatActivity {
    ListView listView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        Bundle bundle = getIntent().getExtras();
        String nombre1=bundle.getString("name1");
        String nombre2=bundle.getString("name2");

        listView = (ListView) findViewById(R.id.list_op);
        String[] values = new String[]{"MEMORY",
                    "TRIQUI","CREDITOS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new
         AdapterView.OnItemClickListener() {
              @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  int posicion = position;
                  String itemValue = (String) listView.getItemAtPosition(posicion);
                  switch (posicion)
                  {
                      case 0: intent = new
                              Intent(getApplicationContext(),Memoria.class);
                      break;
                      case 1: intent = new
                              Intent(getApplicationContext(),Triqui.class);
                      break;
                      case 2: intent = new
                              Intent(getApplicationContext(),Creditos.class);
                      break;
                  }
                  startActivity(intent);
         }
      });
    }
}