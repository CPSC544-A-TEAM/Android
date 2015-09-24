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

        popButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (stack.size()==0){
                        Toast.makeText(getApplicationContext(), "Stack empty",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String input = inputText.getText().toString();
                    stack.pop();
                    printStack();
                }catch (Exception e){
                    Log.d("Stack error", e.toString());
                }
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    public void printStack(){
        Iterator iterator = stack.iterator();
        String implodeString="";
        while(iterator.hasNext()){
            Object element = iterator.next();

            implodeString += element + "  ";
        }
        messagesText.setText("Current Stack:" + implodeString + "\n" +  messagesText.getText());
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
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
