package com.example.sds_mobileproject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> items;
    static ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.add_btn);
        Button switchToCalc = (Button) findViewById(R.id.Calculator);
        listView = findViewById(R.id.listView);
        Resources res = getResources();

        items = new ArrayList<>();
        items.add("Chicken 165Kcal");
        items.add("Pork 120Kcal");
        items.add("Paprika 289Kcal");
        items.add("RiceRaw 350Kcal");

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);




        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                //TextView resultTextView = (TextView) findViewById(R.id.resultTextView);


                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;
                //resultTextView.setText(result + "");

            }
        });

        switchToCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivites();
            }
        });
    }

    private void switchActivites() {
        Intent switchAcitivityIntent = new Intent(this, CalculatorActivity.class);
        startActivity(switchAcitivityIntent);
    }
}