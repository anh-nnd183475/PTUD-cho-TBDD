package com.anhnnd.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText calculation, result;
    private String curr, res;
    private Button btnCE, btnC, btnBackspace, btnDivision, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnMulti, btnSub, btnEqual, btnDot, btnSign, btnPlus;
    private boolean dot_insert, operator_intsert, sign_insert, set_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnMulti = (Button) findViewById(R.id.btnmulti);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnSign = (Button) findViewById(R.id.btnSign);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnC = (Button) findViewById(R.id.btnC);
        btnCE = (Button) findViewById(R.id.btnCE);
        btnBackspace = (Button) findViewById(R.id.btnBackspace);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0";
                displayOne();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayOne();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayOne();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayOne();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayOne();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayOne();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayOne();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayOne();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayOne();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayOne();
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curr.isEmpty()) {
                    curr = "0.";
                    dot_insert = true;
                }
                if (dot_insert == false) {
                    curr = curr + ".";
                    dot_insert = true;
                }
                displayOne();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayOne();
                displayTwo();
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearEntry();
                displayOne();
                displayTwo();
            }
        });
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
                displayOne();
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_insert = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_intsert == false) {
                        curr = curr + " / ";
                        operator_intsert = true;
                    }
                }
                displayOne();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_insert = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_intsert == false) {
                        curr = curr + " + ";
                        operator_intsert = true;
                    }
                }
                displayOne();
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_insert = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_intsert == false) {
                        curr = curr + " * ";
                        operator_intsert = true;
                    }
                }
                displayOne();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_insert = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_intsert == false) {
                        curr = curr + " - ";
                        operator_intsert = true;
                    }
                }
                displayOne();
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator_intsert == true && !curr.substring(curr.length()-1, curr.length()).equals(" ")) {
                    String[] tokens = curr.split(" ");
                    switch (tokens[1].charAt(0)) {

                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            set_equal = true;
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            set_equal = true;
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            set_equal = true;
                            break;
                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            set_equal = true;
                            break;
                    }
                    displayTwo();
                }
            }
        });
    }
    public void displayOne() {
        calculation.setText(curr);
    }

    public void displayTwo() {
        calculation.setText(res);
    }

    public void clear() {
        curr = "";
        res = "";
        dot_insert = false;
        operator_intsert = false;
    }

    public void backspace() {
        //check if curr is empty or not
        if (!curr.isEmpty()) {
            if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                dot_insert = false;
            }
            if (curr.substring(curr.length() - 1, curr.length()).equals(" ")) {
                curr = curr.substring(0, curr.length() - 3);
                operator_intsert = false;
            } else {
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
    public void clearEntry(){
        if (!curr.isEmpty()) {
            if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                dot_insert = false;
            }
            while(!(curr.substring(curr.length() - 1, curr.length()).equals(" "))) {
                    curr = curr.substring(0, curr.length() - 1);
                }
            }
        }
}