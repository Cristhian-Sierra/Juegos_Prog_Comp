package com.example.juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Memoria extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewScore1;
    private TextView textViewScore2;
    private TextView textViewTurno;
    private TextView textViewLoser;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Button buttonE;
    private Button buttonF;
    private Button buttonG;
    private Button buttonH;
    private Button buttonI;
    private Button buttonRestart;
    private Button buttonMenu2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);

        this.textViewScore1 = findViewById(R.id.textViewScore1);
        this.textViewScore2 = findViewById(R.id.textViewScore2);
        this.textViewTurno = findViewById(R.id.textViewTurno);
        this.textViewLoser = findViewById(R.id.textViewLoser);
        this.buttonA = findViewById(R.id.buttonA);
        this.buttonB = findViewById(R.id.buttonB);
        this.buttonC = findViewById(R.id.buttonC);
        this.buttonD = findViewById(R.id.buttonD);
        this.buttonE = findViewById(R.id.buttonE);
        this.buttonF = findViewById(R.id.buttonF);
        this.buttonG = findViewById(R.id.buttonG);
        this.buttonH = findViewById(R.id.buttonH);
        this.buttonI = findViewById(R.id.buttonI);
        this.buttonRestart = findViewById(R.id.buttonRestart);
        this.buttonMenu2 = findViewById(R.id.buttonMenu2);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonH.setOnClickListener(this);
        buttonI.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int score1, score2,turno, contador=1;
        contador++;
        turno = contador%2;
        if(turno == 1){
            Secuencia(v);
        }
        else{
            Secuencia(v);
        }
    }

    private void Secuencia (View v){
        List<String> list = new ArrayList<>();
        Secuencia(v);
        if(v.getId()==R.id.buttonA){

        }
    }

    private void Comparar(){

    }
}