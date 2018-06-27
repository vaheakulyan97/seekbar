package com.example.student.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private EditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        textView = (EditText) findViewById(R.id.secondtext);
        String myValue = getIntent().getExtras().getString(MainActivity.my_key);
    }

    @Override
    public void onBackPressed() {
       //super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("keyanme", textView.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}
