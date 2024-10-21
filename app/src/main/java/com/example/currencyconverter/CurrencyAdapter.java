package com.example.currencyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CurrencyAdapter extends ArrayAdapter<CurrencyItem> {

    private Context context;
    private ArrayList<CurrencyItem> currencies;
    private double amountInRupees;

    public CurrencyAdapter(Context context, ArrayList<CurrencyItem> currencies, double amountInRupees) {
        super(context, 0, currencies);
        this.context = context;
        this.currencies = currencies;
        this.amountInRupees = amountInRupees;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_currency_item, parent, false);
        }

        CurrencyItem currencyItem = currencies.get(position);

        ImageView flagImageView = convertView.findViewById(R.id.flagImageView);
        TextView countryNameTextView = convertView.findViewById(R.id.countryNameTextView);
        TextView convertedAmountTextView = convertView.findViewById(R.id.convertedAmountTextView);

        flagImageView.setImageResource(currencyItem.getFlagImageResId());
        countryNameTextView.setText(currencyItem.getCountryName());
        double convertedAmount = amountInRupees * currencyItem.getConversionRate();
        convertedAmountTextView.setText(String.format("%.2f %s", convertedAmount, currencyItem.getCurrencyCode()));

        return convertView;
    }
}
