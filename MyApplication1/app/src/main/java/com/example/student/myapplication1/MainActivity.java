package com.example.student.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String my_key = "mykey";

    private ImageView imageView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.changeButton);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView helloText = (TextView) findViewById(R.id.helloText);
        final Button saveButton = (Button) findViewById(R.id.saveButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox1);
        isCheked(checkBox.isChecked());
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //    Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
                final String editTextValue = editText.getText().toString();
                helloText.append(editTextValue);
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra(my_key,editTextValue);
                startActivityForResult(intent, 100);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.cahnge);
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isCheked(b);
            }
        });
    }

    private void isCheked(boolean b) {
        if (b) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== RESULT_OK){
            if (requestCode == 100 && data != null){
                String strmessage= data.getStringExtra("keyanme");
            }
        }
    }
}
