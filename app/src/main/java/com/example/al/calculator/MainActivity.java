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

import org.w3c.dom.Text;

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
    boolean isSecond = false;
    char operator;
    String calculatedAnswer;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSecond == false && first != 0) {
                    isSecond = true;
                    first = Integer.parseInt(screen.getText().toString());
                }else if (isSecond == true){
                    isSecond = false;
                    second = Integer.parseInt(screen.getText().toString());
                }
                    operator = '+';
                    clearValsOnScreen = true;
                }
            });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSecond == false) {
                    isSecond = false;
                    first = Integer.parseInt(screen.getText().toString());
                }else {
                    isSecond = true;
                    second = Integer.parseInt(screen.getText().toString());
                }
                operator = '-';
                clearValsOnScreen = true;
            }

        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSecond == false) {
                    isSecond = false;
                    first = Integer.parseInt(screen.getText().toString());
                }else {
                    isSecond = true;
                    second = Integer.parseInt(screen.getText().toString());
                }
                operator = '*';
                clearValsOnScreen = true;
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (screen.getText() != "") {
                    isSecond = false;
                    first = Integer.parseInt(screen.getText().toString());
                }else {
                    isSecond = true;
                    second = Integer.parseInt(screen.getText().toString());
                }
                operator = '/';
                clearValsOnScreen = true;
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (screen.getText() != "") {
                    isSecond = false;
                    first = Integer.parseInt(screen.getText().toString());
                    first /= 100;
                }else {
                    isSecond = true;
                    second = Integer.parseInt(screen.getText().toString());
                    second /= 100;
                }
                operator = '%';
                clearValsOnScreen = true;
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (operator){
                    case '+':
                        answer = first + second;
                        break;

                    case '-':
                        answer = first - second;
                        break;

                    case '/':
                        answer = first / second;
                        break;

                    case '*':
                        answer = first * second;
                        break;

                    default:
                        Log.i("ANSWER:", Integer.toString(answer));
                        screen.setText("");
                        break;

                }
                clearValsOnScreen = false;
                isSecond = false;
                first = answer;
                operator = ' ';
                calculatedAnswer = Integer.toString(answer);
                screen.setText(calculatedAnswer);
                String toastMessage = first + ", " + second + ", " + "Ans:" + answer;
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("");
                isSecond = false;
                first = 0;
                second = 0;
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

    }

    String getTextfieldText(){
        String text = screen.getText().toString();
        return text;
    }
}
