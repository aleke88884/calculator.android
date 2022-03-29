package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_7,btn_8 , btn_9, btn_6, btn_5 , btn_4 , btn_3, btn_2 , btn_1 , btn_0;
    TextView calc_text;
    Button btn_C,btn_plusormines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson4);
        btn_8 = findViewById(R.id.btn_8);
        btn_6 = findViewById(R.id.btn_6);
        btn_5 = findViewById(R.id.btn_5);
        btn_4 = findViewById(R.id.btn_4);
        btn_2 = findViewById(R.id.btn_2);
        btn_9 = findViewById(R.id.btn_9);
        btn_3 = findViewById(R.id.btn_3);
        btn_1 = findViewById(R.id.btn_1);
        btn_0 = findViewById(R.id.btn_0);
        btn_7 = findViewById(R.id.btn_7);

        btn_C = findViewById(R.id.btn_C);
        btn_plusormines = findViewById(R.id.btn_plusormines);

        calc_text = findViewById(R.id.calc_text);
        View.OnClickListener buttonSandar = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String aldingiSan = calc_text.getText().toString();
                String basilganSan = "";
                String lastresult = "";

                switch(view.getId()){
                    case R.id.btn_0:
                        basilganSan="0";
                        break;
                    case R.id.btn_1:
                        basilganSan="1";
                        break;
                    case R.id.btn_2:
                        basilganSan="2";
                        break;
                    case R.id.btn_3:
                        basilganSan="3";
                        break;
                    case R.id.btn_4:
                        basilganSan="4";
                        break;
                    case R.id.btn_5:
                        basilganSan="5";
                        break;
                    case R.id.btn_6:
                        basilganSan="6";
                        break;
                    case R.id.btn_7:
                        basilganSan="7";
                        break;
                    case R.id.btn_8:
                        basilganSan="8";
                        break;
                    case R.id.btn_9:
                        basilganSan="9";
                        break;


                }
                if(!aldingiSan.equals("0")) lastresult = aldingiSan + basilganSan;
                else lastresult = basilganSan;
                calc_text.setText(lastresult);
            }

        };
        btn_8.setOnClickListener(buttonSandar);
        btn_6.setOnClickListener(buttonSandar);
        btn_5.setOnClickListener(buttonSandar);
        btn_4.setOnClickListener(buttonSandar);
        btn_2.setOnClickListener(buttonSandar);
        btn_9.setOnClickListener(buttonSandar);
        btn_3.setOnClickListener(buttonSandar);
        btn_1.setOnClickListener(buttonSandar);
        btn_0.setOnClickListener(buttonSandar);
        btn_7.setOnClickListener(buttonSandar);



        View.OnClickListener buttonremovePlusMines = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.btn_C:
                        calc_text.setText("0");
                        break;
                    case R.id.btn_plusormines:
                        String sanText = calc_text.getText().toString();
                        int san = Integer.parseInt(sanText);
                        if(san > 0) calc_text.setText("-"+sanText);
                        else{
                            san = san * (-1);
                            calc_text.setText(""+san);
                        }

                        break;
                }
            }

        };
        btn_C.setOnClickListener(buttonremovePlusMines);
        btn_plusormines.setOnClickListener(buttonremovePlusMines);
    }
}