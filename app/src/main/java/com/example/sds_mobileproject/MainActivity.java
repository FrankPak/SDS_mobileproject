package com.example.sds_mobileproject;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        Button switchToCalc = (Button) findViewById(R.id.Calculator);
        Button PortfolioButton = (Button) findViewById(R.id.PortfolioButton);

        listView = findViewById(R.id.calcListView);

        items = res.getStringArray(R.array.items);
        description = res.getStringArray(R.array.description);
        calories = res.getStringArray(R.array.kcals);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, description, calories);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.sds_mobileproject.ITEM_INDEX", position);
                startActivity(showDetailActivity);
            }
        });

        PortfolioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String portfoliUrl = "https://frankpak.github.io/WebPortfolio";
                Uri webaddress = Uri.parse(portfoliUrl);
                Intent gotoportfolio = new Intent(Intent.ACTION_VIEW, webaddress);

                    startActivity(gotoportfolio);
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