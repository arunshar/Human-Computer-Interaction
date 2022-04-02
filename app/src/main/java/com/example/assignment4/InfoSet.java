package com.example.assignment4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoSet extends AppCompatActivity{
        Button b1,b2;
        EditText ed1,ed2;
        TextView tx1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.infoset);

            b1 = (Button) findViewById(R.id.button);
            ed1 = (EditText) findViewById(R.id.pricingText);
            //ed2 = (EditText) findViewById(R.id.editText2);


            b2 = (Button) findViewById(R.id.button2);
            tx1 = (TextView) findViewById(R.id.textView3);
            tx1.setVisibility(View.GONE);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myFancyMethod(v);
                }
            });

        }
        public void myFancyMethod(View v) {
            Intent intent = new Intent(InfoSet.this, MainActivity.class);
            startActivity(intent);
        }
    }
