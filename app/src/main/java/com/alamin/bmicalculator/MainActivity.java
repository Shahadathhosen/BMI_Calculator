package com.alamin.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edWeight, edFeet, edInch;
    Button btnBmi;
    TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edWeight = findViewById(R.id.edWeight);
        edFeet = findViewById(R.id.edFeet);
        edInch = findViewById(R.id.edInch);
        btnBmi = findViewById(R.id.btnBmi);
        txtDisplay = findViewById(R.id.txtDisplay);



        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sWeight = edWeight.getText().toString();
                String sFeet = edFeet.getText().toString();
                String sInch = edInch.getText().toString();

                if (sWeight.length() >0 && sFeet.length() >0 && sInch.length() >0 ) {

                    float weigth = Float.parseFloat(sWeight);
                    float feet = Float.parseFloat(sFeet);
                    float inch = Float.parseFloat(sInch);


                    float height = (float) (feet * 0.3048 + inch * 0.0254);
                    float bmiIndex = weigth / (height * height);

                    if (bmiIndex < 18.5) {
                        Toast.makeText(MainActivity.this, "Under Weight", Toast.LENGTH_SHORT).show();
                        txtDisplay.setText("Bmi is : " + bmiIndex);
                    } else if (bmiIndex < 24.5) {
                        Toast.makeText(MainActivity.this, "Normal", Toast.LENGTH_SHORT).show();
                        txtDisplay.setText("Bmi is : " + bmiIndex);
                    } else if (bmiIndex < 30) {
                        Toast.makeText(MainActivity.this, "Over Weight", Toast.LENGTH_SHORT).show();
                        txtDisplay.setText("Bmi is : " + bmiIndex);
                    } else {
                        Toast.makeText(MainActivity.this, "Obese", Toast.LENGTH_SHORT).show();
                        txtDisplay.setText("Bmi is : " + bmiIndex);
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}