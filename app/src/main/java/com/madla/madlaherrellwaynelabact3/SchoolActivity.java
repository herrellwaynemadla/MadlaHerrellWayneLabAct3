package com.madla.madlaherrellwaynelabact3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SchoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        setTitle("SCHOOL WEBSITE");
        FileInputStream file1 = null;
        Button sb1 =  (Button)findViewById(R.id.btn1);
        Button sb2 =  (Button)findViewById(R.id.btn2);
        Button sb3 =  (Button)findViewById(R.id.btn3);
        Button sb4 =  (Button)findViewById(R.id.btn4);
        Button sb5 =  (Button)findViewById(R.id.btn5);
        Button sb6 =  (Button)findViewById(R.id.btn6);
        Button sb7 =  (Button)findViewById(R.id.btn7);
        Button sb8 =  (Button)findViewById(R.id.btn8);
        Button button1 = (Button) findViewById(R.id.btnPrev);
        button1.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v) {
                openPrevActivity();
            }
        });
        try {
            file1 = openFileInput("data1.txt");
            int token;
            String strBA = "";
            while ((token = file1.read()) != -1){
                strBA = strBA + ((char)token);
            }
            file1.close();
            try {
                String[] list = strBA.split("/");
                sb1.setText(list[0]);
                sb2.setText(list[1]);
                sb3.setText(list[2]);
                sb4.setText(list[3]);
                sb5.setText(list[4]);
                sb6.setText(list[5]);
                sb7.setText(list[6]);
                sb8.setText(list[7]);
            } catch (Exception e) {
                Log.d("error", "No strings.");
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found.");
        } catch (IOException e) {
            Log.d("error", "IO error.");
        }
    }

    public void openPrevActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
