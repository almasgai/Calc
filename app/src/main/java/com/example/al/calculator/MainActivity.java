package com.example.al.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Al on 2/17/18.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clear = (Button) findViewById(R.id.clear);
        Button negOrPos = (Button) findViewById(R.id.posOrNeg);
        Button percent = (Button) findViewById(R.id.percent);
        Button divide = (Button) findViewById(R.id.divide);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button minus =  (Button) findViewById(R.id.minus);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button plus = (Button) findViewById(R.id.plus);
        Button zero = (Button) findViewById(R.id.zero);
        Button decimal = (Button) findViewById(R.id.decimal);
        Button equals = (Button) findViewById(R.id.equals);


        Toast.makeText(this, "Howdy there partner", Toast.LENGTH_SHORT).show();
        
        
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked the clear button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    

}
