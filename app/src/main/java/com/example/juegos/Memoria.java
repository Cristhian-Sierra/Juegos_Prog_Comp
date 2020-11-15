package com.example.juegos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Memoria extends AppCompatActivity {
    private String player1, player2;
    String buttonText;
    private Button buttonRestart;
    private Button buttonMenu2;
    private TextView textViewScoreName1;
    private TextView textViewScoreName2;
    private TextView textViewScore1;
    private TextView textViewScore2;
    private TextView textViewTurno;
    private TextView textViewLoser;
    private Button tiles[][] = new Button[3][3];;
    private GridLayout tableroCont;
    private long mLastClickTime = 0;
    private int turno;
    private ArrayList<Character> letras;
    private boolean remain;
    private int yield;
    private int puntaje1, puntaje2;

    @SuppressLint({"ResourceType", "ClickableViewAccessibility", "SetTextI18n"})
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);
        this.textViewScoreName1 = findViewById(R.id.textViewScoreName1);
        this.textViewScoreName2 = findViewById(R.id.textViewScoreName2);
        this.textViewScore1 = findViewById(R.id.textViewScore1);
        this.textViewScore2 = findViewById(R.id.textViewScore2);
        this.textViewTurno = findViewById(R.id.textViewTurno);
        this.textViewLoser = findViewById(R.id.textViewLoser);
        this.buttonRestart = findViewById(R.id.buttonRestart);
        this.buttonMenu2 = findViewById(R.id.buttonMenu2);
        this.turno = 1;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        tableroCont = findViewById(R.id.tableroCont);

        this.letras = new ArrayList<Character>();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            player1 = bundle.getString("name1");
            textViewScoreName1.setText(player1);
            player2 = bundle.getString("name2");
            textViewScoreName2.setText(player2);
        }
        textViewScore1.setText("" + puntaje1);
        textViewScore2.setText("" + puntaje2);
        int letra = 65;
        textViewTurno.setText((turno % 2 != 0 ? player1 : player2));
        this.remain = false;
        this.yield = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j] = new Button(this);
                tiles[i][j].setBackgroundResource(R.drawable.button_rounded);
                tiles[i][j].setMinHeight((int) (height * 0.40 / 3));
                tiles[i][j].setMinWidth((int) (width * 0.8 / 3));
                tiles[i][j].setMaxHeight((int) (height * 0.40 / 3));
                tiles[i][j].setMaxWidth((int) (width * 0.8 / 3));
                tiles[i][j].setText("" + (char) (letra));
                letra++;
                tableroCont.addView(tiles[i][j]);
                final int finalI = i;
                final int finalJ = j;
                final int finalI1 = i;
                final int finalJ1 = j;
                final int finalI2 = i;
                final int finalJ2 = j;
                tiles[i][j].setOnTouchListener(new View.OnTouchListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public boolean onTouch(View v, final MotionEvent motionEvent) {
                        Timer t = new Timer();
                        TimerTask tt = new TimerTask() {
                            @Override
                            public void run() {
                                tiles[finalI2][finalJ2].setBackgroundResource(R.drawable.button_rounded_border);
                            }
                        };
                        t.schedule(tt, 0, 100);
                        tiles[finalI2][finalJ2].setBackgroundResource(R.drawable.button_rounded);
                        // mis-clicking prevention, using threshold of 200 ms
                        if (SystemClock.elapsedRealtime() - mLastClickTime < 200) {
                            return true;
                        }
                        mLastClickTime = SystemClock.elapsedRealtime();
                        Button b = (Button) v;
                        buttonText = b.getText().toString();

                        if (letras.isEmpty()) {
                            letras.add(buttonText.charAt(0));
                            letras.add('0');
                            turno++;
                            yield = 0;
                            textViewTurno.setText((turno % 2 != 0 ? player1 : player2));
                            //textViewScore1.setText((turno % 2 != 0 ? puntaje1 : puntaje2));
                        } else if (letras.get(yield) != '0') {
                            if (!letras.get(yield).equals(buttonText.charAt(0))) {
                                for (int a = 0; a < 3; a++) {
                                    for (int a2 = 0; a2 < 3; a2++) {
                                        tiles[a][a2].setEnabled(false);
                                    }
                                }
                                AlertDialog.Builder alerta= new AlertDialog.Builder(Memoria.this);//Mensaje en cuadro de texto en alerta
                                alerta.setMessage("Gano "+ (turno % 2 != 0 ? player2 : player1))
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

                                if (turno % 2 != 0) {
                                    puntaje2++;
                                } else {
                                    puntaje1++;
                                }
                                textViewScore1.setText("" + puntaje1);
                                textViewScore2.setText("" + puntaje2);
                                return true;
                            } else {
                                yield++;
                            }
                        } else {
                            letras.remove(letras.get(yield));
                            letras.add(buttonText.charAt(0));
                            letras.add('0');
                            turno++;
                            yield = 0;
                            tiles[finalI1][finalJ1].setBackgroundResource(R.drawable.button_rounded_border);
                            textViewTurno.setText((turno % 2 != 0 ? player1 : player2));
                            tiles[finalI1][finalJ1].setBackgroundResource(R.drawable.button_rounded);
                        }
                        System.out.println(buttonText);
                        for (char letra : letras) {
                            System.out.print(letra + ' ');
                        }
                        return true;
                    }
                });
            }
        }
        buttonMenu2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(getApplicationContext(), Opciones.class);
                Bundle bundle2 = getIntent().getExtras();
                player1 = bundle2.getString("name1");
                player2 = bundle2.getString("name2");
                intent.putExtra("name1", player1);
                intent.putExtra("name2", player2);
                startActivity(intent);
                return false;
            }
        });
        buttonRestart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(getApplicationContext(), Opciones.class);
               Reiniciar();
                return false;
            }
        });
    }
    public void Reiniciar(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int letra =65;
    turno =0;
    letras.clear();
buttonText=null;

for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
        final int finalI = i;
        final int finalJ = j;
        final int finalI1 = i;
        final int finalJ1 = j;
        final int finalI2 = i;
        final int finalJ2 = j;
        tiles[i][j].setBackgroundResource(R.drawable.button_rounded);
        tiles[i][j].setEnabled(true);



    }
}

    }
    }
