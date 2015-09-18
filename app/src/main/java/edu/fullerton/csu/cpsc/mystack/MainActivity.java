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




    public void printStack(){

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
