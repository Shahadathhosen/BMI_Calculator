package com.alamin.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

                float weigth = Float.parseFloat(sWeight);
                float feet = Float.parseFloat(sFeet);
                float inch = Float.parseFloat(sInch);

                float height = (float) (feet*0.3048 + inch*0.0254);

                float bmiIndex = weigth / (height*height);

                txtDisplay.setText("Your BMI Index is : " + bmiIndex);




            }
        });

    }
}