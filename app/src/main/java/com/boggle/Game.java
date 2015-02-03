package com.boggle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.content.Intent;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;
import java.io.*;


public class Game extends Activity {
    public  ArrayList<String> wordlist = new ArrayList<String>();
    public  char[][] boardMatrix;
    public  ArrayList<String> solution = new ArrayList<String>();
    public  ArrayList<String> answers = new ArrayList<String>();
    public  String currentAnswer = null;
    public String[] board = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final Button boggle = (Button) findViewById(R.id.Boggle);
        final Button b1 = (Button)findViewById(R.id.button1);
        final Button b2 = (Button)findViewById(R.id.button2);
        final Button b3 = (Button)findViewById(R.id.button3);
        final Button b4 = (Button)findViewById(R.id.button4);
        final Button b5 = (Button)findViewById(R.id.button5);
        final Button b6 = (Button)findViewById(R.id.button6);
        final Button b7 = (Button)findViewById(R.id.button7);
        final Button b8 = (Button)findViewById(R.id.button8);
        final Button b9 = (Button)findViewById(R.id.button9);
        final Button b10 = (Button)findViewById(R.id.button10);
        final Button b11 = (Button)findViewById(R.id.button11);
        final Button b12 = (Button)findViewById(R.id.button12);
        final Button b13 = (Button)findViewById(R.id.button13);
        final Button b14 = (Button)findViewById(R.id.button14);
        final Button b15 = (Button)findViewById(R.id.button15);
        final Button b16 = (Button)findViewById(R.id.button16);

        boggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Boggling!", Toast.LENGTH_SHORT).show();
                TextView test = (TextView) findViewById(R.id.test);
                // test.setText(board);
                test.setMovementMethod(new ScrollingMovementMethod());
                Boggle();
                b1.setText(board[0]);
                b2.setText(board[1]);
                b3.setText(board[2]);
                b4.setText(board[3]);
                b5.setText(board[4]);
                b6.setText(board[5]);
                b7.setText(board[6]);
                b8.setText(board[7]);
                b9.setText(board[8]);
                b10.setText(board[9]);
                b11.setText(board[10]);
                b12.setText(board[11]);
                b13.setText(board[13]);
                b14.setText(board[14]);
                b15.setText(board[15]);
                b16.setText(board[16]);


            }
        });
    }

    //needs implementation
    public void findSolu()
    {
        return;
    }


    private String readTxt() {

        try {

            InputStream in = getResources().openRawResource(getResources().getIdentifier("words", "raw", getPackageName()));

            if (in != null) {

                InputStreamReader tmp = new InputStreamReader(in);

                BufferedReader reader = new BufferedReader(tmp);

                String str;

                StringBuilder buf = new StringBuilder();

                while ((str = reader.readLine()) != null) {

                    buf.append(str + " ");

                }

                in.close();

                return buf.toString();

            }

        } catch (java.io.FileNotFoundException e) {

// that's OK, we probably haven't created it yet

        } catch (Throwable t) {

            Toast

                    .makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG)

                    .show();

        }
        String str1 ="not working!";
        return str1;
    }
    private void Boggle(){

        int index;
        String temp;
        Random random = new Random();
        for (int i = board.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = board[index];
            board[index] = board[i];
            board[i] = temp;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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
