package com.example.sds_mobileproject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] items;
    String[] description;
    String[] calories;

    static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

        //Button addBtn = (Button) findViewById(R.id.add_btn);
        Button switchToCalc = (Button) findViewById(R.id.Calculator);
        listView = findViewById(R.id.calcListView);

        items = res.getStringArray(R.array.items);
        //eatingTimes = res.getStringArray(R.array.eatingTimes);
        description = res.getStringArray(R.array.description);
        calories = res.getStringArray(R.array.kcals);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, description, calories);
        listView.setAdapter(itemAdapter);

        /*addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                System.out.print()

                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                int position = items.length + 1;
                String name =  firstNumEditText.getText().toString();
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                String result = name + num2;
                items[position] = name;
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                resultTextView.setText(result + "");

            }
        });*/

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