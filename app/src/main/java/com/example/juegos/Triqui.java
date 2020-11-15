package com.example.juegos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Triqui extends AppCompatActivity implements View.OnClickListener {
    int turno,cont;
    int acumJ1=0;
    int acumJ2=0;
    int acumEmpates=0;
    int cantidadbot=0,activador=0;
    String letra;
    String nombre1;
    String nombre2;
    TextView txtN1;
    TextView textViewJu1;
    TextView textViewJu2;
    TextView txtresul1;
    TextView txtresul2;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btnR;
    Button btnMnu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triqui);
        txtN1 = (TextView) findViewById(R.id.txtJugador1);
        txtresul1=(TextView) findViewById(R.id.textViewPuntaje1);
        txtresul2=(TextView) findViewById(R.id.textViewPuntaje2);
        textViewJu1=(TextView) findViewById(R.id.textViewJu1);
        textViewJu2=(TextView) findViewById(R.id.textViewJu2);
        txtresul2.setText(acumJ2+"");
        txtresul1.setText(acumJ1+"");
        Bundle bundle= getIntent().getExtras();
        if(bundle!=null) {
            nombre1 = bundle.getString("name1");
            //String aux = nombre1;
            txtN1.setText("Le toca a " + nombre1 + " con X");
            nombre2 = bundle.getString("name2");
            textViewJu1.setText(nombre1);
            textViewJu2.setText(nombre2);

            //String aux2 = nombre2;
           // txtN2.setText("Jugador " + nombre2 + " te toca jugar con O");

        }

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btnR = (Button) findViewById(R.id.btnReiniciar);
        btnMnu=(Button)findViewById(R.id.btnMenu2);

        //Metodos para dar eventos a cada boton
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener( this);
        btn3.setOnClickListener( this);
        btn4.setOnClickListener( this);
        btn5.setOnClickListener( this);
        btn6.setOnClickListener( this);
        btn7.setOnClickListener( this);
        btn8.setOnClickListener( this);
        btnR.setOnClickListener( this);
        btnMnu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        cont++;
        turno=cont%2; //Sacamos el modulo, depensiendo si es par(2j) o impar(1j)
        char x='X';
        char o='O';
        String color="";
        if(turno==1){//Jugador 1 con X
            color="#EF6136";
            ImprimirX_O(x,v,color,nombre1);
        }
        else{//Jugador 2 con O
            color="#EF6136";
            ImprimirX_O(o,v,color,nombre2);
        }

    }

    public void ImprimirX_O(char letra,View v,String color, String nom){
        if(v.getId()==R.id.btnMenu2 || v.getId()==R.id.btnReiniciar){

        if(v.getId()==R.id.btnMenu2){
            /*Intent intent = new Intent(v.getContext(), Opciones.class);
            Bundle miBundle= new Bundle();
            miBundle.putString("name1",nombre1);
            miBundle.putString("name2",nombre2);
            intent.putExtras(miBundle);
            startActivity(intent);*/
            Intent intent = new Intent(getApplicationContext(),Opciones.class);
            Bundle bundle2 = getIntent().getExtras();
            nombre1=bundle2.getString("name1");
            nombre2=bundle2.getString("name2");
            intent.putExtra("name1", nombre1);
            intent.putExtra("name2", nombre2);

            startActivity(intent);

        }
        else if(v.getId()==R.id.btnReiniciar){
            activador=0;
            cantidadbot=0;

            cont=0;
            btn0.setEnabled(true);
            btn0.setText("");

            btn1.setEnabled(true);
            btn1.setText("");

            btn2.setEnabled(true);
            btn2.setText("");

            btn3.setEnabled(true);
            btn3.setText("");

            btn4.setEnabled(true);
            btn4.setText("");

            btn5.setEnabled(true);
            btn5.setText("");

            btn6.setEnabled(true);
            btn6.setText("");

            btn7.setEnabled(true);
            btn7.setText("");

            btn8.setEnabled(true);
            btn8.setText("");
            txtN1.setText("Le toca a "+nombre1+" con X");
            String colorI="#000000";
            //Cambio de color de botones en reinicio
            btn0.setBackgroundColor(Color.parseColor(colorI));
            btn1.setBackgroundColor(Color.parseColor(colorI));
            btn2.setBackgroundColor(Color.parseColor(colorI));
            btn3.setBackgroundColor(Color.parseColor(colorI));
            btn4.setBackgroundColor(Color.parseColor(colorI));
            btn5.setBackgroundColor(Color.parseColor(colorI));
            btn6.setBackgroundColor(Color.parseColor(colorI));
            btn7.setBackgroundColor(Color.parseColor(colorI));
            btn8.setBackgroundColor(Color.parseColor(colorI));

        }
        }
        else if(v.getId()==R.id.btn0||v.getId()==R.id.btn1||v.getId()==R.id.btn2||v.getId()==R.id.btn3||v.getId()==R.id.btn4||v.getId()==R.id.btn5||v.getId()==R.id.btn6||v.getId()==R.id.btn7||v.getId()==R.id.btn8){
        if(v.getId()==R.id.btn0){
            btn0.setTextColor(Color.parseColor(color));
            btn0.setText(""+letra);
            btn0.setEnabled(false);
            cantidadbot++;
            System.out.println(cantidadbot);
            System.out.println(activador);

            //Ganador(letra,nom);
        }

        else  if(v.getId()==R.id.btn1){
            btn1.setTextColor(Color.parseColor(color));
            btn1.setText(""+letra);
            btn1.setEnabled(false);
            //Ganador(letra,nom);
            cantidadbot++;
            System.out.println(cantidadbot);
            System.out.println(activador);
        }

        else  if(v.getId()==R.id.btn2){
             btn2.setTextColor(Color.parseColor(color));
             btn2.setText(""+letra);
             btn2.setEnabled(false);
            //Ganador(letra,nom);
            cantidadbot++;
            System.out.println(cantidadbot);
            System.out.println(activador);
         }
        else  if(v.getId()==R.id.btn3){
             btn3.setTextColor(Color.parseColor(color));
             btn3.setText(""+letra);
             btn3.setEnabled(false);
            //Ganador(letra,nom);
            cantidadbot++;
            System.out.println(cantidadbot);
            System.out.println(activador);
         }
        else if(v.getId()==R.id.btn4){
             btn4.setTextColor(Color.parseColor(color));
             btn4.setText(""+letra);
             btn4.setEnabled(false);
            //Ganador(letra,nom);
            cantidadbot++;
            System.out.println(cantidadbot);
            System.out.println(activador);
         }
        else  if(v.getId()==R.id.btn5){
             btn5.setTextColor(Color.parseColor(color));
             btn5.setText(""+letra);
             btn5.setEnabled(false);
            //Ganador(letra,nom);
            cantidadbot++;
            System.out.println(cantidadbot);
            System.out.println(activador);
         }
        else  if(v.getId()==R.id.btn6){
             btn6.setTextColor(Color.parseColor(color));
             btn6.setText(""+letra);
             btn6.setEnabled(false);
            //Ganador(letra,nom);
            cantidadbot++;
            System.out.println(cantidadbot);
            System.out.println(activador);
         }
        else  if(v.getId()==R.id.btn7){
             btn7.setTextColor(Color.parseColor(color));
             btn7.setText(""+letra);
             btn7.setEnabled(false);
            cantidadbot++;
            //Ganador(letra,nom);
            System.out.println(cantidadbot);
            System.out.println(activador);
         }
        else  if(v.getId()==R.id.btn8){
             btn8.setTextColor(Color.parseColor(color));
             btn8.setText(""+letra);
             btn8.setEnabled(false);
            cantidadbot++;
            System.out.println(cantidadbot);
            System.out.println(activador);

         }

        Ganador(letra,nom);
        empate();
        }

    }
