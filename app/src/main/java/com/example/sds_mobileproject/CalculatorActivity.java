package com.example.sds_mobileproject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    String[] items;
    String[] description;
    String[] calories;
    float finalResult;

    static ListView calcListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Resources res = getResources();
        items = res.getStringArray(R.array.items);
        description = res.getStringArray(R.array.description);
        calories = res.getStringArray(R.array.kcals);

        Button resetBtn = (Button) findViewById(R.id.resetBtn);
        Button returnMainActivityBtn = (Button) findViewById(R.id.returnMainActivityBtn);

        calcListView = findViewById(R.id.calcListView);

        items = res.getStringArray(R.array.items);
        description = res.getStringArray(R.array.description);
        calories = res.getStringArray(R.array.kcals);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, description, calories);
        calcListView.setAdapter(itemAdapter);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView TotalTextView = (TextView) findViewById(R.id.TotalTextView);

                //TODO add that when list item is clicked, it checks that the gram box is not empty(Then warns if it is) and then adds it to the list

                finalResult = 0;
                TotalTextView.setText("Total Kcal");
            }
        });
        calcListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Boolean valid = true;
                TextView TotalTextView = (TextView) findViewById(R.id.TotalTextView);
                EditText amountEditText= (EditText) findViewById(R.id.amountEditText);

                //https://stackoverflow.com/questions/2709253/converting-a-string-to-an-integer-on-android
                float result = Integer.parseInt(calories[position].replaceAll("[\\D]", ""));
                try {
                    float grams = Integer.parseInt(amountEditText.getText().toString());
                    result = result * (grams / 100);
                    finalResult = finalResult + result;
                    finalResult = Math.round(finalResult);

                    TotalTextView.setText(finalResult + " Kcal");

                }catch (Exception e){
                    System.out.println("Didn't add grams");
                }

            }
        });

        returnMainActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivites();
            }
        });
    }

    private void switchActivites() {
        Intent switchAcitivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchAcitivityIntent);
    }
}