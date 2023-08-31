package com.example.sds_mobileproject;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    String[] items;
    String[] description;
    String[] calories;
    //int[] calories;

    static ListView calcListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Resources res = getResources();
        items = res.getStringArray(R.array.items);
        //eatingTimes = res.getStringArray(R.array.eatingTimes);
        description = res.getStringArray(R.array.description);
        calories = res.getStringArray(R.array.kcals);
        //calories = res.getIntArray(R.array.cals);

        Button addBtn = (Button) findViewById(R.id.addBtn);

        calcListView = findViewById(R.id.calcListView);

        items = res.getStringArray(R.array.items);
        //eatingTimes = res.getStringArray(R.array.eatingTimes);
        description = res.getStringArray(R.array.description);
        calories = res.getStringArray(R.array.kcals);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, description, calories);
        calcListView.setAdapter(itemAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
                EditText amountEditText= (EditText) findViewById(R.id.amountEditText);
                //TODO add that when list item is clicked, it checks that the gram box is not empty(Then warns if it is) and then adds it to the list

                float result = Integer.parseInt(calories[1].replaceAll("[\\D]", ""));
                //float result = calories[1];
                float grams = Integer.parseInt(amountEditText.getText().toString());


                float trueResult = result * (grams / 100);

                resultTextView.setText(trueResult + "");
            }
        });
    }
}