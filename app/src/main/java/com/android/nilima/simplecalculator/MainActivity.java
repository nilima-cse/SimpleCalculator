package com.android.nilima.simplecalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText firstValueInput,secondValueInput,operatorInput;
    TextView resultView;
    Button showResultBtn;
    Double num1,num2,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstValueInput=(EditText)findViewById(R.id.first_value);
        secondValueInput=(EditText)findViewById(R.id.second_value);
        operatorInput=(EditText)findViewById(R.id.operator);
        resultView=(TextView)findViewById(R.id.result_view);
        showResultBtn=(Button)findViewById(R.id.ok_button);

        showResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String operator=operatorInput.getText().toString();
                num1=Double.parseDouble(firstValueInput.getText().toString());
                num2=Double.parseDouble(secondValueInput.getText().toString());

                if(TextUtils.isEmpty(operator)){
                    operatorInput.setError("Please enter valid operator");
                    operatorInput.requestFocus();
                    return;
                }
                else if (operator.equals("+")||operator.equals("-")||operator.equals("x")||operator.equals("/")||operator.equals("*")){
                     if (operator.equals("+")) {
                        result=num1+num2;
                        resultView.setText(Double.toString(result));
                    }
                    else if (operator.equals("-")){
                        result=num1-num2;
                        resultView.setText(Double.toString(result));
                    }
                    else if (operator.equals("x")||operator.equals("*")){
                        result=num1*num2;
                        resultView.setText(Double.toString(result));
                    }
                    else if (operator.equals("/")){
                        result=num1/num2;
                        resultView.setText(Double.toString(result));
                    }

                }else {
                    operatorInput.setError("Please enter valid operator");
                    operatorInput.requestFocus();
                    return;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
