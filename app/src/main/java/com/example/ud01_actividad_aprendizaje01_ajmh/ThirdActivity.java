package com.example.ud01_actividad_aprendizaje01_ajmh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView textViewText = findViewById(R.id.textView);
        TextView textViewNumber = findViewById(R.id.textView3);
        TextView textViewNumberDecimal = findViewById(R.id.textView4);
        TextView textViewSwitchState = findViewById(R.id.textView5);

        Intent intent = getIntent();
        String text = intent.getStringExtra("Text");
        int number = intent.getIntExtra("Number", 0); // Cambiado a getIntExtra
        double numberDecimal = intent.getDoubleExtra("NumberDecimal", 0.0); // Cambiado a getDoubleExtra
        boolean switchState = intent.getBooleanExtra("SwitchState", false);

        textViewText.setText("Text: " + text);
        textViewNumber.setText("Number: " + number);
        textViewNumberDecimal.setText("Number Decimal: " + numberDecimal);
        textViewSwitchState.setText("Switch is " + (switchState ? "ON" : "OFF"));

        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackToMain = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intentBackToMain);
            }
        });
    }
}