//METODO PARA DETERMINAR AL GANADOR
    public void Ganador(char letra, String nomb){
        String colorG="#123456";
        if(nomb==nombre1 && letra=='X'){//Condicional para acumular las victorias del jugador 1 con X
            txtN1.setText("Le toca a " +nombre2 + " con O");
            //Posibilidad de ganar 1
            if((btn0.getText().toString().equals(letra+""))&& (btn1.getText().toString().equals(letra+"") &&(btn2.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Se cambian los colores de donde esté el triqui
                btn0.setBackgroundColor(Color.parseColor(colorG));
                btn1.setBackgroundColor(Color.parseColor(colorG));
                btn2.setBackgroundColor(Color.parseColor(colorG));

                btn8.setEnabled(false);
                btn7.setEnabled(false);
                btn6.setEnabled(false);
                btn5.setEnabled(false);
                btn4.setEnabled(false);
                btn3.setEnabled(false);
                acumJ1+=1;
                activador=1;
            }
            //2 posibilidad
            else if((btn3.getText().toString().equals(letra+""))&& (btn4.getText().toString().equals(letra+"") &&(btn5.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Has ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el

                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Se cambian los colores de donde esté el triqui
                btn3.setBackgroundColor(Color.parseColor(colorG));
                btn4.setBackgroundColor(Color.parseColor(colorG));
                btn5.setBackgroundColor(Color.parseColor(colorG));

                btn8.setEnabled(false);
                btn7.setEnabled(false);
                btn6.setEnabled(false);
                btn0.setEnabled(false);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                acumJ1+=1;
                activador=1;
            }
            //3 posibilidad
            else if((btn6.getText().toString().equals(letra+""))&& (btn7.getText().toString().equals(letra+"") &&(btn8.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Salir de app", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();
                //Se cambian los colores de donde esté el triqui
                btn6.setBackgroundColor(Color.parseColor(colorG));
                btn7.setBackgroundColor(Color.parseColor(colorG));
                btn8.setBackgroundColor(Color.parseColor(colorG));

                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn0.setEnabled(false);
                btn1.setEnabled(false);
                btn2.setEnabled(false);

                acumJ1+=1;
                activador=1;
            }
            //4 posibilidad
            else if((btn0.getText().toString().equals(letra+""))&& (btn3.getText().toString().equals(letra+"") &&(btn6.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();
                //Se cambian los colores de donde esté el triqui
                btn0.setBackgroundColor(Color.parseColor(colorG));
                btn3.setBackgroundColor(Color.parseColor(colorG));
                btn6.setBackgroundColor(Color.parseColor(colorG));

                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                acumJ1+=1;
                activador=1;
            }
            //5Posibilidad
            else if((btn1.getText().toString().equals(letra+""))&& (btn4.getText().toString().equals(letra+"") &&(btn7.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Se cambian los colores de donde esté el triqui
                btn1.setBackgroundColor(Color.parseColor(colorG));
                btn4.setBackgroundColor(Color.parseColor(colorG));
                btn7.setBackgroundColor(Color.parseColor(colorG));

                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn8.setEnabled(false);
                btn0.setEnabled(false);
                acumJ1+=1;
                activador=1;
            }
            //6 posibilidad
            else if((btn2.getText().toString().equals(letra+""))&& (btn5.getText().toString().equals(letra+"") &&(btn8.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la  letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();
                //Se cambian los colores de donde esté el triqui
                btn2.setBackgroundColor(Color.parseColor(colorG));
                btn5.setBackgroundColor(Color.parseColor(colorG));
                btn8.setBackgroundColor(Color.parseColor(colorG));

                btn1.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn0.setEnabled(false);
                acumJ1+=1;
                activador=1;
            }
            //7 posibilidad

            else if((btn0.getText().toString().equals(letra+""))&& (btn4.getText().toString().equals(letra+"") &&(btn8.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Se cambian los colores de donde esté el triqui
                btn0.setBackgroundColor(Color.parseColor(colorG));
                btn4.setBackgroundColor(Color.parseColor(colorG));
                btn8.setBackgroundColor(Color.parseColor(colorG));

                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                acumJ1+=1;
                activador=1;
            }
            //8 posibilidad
            else if((btn2.getText().toString().equals(letra+""))&& (btn4.getText().toString().equals(letra+"") &&(btn6.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de e
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Se cambian los colores de donde esté el triqui
                btn2.setBackgroundColor(Color.parseColor(colorG));
                btn4.setBackgroundColor(Color.parseColor(colorG));
                btn6.setBackgroundColor(Color.parseColor(colorG));

                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn5.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                acumJ1+=1;
                activador=1;
            }
            txtresul2.setText(acumJ2+"");
            txtresul1.setText(acumJ1+"");
    }
        else if(nomb==nombre2 && letra=='O'){//Para acumular victorias de O
            txtN1.setText("Le toca a " +nombre1 + " con X");
            //Posibilidad de ganar 1
            if((btn0.getText().toString().equals(letra+""))&& (btn1.getText().toString().equals(letra+"") &&(btn2.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Se cambian los colores de donde esté el triqui
                btn0.setBackgroundColor(Color.parseColor(colorG));
                btn1.setBackgroundColor(Color.parseColor(colorG));
                btn2.setBackgroundColor(Color.parseColor(colorG));

                btn8.setEnabled(false);
                btn7.setEnabled(false);
                btn6.setEnabled(false);
                btn5.setEnabled(false);
                btn4.setEnabled(false);
                btn3.setEnabled(false);
                acumJ2+=1;
                activador=1;
            }
            //2 posibilidad
            else if((btn3.getText().toString().equals(letra+""))&& (btn4.getText().toString().equals(letra+"") &&(btn5.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Has ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el

                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Se cambian los colores de donde esté el triqui
                btn3.setBackgroundColor(Color.parseColor(colorG));
                btn4.setBackgroundColor(Color.parseColor(colorG));
                btn5.setBackgroundColor(Color.parseColor(colorG));

                btn8.setEnabled(false);
                btn7.setEnabled(false);
                btn6.setEnabled(false);
                btn0.setEnabled(false);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                acumJ2+=1;
                activador=1;
            }
            //3 posibilidad
            else if((btn6.getText().toString().equals(letra+""))&& (btn7.getText().toString().equals(letra+"") &&(btn8.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Salir de app", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                btn6.setBackgroundColor(Color.parseColor(colorG));
                btn7.setBackgroundColor(Color.parseColor(colorG));
                btn8.setBackgroundColor(Color.parseColor(colorG));

                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn0.setEnabled(false);
                btn1.setEnabled(false);
                btn2.setEnabled(false);

                acumJ2+=1;
                activador=1;
            }
            //4 posibilidad
            else if((btn0.getText().toString().equals(letra+""))&& (btn3.getText().toString().equals(letra+"") &&(btn6.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();
                //Cambio de color de botones en donde está el triqui
                btn0.setBackgroundColor(Color.parseColor(colorG));
                btn3.setBackgroundColor(Color.parseColor(colorG));
                btn6.setBackgroundColor(Color.parseColor(colorG));

                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                acumJ2+=1;
                activador=1;
            }
            //5Posibilidad
            else if((btn1.getText().toString().equals(letra+""))&& (btn4.getText().toString().equals(letra+"") &&(btn7.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Cambio de color de botones en donde está el triqui
                btn1.setBackgroundColor(Color.parseColor(colorG));
                btn4.setBackgroundColor(Color.parseColor(colorG));
                btn7.setBackgroundColor(Color.parseColor(colorG));

                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn8.setEnabled(false);
                btn0.setEnabled(false);
                acumJ2+=1;
                activador=1;
            }
            //6 posibilidad
            else if((btn2.getText().toString().equals(letra+""))&& (btn5.getText().toString().equals(letra+"") &&(btn8.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la  letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Cambio de color de botones en donde está el triqui
                btn2.setBackgroundColor(Color.parseColor(colorG));
                btn5.setBackgroundColor(Color.parseColor(colorG));
                btn8.setBackgroundColor(Color.parseColor(colorG));

                btn1.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn0.setEnabled(false);
                acumJ2+=1;
                activador=1;
            }
            //7 posibilidad

            else if((btn0.getText().toString().equals(letra+""))&& (btn4.getText().toString().equals(letra+"") &&(btn8.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de el
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Cambio de color de botones en donde está el triqui
                btn0.setBackgroundColor(Color.parseColor(colorG));
                btn4.setBackgroundColor(Color.parseColor(colorG));
                btn8.setBackgroundColor(Color.parseColor(colorG));

                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                acumJ2+=1;
                activador=1;
            }
            //8 posibilidad
            else if((btn2.getText().toString().equals(letra+""))&& (btn4.getText().toString().equals(letra+"") &&(btn6.getText().toString().equals(letra+""))))
            {
                AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
                alerta.setMessage("Ha ganado la letra "+letra)
                        .setCancelable(false)//Paara salir del aleert pulsando fuera de e
                        .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Felicidades");
                titulo.show();

                //Cambio de color de botones en donde está el triqui
                btn2.setBackgroundColor(Color.parseColor(colorG));
                btn4.setBackgroundColor(Color.parseColor(colorG));
                btn6.setBackgroundColor(Color.parseColor(colorG));

                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn5.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                acumJ2+=1;
                activador=1;
            }

            txtresul2.setText(acumJ2+"");
            txtresul1.setText(acumJ1+"");
        }
    }
    public void empate(){
        if(activador == 0 && cantidadbot == 9){

            AlertDialog.Builder alerta= new AlertDialog.Builder(Triqui.this);//Mensaje en cuadro de texto en alerta
            alerta.setMessage("Para tener una revacha presiona reiniciar")
                    .setCancelable(false)//Paara salir del aleert pulsando fuera de e
                    .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog titulo= alerta.create();
            titulo.setTitle("EMPATE");
            titulo.show();
        }
    }
}