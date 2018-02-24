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

public class MainActivity extends AppCompatActivity{
    TextView screen;
    Button clear, negOrPos, percent, divide, seven, eight, nine, multiply, four, five,
            six, minus, one, two, three, plus, zero, decimal, equals;
    boolean clearValsOnScreen = false;
    double first, second, answer;
    char operator;
    String temp;
    int intTemp;
    double doubleTemp;
    boolean hasDecimal = false;



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

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    second = Double.parseDouble(screen.getText().toString());

                    switch (operator) {

                        case '+':
                            answer = first + second;
                            temp = Double.toString(answer);
                            screen.setText(temp);
                            break;

                        case '-':
                            answer = first - second;
                            temp = Double.toString(answer);
                            screen.setText(temp);
                            break;

                        case '/':
                            answer = first / second;
                            temp = Double.toString(answer);
                            screen.setText(temp);
                            break;

                        case '*':
                            answer = first * second;
                            temp = Double.toString(answer);
                            screen.setText(temp);
                            break;

                        default:
                            Log.i("ANSWER:", Double.toString(answer));
                            screen.setText("");
                            break;

                    }

                    doubleTemp = Double.parseDouble(Double.toString(answer));
                    answer = doubleTemp;

                        String literal = Double.toString(doubleTemp);
                        int length = literal.length();

                        if (length > 10) {
                            screen.setText(String.format("%.3f", doubleTemp));
                        } else {
                            screen.setText(String.valueOf(doubleTemp));
                        }

                    first = answer;
                    second = Integer.MIN_VALUE;
                    answer = Integer.MIN_VALUE;
                    hasDecimal = false;
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "ERROR:" + e.toString(), Toast.LENGTH_SHORT).show();
                }
                equals.setTextColor(Color.RED);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        equals.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!hasDecimal) {
                    if (screen.getText() != "") {
                        temp = screen.getText().toString();
                        temp += ".";
                        screen.setText(temp);
                    } else {
                        screen.setText("0.");
                    }
                }
                hasDecimal = true;
            }
        });


        negOrPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (first == Integer.MIN_VALUE || second == Integer.MIN_VALUE) {
                    if (screen.getText() == "-") {
                        screen.setText("");
                    }
                    else if (screen.getText() == ""){
                        screen.setText("-");
                    }
                    else {
                        if (first != Integer.MIN_VALUE) {
                            second = Double.parseDouble(screen.getText().toString());
                            second *= -1;
                            screen.setText(String.valueOf(second));
                        } else {
                            first = Double.parseDouble(screen.getText().toString());
                            first *= -1;
                            screen.setText(String.valueOf(first));
                        }
                    }

                    negOrPos.setTextColor(Color.RED);
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            negOrPos.setTextColor(Color.WHITE);
                        }
                    }, 250);
                }
                else if (screen.getText() == null || screen.getText() == ""){
                    screen.setText("-");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("");
                first = Integer.MIN_VALUE;
                second = Integer.MIN_VALUE;
                hasDecimal = false;

                clear.setTextColor(Color.RED);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        clear.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen){
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
                }, 250);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clearValsOnScreen){
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
                if (clearValsOnScreen){
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
                if (clearValsOnScreen){
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
                if (clearValsOnScreen){
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
                if (clearValsOnScreen){
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
                if (clearValsOnScreen){
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
                if (clearValsOnScreen){
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
                clearScreen();
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

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (second == Integer.MIN_VALUE) {

                    if (screen.getText() != "") {
                        doubleTemp = Double.parseDouble(screen.getText().toString());
                        doubleTemp /= 100;
                        screen.setText(String.valueOf(doubleTemp));
                    }
                }
                percent.setTextColor(Color.RED);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        percent.setTextColor(Color.WHITE);
                    }
                }, 250);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (second == Integer.MIN_VALUE){
                operator = '+';
                    if (screen.getText() != null && first == Integer.MIN_VALUE){
                        first = Double.parseDouble(screen.getText().toString());
                        if (first / Math.floor(first) != 1.0){
                            hasDecimal = true;
                        }
                    }
                }
                plus.setTextColor(Color.RED);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        plus.setTextColor(Color.WHITE);
                    }
                }, 250);


                // This is most likely not need after all. Think about it: If first already has a
                // number value not equal to MIN_INT and this function gets called, plus will
                // copy the input from the screen and save it as second which will be the same value
                // as first
                /* if (first != Integer.MIN_VALUE && screen.getText() != ""){
                    second = Integer.parseInt(screen.getText().toString());
                    operator = '+';
                    equate();

                }*/

                screen.setText(null);
                hasDecimal = false;
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (second == Integer.MIN_VALUE) {

                    operator = '*';
                    if (screen.getText() != null && first == Integer.MIN_VALUE) {
                        first = Double.parseDouble(screen.getText().toString());
                    }

                    screen.setText(null);
                    hasDecimal = false;

                    multiply.setTextColor(Color.RED);
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            multiply.setTextColor(Color.WHITE);
                        }
                    }, 250);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (second == Integer.MIN_VALUE) {
                    operator = '/';
                    if (screen.getText() != null && first == Integer.MIN_VALUE) {
                        first = Double.parseDouble(screen.getText().toString());
                    }

                    screen.setText(null);
                    hasDecimal = false;

                    divide.setTextColor(Color.RED);
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            divide.setTextColor(Color.WHITE);
                        }
                    }, 250);
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (second == Integer.MIN_VALUE) {
                    operator = '-';
                    if ((screen.getText() != null) && (first == Integer.MIN_VALUE)) {
                        first = Double.parseDouble(screen.getText().toString());
                    }

                    screen.setText(null);
                    hasDecimal = false;
                }
                minus.setTextColor(Color.RED);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        minus.setTextColor(Color.WHITE);
                    }
                }, 250);
            }

        });
    }

    public void clearScreen() {
        if (clearValsOnScreen) {
            screen.setText("");
            clearValsOnScreen = false;
        }
    }
}
