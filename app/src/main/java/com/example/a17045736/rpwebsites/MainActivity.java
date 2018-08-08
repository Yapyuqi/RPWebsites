package com.example.a17045736.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1;
    Spinner spn2;
    Button btnGo;

    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        alCategory = new ArrayList<>();
        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);
        spn2.setAdapter(aaCategory);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                alCategory.clear();
               if(position ==0){
                   String[] strSubMenu = getResources().getStringArray(R.array.subcategory1);
                   alCategory.addAll(Arrays.asList(strSubMenu));
               } else if(position == 1){
                   String[] strSubMenu = getResources().getStringArray(R.array.subcategory2);
                   alCategory.addAll(Arrays.asList(strSubMenu));
               }
               aaCategory.notifyDataSetChanged();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "";
                if (spn1.getSelectedItemPosition() == 0) {
                    if (spn2.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/";
                    } else if (spn2.getSelectedItemPosition() == 1) {
                        url = "https://www.rp.edu.sg/student-life";
                    }
                } else if (spn1.getSelectedItemPosition() == 1) {
                    if (spn2.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    } else if (spn2.getSelectedItemPosition() == 1) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    }
                }
                Intent myIntent = new Intent(MainActivity.this, Webpage.class);
                myIntent.putExtra("url", url);
                startActivity(myIntent);
            }
            });



    }
}