package com.example.al.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import me.grantland.widget.AutofitHelper;

/**
 * Created by Al on 2/17/18.
 */

public class MainActivity extends AppCompatActivity {
    TextView screen;
    Button clear, negOrPos, percent, divide, seven, eight, nine, multiply, four, five,
            six, minus, one, two, three, plus, zero, decimal, equals;
    boolean clearValsOnScreen = false;
    int first, second, answer;
    char operator;
    String temp;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = Integer.MIN_VALUE;
        second = Integer.MIN_VALUE;


        clear       = findViewById(R.id.clear);
        negOrPos    = findViewById(R.id.posOrNeg);
        percent     = findViewById(R.id.percent);
        divide      = findViewById(R.id.divide);
        seven       = findViewById(R.id.seven);
        eight       = findViewById(R.id.eight);
        nine        = findViewById(R.id.nine);
        multiply    = findViewById(R.id.multiply);
        four        = findViewById(R.id.four);
        five        = findViewById(R.id.five);
        six         = findViewById(R.id.six);
        minus       = findViewById(R.id.minus);
        one         = findViewById(R.id.one);
        two         = findViewById(R.id.two);
        three       = findViewById(R.id.three);
        plus        = findViewById(R.id.plus);
        zero        = findViewById(R.id.zero);
        decimal     = findViewById(R.id.decimal);
        equals      = findViewById(R.id.equals);
        screen      = findViewById(R.id.screenText);
        AutofitHelper.create(screen);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operator = '+';
                if (screen.getText() != "" && first == Integer.MIN_VALUE){
                    first = Integer.parseInt(screen.getText().toString());
                    screen.setText("");
                }

                // This is most likely not need after all. Think about it: If first already has a
                // number value not equal to MIN_INT and this function gets called, plus will
                // copy the input from the screen and save it as second which will be the same value
                // as first
                /* if (first != Integer.MIN_VALUE && screen.getText() != ""){
                    second = Integer.parseInt(screen.getText().toString());
                    operator = '+';
                    equate();

                }*/

                else { Toast.makeText(getApplicationContext(), "Please enter value", Toast.LENGTH_SHORT).show(); }

                screen.setText("");

            }
        });


        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), first + ", " + second, Toast.LENGTH_LONG).show();

                second = Integer.parseInt(screen.getText().toString());

                switch (operator){

                    case '+':
                        answer = first + second;
                        temp = Integer.toString(answer);
                        screen.setText(temp);
                        break;

                    case '-':
                        answer = first - second;
                        break;

                    case '/':   answer = first / second;
                        break;

                    case '*':   answer = first * second;
                        break;

                    default:
                        Log.i("ANSWER:", Integer.toString(answer));
                        screen.setText("");
                        break;

                }

                Toast.makeText(getApplicationContext(), first + ", " + second + ", " + temp, Toast.LENGTH_LONG).show();

                    temp = Integer.toString(answer);
                    screen.setText(temp);
                    first = answer;
                    second = Integer.MIN_VALUE;
                }


        });

        
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("");
                first = Integer.MIN_VALUE;
                second = Integer.MIN_VALUE;
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("1");

                one.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        one.setTextColor(Color.WHITE);
                    }
                }, 500);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("2");
                two.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        two.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("3");
                three.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        three.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("4");
                four.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        four.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("5");
                five.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        five.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("6");
                six.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        six.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("7");
                seven.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        seven.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("8");
                eight.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        eight.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("9");
                nine.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        nine.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen == true){
                    screen.setText("");
                    clearValsOnScreen = false;
                }
                screen.append("0");
                zero.setTextColor(Color.CYAN);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        zero.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });

        negOrPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(screen.getText().toString());
                temp *= -1;
                screen.setText(temp);

            }
        });
    }
    public void equate(){ equals.performClick(); }


}
