package com.example.sharedpreferenceapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer nCount = 0;
    private TextView nCountTextView;
    private SharedPreferences nSharedPref;
    private final String sharedPrefFile = "com.example.sharedPreferenceApp";
    private final String CountKey = "count-key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nSharedPref = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        nCountTextView = findViewById(R.id.tv_count);
        nCount = nSharedPref.getInt(CountKey, 0);

        nCountTextView.setText(nCount.toString());

        findViewById(R.id.btn_decrement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nCount > 0){
                    nCount--;
                    nCountTextView.setText(nCount.toString());
                    saveCount();
                }
            }
        });

        findViewById(R.id.btn_increment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nCount++;
                nCountTextView.setText(nCount.toString());
                saveCount();
            }
        });
    }

    private void saveCount(){
        SharedPreferences.Editor editor = nSharedPref.edit();
        editor.putInt(CountKey, nCount);
        editor.apply();
    }
}
