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



        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                if (tamp.length() != 0) {
                    inputTv.setText("");
                    outputTv.setText("");
                }
            }
        });
        btnBack = findViewById(R.id.btnBack);
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










        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "0");
            }
        });
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "1");
            }
        });
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "2");
            }
        });
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "3");
            }
        });
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "4");
            }
        });
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "5");
            }
        });
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "6");
            }
        });
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "7");
            }
        });
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "8");
            }
        });
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "9");
            }
        });
        btnDot = findViewById(R.id.btnDot);
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + ".");
            }
        });
        btnPercent = findViewById(R.id.btnPercent);
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "%");
            }
        });









        btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "+");
            }
        });
        btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "-");
            }
        });
        btnDivision = findViewById(R.id.btnDivision);
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "÷");
            }
        });
        btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamp = inputTv.getText().toString();
                inputTv.setText(tamp + "×");
            }
        });










        btnBracket = findViewById(R.id.btnBracket);
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
        btnEqual = findViewById(R.id.btnEqual);
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