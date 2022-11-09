package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    TextView inputTv, outputTv;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPercent,btnPlus,btnMinus,btnMultiply,btnDivision,btnEqual,btnClear,btnBack,btnDot,btnBracket;
    String tamp;
    boolean checkBracket = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputTv = findViewById(R.id.inputTv);
        outputTv = findViewById(R.id.outputTv);


        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnClear = findViewById(R.id.btnClear);
        btnBack = findViewById(R.id.btnBack);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);

        btnEqual = findViewById(R.id.btnEqual);

        btnDot = findViewById(R.id.btnDot);

        btnPercent = findViewById(R.id.btnPercent);

        btnBracket = findViewById(R.id.btnBracket);




        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTv.setText("");
                outputTv.setText("");
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                if (tamp.length() != 0){
                    tamp = tamp.substring(0, tamp.length()-1);
                    inputTv.setText(tamp);
                }

            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             tamp = inputTv.getText().toString();
             inputTv.setText(tamp + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "9");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "+");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "-");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "×");
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "÷");
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "%");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + ".");
            }
        });
        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket){
                    tamp = inputTv.getText().toString();
                    inputTv.setText(tamp + ")");
                    checkBracket = false;

                }else {
                    tamp = inputTv.getText().toString();
                    inputTv.setText(tamp + "(");
                    checkBracket = true;
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();

                tamp = tamp.replace("×", "*");
                tamp = tamp.replace("%", "/100");
                tamp = tamp.replace("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, tamp, "javascript", 1, null ).toString();
                }catch (Exception e){
                    finalResult = "0";
                }
                outputTv.setText(finalResult);
            }
        });












    }
}