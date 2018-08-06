package com.example.tobibur.printarrayexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tobibur.printarray.PrintArray;

public class MainActivity extends AppCompatActivity {

    String[] listItems = {"Apple", "Mango", "Banana"};
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintArray.diaBox(mButton,listItems,MainActivity.this);
            }
        });
    }
}
