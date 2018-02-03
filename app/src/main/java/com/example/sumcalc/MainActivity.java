package com.example.sumcalc;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity implements View.OnClickListener {

    //define widget instant variables
    private EditText editTextNumOne;
    private EditText editTextNumTwo;
    private Button button;
    private TextView textViewSum;

    //define Shared Pref object
    private SharedPreferences savedValues;

    //define variables to be saved
    private float num1 = .0f;
    private float num2 = .0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to the widgets
        editTextNumOne = (EditText) findViewById(R.id.editTextNumOne);
        editTextNumTwo = (EditText) findViewById(R.id.editTextNumTwo);
        button = (Button) findViewById(R.id.button);
        textViewSum = (TextView) findViewById(R.id.textViewSum);

        //set the listener
        button.setOnClickListener((View.OnClickListener) this);

        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    public void calculateAndDisplay() {
        num1 = Float.parseFloat(editTextNumOne.getText().toString());
        num2 = Float.parseFloat(editTextNumTwo.getText().toString());
        float sum = num1 + num2;

        textViewSum.setText(String.valueOf(sum));
    }

    @Override
    public void onClick(View view) {
        calculateAndDisplay();
    }
}
