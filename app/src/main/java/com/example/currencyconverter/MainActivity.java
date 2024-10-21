package com.example.currencyconverter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAmount;
    private Button convertButton;
    private TextView resultText;
    private ListView currencyListView;
    private ArrayList<CurrencyItem> currencyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);
        currencyListView = findViewById(R.id.currencyListView);

        // Initialize Currency List
        currencyList = new ArrayList<>();
        populateCurrencyList();

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        String amountText = editTextAmount.getText().toString();

        if (TextUtils.isEmpty(amountText)) {
            Toast.makeText(MainActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double amountInRupees = Double.parseDouble(amountText);
            ArrayList<String> convertedValues = new ArrayList<>();

            for (CurrencyItem item : currencyList) {
                double convertedValue = amountInRupees * item.getConversionRate();
                convertedValues.add(item.getCountryName() + ": " + String.format("%.2f", convertedValue) + " " + item.getCurrencyCode());
            }

            CurrencyAdapter adapter = new CurrencyAdapter(MainActivity.this, currencyList, amountInRupees);
            currencyListView.setAdapter(adapter);

        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Enter only numbers", Toast.LENGTH_SHORT).show();
        }
    }

    // Populate the list with currency rates and flags
    private void populateCurrencyList() {
        currencyList.add(new CurrencyItem("United States", "USD", 0.012, R.drawable.flag_us));
        currencyList.add(new CurrencyItem("United Kingdom", "GBP", 0.0095, R.drawable.flag_uk));
        currencyList.add(new CurrencyItem("European Union", "EUR", 0.011, R.drawable.flag_eu));
        currencyList.add(new CurrencyItem("Japan", "JPY", 1.77, R.drawable.flag_japan));
        currencyList.add(new CurrencyItem("Australia", "AUD", 0.018, R.drawable.flag_aus));
        // Add more currencies as needed.
    }
}
