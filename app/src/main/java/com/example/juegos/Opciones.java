package com.example.juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;
import android.content.Intent;

public class Opciones extends AppCompatActivity {
    ListView listView;
    Intent intent;
    String nombre1,nombre2;
    TextView txtN1,txtN2;
    //Bundle bundle = getIntent().getExtras();
    //String nombre1=bundle.getString("name1");
    //String nombre2=bundle.getString("name2");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        txtN1=(TextView)findViewById(R.id.txtN1);
        txtN2=(TextView)findViewById(R.id.txtN2);
        Bundle bundle= getIntent().getExtras();
        if(bundle!=null) {
            nombre1 = bundle.getString("name1");
            String aux = nombre1;
            txtN1 = (TextView) findViewById(R.id.txtN1);
            txtN1.setText("Jugador 1 " + aux );

            nombre2 = bundle.getString("name2");
            String aux2 = nombre2;
            txtN2 = (TextView) findViewById(R.id.txtN2);
            txtN2.setText("Jugador 2 " + aux2 );

        }
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
                  switch (posicion) {
                      case 0:
                          intent = new
                                  Intent(getApplicationContext(), Memoria.class);

                          break;
                      case 1:
                          intent = new Intent(getApplicationContext(), Triqui.class);
                          Bundle bundle = getIntent().getExtras();
                          String nombre1=bundle.getString("name1");
                          String nombre2=bundle.getString("name2");
                          intent.putExtra("name1", nombre1);
                          intent.putExtra("name2", nombre2);
                          //startActivityForResult(intent, 0);


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