package com.example.sharedprefrens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtname,txtphone;
    Button btnsub,btnviw;
    String name;
    int phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = findViewById(R.id.name);
        txtphone = findViewById(R.id.phone);
        btnsub = findViewById(R.id.button);
        btnviw = findViewById(R.id.button2);

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name= txtname.getText().toString();
//       phone include get age text
                phone=Integer.parseInt(txtphone.getText().toString());

                SharedPreferences prf = getSharedPreferences("details",MODE_PRIVATE);
                SharedPreferences.Editor editor=prf.edit();
                editor.putString("name",name);
                editor.putString("phone", String.valueOf(phone));
                editor.commit();
                Toast.makeText(getApplicationContext(),"Data is Saved!!!",Toast.LENGTH_SHORT).show();

            }
        });



        btnviw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prf = getSharedPreferences("details",MODE_PRIVATE);
                String name = prf.getString("name","no name");
                String phoneString = prf.getString("phone", "0000");
                int phone = Integer.parseInt(phoneString);
                Toast.makeText(getApplicationContext(),"you Name is: "+name+"your Phone is:"+phone,Toast.LENGTH_SHORT).show();

            }
        });

    }





}