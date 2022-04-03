package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_7,btn_8 , btn_9, btn_6, btn_5 , btn_4 , btn_3, btn_2 , btn_1 , btn_0, btn_delete,btn_equal,btn_C,btn_plusormines,btn_plus,btn_mines, btn_multiply,
            btn_percent, btn_divide;
    TextView calc_text,zapis;
    String znak,birinshisan,zapisText, ekinshisan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        initView();
        sandarMethods();
        deletePlusMinesMethods();
        mainFunctionMethods();
    }
    public void initView(){
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
        btn_delete = findViewById(R.id.btn_delete);
        btn_C = findViewById(R.id.btn_C);
        btn_plusormines = findViewById(R.id.btn_plusormines);
        btn_percent = findViewById(R.id.btn_percent);
        btn_plus = findViewById(R.id.btn_plus);
        btn_mines = findViewById(R.id.btn_mines);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_divide);
        btn_equal = findViewById(R.id.btn_equal);

        calc_text = findViewById(R.id.calc_text);
        zapis = findViewById(R.id.zapis);
    }
    public void sandarMethods(){
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
                    case R.id.btn_delete:
                        if(calc_text.length()>0) {
                            String deltxt = aldingiSan.substring(0, aldingiSan.length() - 1);
                            aldingiSan = deltxt;
                            basilganSan = "";
                        }
                        break;
                }
                if(!aldingiSan.equals("0")) lastresult = aldingiSan + basilganSan;
                else lastresult = basilganSan;
                calc_text.setText(lastresult);
            }

        };


        btn_delete.setOnClickListener(buttonSandar);
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
    }
    public void deletePlusMinesMethods(){
        View.OnClickListener buttonremovePlusMines = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.btn_C:
                        calc_text.setText("0");
                        zapis.setText("0");
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
    public void mainFunctionMethods(){
        View.OnClickListener btnFunction = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                birinshisan = calc_text.getText().toString();
                switch (view.getId()){
                    case R.id.btn_plus:
                        znak = "+";
                        break;
                    case R.id.btn_mines:
                        znak = "-";
                        break;

                    case R.id.btn_divide:
                        znak = "/";
                        break;
                    case R.id.btn_multiply:
                        znak = "*";
                        break;
                }
                zapisText = birinshisan + znak;
                zapis.setText(zapisText);
                calc_text.setText("0");
            }
        };
        btn_plus.setOnClickListener(btnFunction);
        btn_mines.setOnClickListener(btnFunction);
        btn_multiply.setOnClickListener(btnFunction);
        btn_divide.setOnClickListener(btnFunction);



        btn_equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ekinshisan = calc_text.getText().toString();
                int san1 = Integer.parseInt(birinshisan);
                int san2 = Integer.parseInt(ekinshisan);
                int result=0;
                if(znak.equals("+")){
                    result = san1+san2;
                }
                else if(znak.equals("-")){
                    result = san1-san2;
                }else if(znak.equals("*")){
                    result = san1*san2;
                }else if(znak.equals("/")){
                    result = san1/san2;
                }
                zapisText = birinshisan + znak + ekinshisan+ " = "+result;
                zapis.setText(zapisText);
                calc_text.setText(""+result);
            }
        });
    }
}