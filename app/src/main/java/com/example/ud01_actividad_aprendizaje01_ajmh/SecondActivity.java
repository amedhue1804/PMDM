package com.example.ud01_actividad_aprendizaje01_ajmh;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etText = findViewById(R.id.editTextText);
        EditText etNumber = findViewById(R.id.editTextNumber);
        EditText etNumberDecimal = findViewById(R.id.editTextNumberDecimal);
        Switch sw1 = findViewById(R.id.switch1);
        Button btnenv2 = findViewById(R.id.btnenv2);
        Button btnBack2 = findViewById(R.id.btnback2);

        btnenv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etText.getText().toString().isEmpty()) {
                    Toast toastName = new Toast(SecondActivity.this);
                    toastName.setText("Text can´t be empty");
                    toastName.show();
                } else if (etNumber.getText().toString().isEmpty()) {
                    Toast toastSurname = new Toast(SecondActivity.this);
                    toastSurname.setText("Number can´t be empty");
                    toastSurname.show();
                } else if (etNumberDecimal.getText().toString().isEmpty()) {
                    Toast toastSurname = new Toast(SecondActivity.this);
                    toastSurname.setText("Number Decimal can´t be empty");
                    toastSurname.show();

                } else {
                    int etnumber2= Integer.parseInt(etNumber.getText().toString());
                    double etnumberdecimal2= Double.parseDouble(etNumberDecimal.getText().toString());
                    boolean switchState = sw1.isChecked();

                    Intent intentThirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                    intentThirdActivity.putExtra("Text", etText.getText().toString());
                    intentThirdActivity.putExtra("Number", etnumber2);
                    intentThirdActivity.putExtra("NumberDecimal", etnumberdecimal2);
                    intentThirdActivity.putExtra("SwitchState", switchState);


                    Log.i("Text", etText.getText().toString());
                    Log.i("Number", etNumber.getText().toString());
                    Log.i("NumberDecimal", etNumberDecimal.getText().toString());
                    Log.i("SwitchState", "Switch is " + (switchState ? "ON" : "OFF"));

                    startActivity(intentThirdActivity);
                }
            }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack2 = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intentBack2);
            }
        });
    }
}
