package edu.fullerton.csu.cpsc.mystack;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;

public class MainActivity extends ActionBarActivity {
    private MyStack stack =new MyStack();
    private EditText messagesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText inputText = (EditText) findViewById(R.id.editText);
        Button pushButton =(Button) findViewById(R.id.pushButton);
        Button popButton =(Button) findViewById(R.id.popButton);
        Button exitButton = (Button) findViewById(R.id.exitButton);
        messagesText = (EditText) findViewById(R.id.messages);
        inputText.clearFocus();
        pushButton.requestFocus();


        pushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String input = inputText.getText().toString();
                    if (input.length() ==0){
                        Toast.makeText(getApplicationContext(), "Please enter an integer",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (Integer.parseInt(input) >9 || Integer.parseInt(input) <0){
                        Toast.makeText(getApplicationContext(), "Please enter a valid integer (0-9)",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (stack.size()>=3){
                        Toast.makeText(getApplicationContext(), "Stack full, pop it off first",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    stack.push(input);
                    printStack();
                }catch (Exception e){
                    Log.d("Stack error", e.toString());
                }
            }
        });





}
