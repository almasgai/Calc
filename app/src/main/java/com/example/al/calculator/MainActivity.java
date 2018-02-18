package com.example.al.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.grantland.widget.AutofitHelper;

import static android.os.Build.VERSION.SDK_INT;

/**
 * Created by Al on 2/17/18.
 */

public class MainActivity extends AppCompatActivity {
    TextView screen;
    Button clear, negOrPos, percent, divide, seven, eight, nine, multiply, four, five,
            six, minus, one, two, three, plus, zero, decimal, equals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear = (Button) findViewById(R.id.clear);
        negOrPos = (Button) findViewById(R.id.posOrNeg);
        percent = (Button) findViewById(R.id.percent);
        divide = (Button) findViewById(R.id.divide);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        multiply = (Button) findViewById(R.id.multiply);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        minus =  (Button) findViewById(R.id.minus);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        plus = (Button) findViewById(R.id.plus);
        zero = (Button) findViewById(R.id.zero);
        decimal = (Button) findViewById(R.id.decimal);
        equals = (Button) findViewById(R.id.equals);
        screen = (TextView) findViewById(R.id.screenText);
        AutofitHelper.create(screen);

        ArrayList<MainActivity> numbersToCalc = new ArrayList<>();

        Toast.makeText(this, "Howdy there partner:\t" + SDK_INT, Toast.LENGTH_SHORT).show();
        
        
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("");
            }
        });

        negOrPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getTextfieldText() != ""){
                    String temp = getTextfieldText();
                    Integer intTemp = Integer.parseInt(temp);

                    // Determining whether value is pos or negative already and flipping it
                    intTemp *= -1;

                }else Toast.makeText(MainActivity.this, "Enter a value first", Toast.LENGTH_SHORT).show();
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("0");
            }
        });

    }

    String getTextfieldText(){
        String text = screen.getText().toString();
        return text;
    }

}
