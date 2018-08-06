package com.example.tobibur.printarrayexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tobibur.printarray.PrintArray;

public class MainActivity extends AppCompatActivity {

    String[] listItems = {"Apple", "Mango", "Banana"};
    Button mCheckButton, mRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckButton = findViewById(R.id.button);
        mCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintArray.diaCheckBox(mCheckButton,listItems,MainActivity.this);
            }
        });

        mRadioButton = findViewById(R.id.button2);
        mRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintArray.diaRadioBox(mRadioButton,listItems,MainActivity.this);
            }
        });
    }
}
