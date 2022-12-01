package com.tudor.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        sharedPreferences = getSharedPreferences("myFile", 0);

        loadData();
    }

    @SuppressLint("CommitPrefEdits")
    public void saveData(View view){
        String textToSave = editText.getText().toString();

        sharedPreferences.edit().putString("myText", textToSave).apply();
    }

    public void loadData(){
        String textToLoad = sharedPreferences.getString("myText", "Haatz");

        editText.setText(textToLoad);
    }
}