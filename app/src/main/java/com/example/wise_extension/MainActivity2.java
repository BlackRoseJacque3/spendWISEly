package com.example.wise_extension;

import static com.example.wise_extension.MainActivity.period;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button showButton = (Button) findViewById(R.id.showBugetButton);
        Button generateButton = (Button) findViewById(R.id.generateButton);


        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButtonR1 = (RadioButton) findViewById(R.id.radioButtonRule1);
                RadioButton radioButtonR2 = (RadioButton) findViewById(R.id.radioButtonRule2);
                RadioButton radioButtonR3 = (RadioButton) findViewById(R.id.radioButtonRule3);
                EditText savingsText = (EditText) findViewById(R.id.savingsPlainText);
                EditText spendingsText = (EditText) findViewById(R.id.spendingsPlainText);
                EditText othersText = (EditText) findViewById(R.id.othersPlainText2);
                int R1 = 0, R2 = 0, R3 = 0;
                    if (radioButtonR1.isChecked()) {
                    R1 = 1;
                } else if (radioButtonR2.isChecked()) {
                    R2 = 1;
                } else if (radioButtonR3.isChecked()) {
                    R3 = 1;
                }

                if (R1 == 1) {
                    double numberSavings, numberSpendings, numberOthers;
                    numberSavings = 0.2 * MainActivity.buget;
                    numberSpendings = 0.7 * MainActivity.buget;
                    numberOthers = 0.1 * MainActivity.buget;

                    savingsText.setText("Savings:" + numberSavings);
                    spendingsText.setText("Spendings:" + numberSpendings + "");
                    othersText.setText("Others:" + numberOthers + "");
                } else if (R2 == 1) {
                    double numberSavings, numberSpendings, numberOthers;
                    numberSavings = 0.2 * MainActivity.buget;
                    numberSpendings = 0.7 * MainActivity.buget;

                    savingsText.setText("Savings:" + numberSavings + "");
                    spendingsText.setText("Spendings:" + numberSpendings + "");
                } else if (R3 == 1) {
                    double numberSavings, numberSpendings, numberOthers;
                    String savings = savingsText.getText().toString();
                    String spendings = spendingsText.getText().toString();
                    String others = othersText.getText().toString();
                    savings = savings.substring(8);
                    spendings = spendings.substring(10);
                    others = others.substring(7);
                    numberSavings = Double.parseDouble(savings);
                    numberSpendings = Double.parseDouble(spendings);
                    numberOthers = Double.parseDouble(others);

                    savingsText.setText("Savings:" + numberSavings);
                    spendingsText.setText("Spendings:" + numberSpendings + "");
                    othersText.setText("Others:" + numberOthers + "");
                }
            }
        });
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restaurant listofRestaurants[] = new Restaurant[]{};
                Restaurant.GeneratingRestaurants(listofRestaurants);
                for(int ind = 0; ind < 20; ind = ind + 1) {
                    double Sum = 0, pond = 1;
                    double median_price;
                    for (int indi = 0; indi < 10; indi = indi + 1)
                        {
                            Sum = Sum + listofRestaurants[ind].listOfMenuElements[indi].getPrice() * listofRestaurants[ind].listOfMenuElements[indi].getHowMany();
                            pond = pond + listofRestaurants[ind].listOfMenuElements[indi].getHowMany();
                        }
                    median_price = Sum / pond;
                    listofRestaurants[ind].setAverage(median_price);
                }

                Restaurant aux = new Restaurant();
                for(int i=0;i<19;i++)
                    for(int j=i+1;j<20;j++)
                        if(listofRestaurants[i].average > listofRestaurants[j].average)
                        {
                            aux = listofRestaurants[i];
                            listofRestaurants[i] = listofRestaurants[j];
                            listofRestaurants[j] = aux;
                        }
                EditText Dining = (EditText) findViewById(R.id.diningOutPlainText);
                String priceDining = Dining.getText().toString();
                priceDining = priceDining.substring(12);
                double pDining = Double.parseDouble(priceDining);
                double priceForADining = pDining/period;
                ArrayList<String> listOfFinalRestaurants = new ArrayList<>();
                ListView listView = (ListView) findViewById(R.id.listItems);
                int ind2 = 0;
                for(int ind = 0; ind < 20; ind++)
                    if(listofRestaurants[ind].average <= priceForADining) {
                        listOfFinalRestaurants.add(listofRestaurants[ind].name);
                        listOfFinalRestaurants.set(ind2, listofRestaurants[ind].name);
                        ind2++;
                    }
                ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, android.R.layout.simple_list_item_1,listOfFinalRestaurants);
                listView.setAdapter(adapter);
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                 }
            });
        }
    }
