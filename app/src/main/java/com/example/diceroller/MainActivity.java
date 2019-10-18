package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText enternumber;
    TextView result, lbnumber,corect;
    Button button,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            ;}
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

    public void generate() {

        Random rand = new Random();
        int number = rand.nextInt(6) + 1;
        TextView lbnumber = (TextView) findViewById(R.id.lbnumber);
        String mystring = String.valueOf(number);
        lbnumber.setText(mystring);
        this.enternumber = (EditText) findViewById(R.id.enternumber);
        int input = 0;
        try {
            input = Integer.parseInt(enternumber.getText().toString());

        } catch (NumberFormatException nfe) {

        }
        input = Integer.parseInt(enternumber.getText().toString());

        this.lbnumber.setText(String.valueOf(number));
        if (number == input) {

            this.result.setText("you are right");
            Log.d("yes", "you are right" + number);
            setContentView(R.layout.activity_main);

            TextView corect = (TextView) findViewById(R.id.corect);
            String mystring2 = String.valueOf(score);
            corect.setText(mystring2);
            score ++;
            corect.setText("Score:"+score);


        } else {

            this.result.setText("you are wrong");
            Log.d("no", "you are wrong" + number);

            TextView corect = (TextView) findViewById(R.id.corect);
            String mystring2 = String.valueOf(score);
            corect.setText(mystring2);
            score =0;
            corect.setText("Score:"+score);
        }


    }

    private void result() {
this.button=(Button) findViewById(R.id.button);
this.lbnumber=(TextView) findViewById(R.id.lbnumber);
this.result=(TextView)findViewById(R.id.result);
this.enternumber=(EditText)findViewById(R.id.enternumber);
this.corect=(TextView)findViewById(R.id.corect);

        exit=(Button)findViewById(R.id.exit);

        this.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        generate();

     }
});
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }

private int score=0;



    }

