package com.madla.madlaherrellwaynelabact3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et = (EditText) findViewById(R.id.editText);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        final EditText et3 = (EditText) findViewById(R.id.editText3);
        final EditText et4 = (EditText) findViewById(R.id.editText4);
        final EditText et5 = (EditText) findViewById(R.id.editText5);
        final EditText et6 = (EditText) findViewById(R.id.editText6);
        final EditText et7 = (EditText) findViewById(R.id.editText7);
        final EditText et8 = (EditText) findViewById(R.id.editText8);

        Button button1 = (Button) findViewById(R.id.btnNext);
        button1.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v) {
                openNextActivity();
            }
        });

        Button button2 = (Button) findViewById(R.id.btnSave);
        button2.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v) {
        String s1 = et.getText().toString().toLowerCase() + "/";
        String s2 = et2.getText().toString().toLowerCase() + "/";
        String s3 = et3.getText().toString().toLowerCase() + "/";
        String s4 = et4.getText().toString().toLowerCase() + "/";
        String s5 = et5.getText().toString().toLowerCase() + "/";
        String s6 = et6.getText().toString().toLowerCase() + "/";
        String s7 = et7.getText().toString().toLowerCase() + "/";
        String s8 = et8.getText().toString().toLowerCase() + "/";
        FileOutputStream writer = null;

        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(s1.getBytes());
            writer.write(s2.getBytes());
            writer.write(s3.getBytes());
            writer.write(s4.getBytes());
            writer.write(s5.getBytes());
            writer.write(s6.getBytes());
            writer.write(s7.getBytes());
            writer.write(s8.getBytes());
        }catch (FileNotFoundException e){
            Log.d("error", "File not found.");
        } catch (IOException e) {
            Log.d("error", "IO error.");
        }finally{
            try{
                writer.close();
            }catch (IOException e){
                Log.d("error", "File not found.");
            }
        }
        Toast.makeText(getApplicationContext(), "Data saved in internal storage.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void openNextActivity() {
        Intent intent = new Intent(getApplicationContext(), SchoolActivity.class);
        startActivity(intent);
    }




}
