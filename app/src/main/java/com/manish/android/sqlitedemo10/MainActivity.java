package com.manish.android.sqlitedemo10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
MyDbHandler myDbHandler;
    EditText input;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDbHandler = new MyDbHandler(this,null,null,1);
        input = (EditText) findViewById(R.id.input);
        output= (TextView) findViewById(R.id.output);
    }
    public void addButtonClick(View view){
        Notes note = new Notes(input.getText().toString());
        myDbHandler.addNote(note);
        printDb();
    }
    public void deleteButtonClick(View view){
        myDbHandler.deleteNote(input.getText().toString());
        printDb();
    }

    public void printDb(){
       String dbString = myDbHandler.dbToString();
        output.setText(dbString);
        Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
        input.setText("");
    }
}
