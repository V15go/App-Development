package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView input_text, output_text;

    private String input, output, newoutput;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,
    buttonadd,buttonsub,buttonmul,buttondiv,buttonequal,buttonprecent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_text = findViewById(R.id.inpuut);
        output_text = findViewById(R.id.output_text);

        button0 = findViewById(R.id.zero);
        button1 = findViewById(R.id.one);
        button2 = findViewById(R.id.two);
        button3 = findViewById(R.id.three);
        button4 = findViewById(R.id.four);
        button5 = findViewById(R.id.five);
        button6 = findViewById(R.id.six);
        button7 = findViewById(R.id.seven);
        button8 = findViewById(R.id.eight);
        button9 = findViewById(R.id.nine);
        buttonadd = findViewById(R.id.addition);
        buttonsub  = findViewById(R.id.subraction);
        buttonmul = findViewById(R.id.multipy);
        buttondiv = findViewById(R.id.division);
        buttonprecent = findViewById(R.id.precentage);
        buttonequal  = findViewById(R.id.equal);


    }

    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC":
                input = null;
                output = null;
                input_text.setText("");
                output_text.setText("");
                break;

            case "%":
                input+="%";
                double d = Double.parseDouble(input_text.getText().toString()) / 100;
                output_text.setText(String.valueOf(d));
                break;
            case "*":
                input+="*";
                solve();
                break;
            case "=":
                solve();
                break;
            default:
                if(input == null){
                    input= "";

                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    solve();
                }
                input+=data;




        }
        output_text.setText(input);
    }
    private void solve(){
if(input.split("\\+").length == 2){
    String[] num = input.split("\\+");
    try{
        double d = Double.parseDouble(num[0])+Double.parseDouble(num[1]);
        output= String.valueOf(d);
        output_text.setText(output);
        input = d+" ";
    }
    catch (Exception e){
        output_text.setError(e.getMessage().toString());
    }
}
        if(input.split("\\-").length == 2){
            String[] num = input.split("\\-");
            try{
                double d = Double.parseDouble(num[0])-Double.parseDouble(num[1]);
                output= String.valueOf(d);
                output_text.setText(output);
                input = d+" ";
            }
            catch (Exception e){
                output_text.setError(e.getMessage().toString());
            }
        }

        if(input.split("\\*").length == 2){
            String[] num = input.split("\\*");
            try{
                double d = Double.parseDouble(num[0])*Double.parseDouble(num[1]);
                output= String.valueOf(d);
                output_text.setText(output);
                input = d+" ";
            }
            catch (Exception e){
                output_text.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\/").length == 2){
            String[] num = input.split("\\/");
            try{
                double d = Double.parseDouble(num[0])/Double.parseDouble(num[1]);
                output= String.valueOf(d);
                output_text.setText(output);
                input = d+" ";
            }
            catch (Exception e){
                output_text.setError(e.getMessage().toString());
            }
        }
    }

}