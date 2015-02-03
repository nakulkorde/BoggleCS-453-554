package com.boggle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.content.Intent;
import android.app.Activity;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;
import java.io.*;


public class MainActivity extends ActionBarActivity {

    public static int roundCount = 0;
    public static int roundNumber = 0;
    public static int level = 0; // 1 for easy, 2 for hard
    public static ArrayList<String> wordlist = new ArrayList<String>();
    public static int mode; // 1 for single player, 2 for multiple player
    public static ArrayList<String> solution = new ArrayList<String>();
    public static char[][] boardrep; //instansiated after level were chosen = new char [3][3] or = new char [4][4]
    public static int state = 0;// 1-Menu1; 2-Menu2; 3-Menu3; 4-Play


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        State_Menu1();


        Button button_sp = (Button) findViewById(R.id.botton_sp);
        button_sp.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                State_Menu2();
                mode = 1;
            }
        });
        Button button_mp = (Button) findViewById(R.id.botton_mp);
        button_mp.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                State_Menu2();
                mode = 2;
            }
        });

        Button button_easy = (Button) findViewById(R.id.botton_easy);
        button_easy.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                State_Menu3();
                level = 1;
            }
        });
        Button button_hard = (Button) findViewById(R.id.botton_hard);
        button_hard.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                State_Menu3();
                level = 2;
            }
        });


        Button button_roundsubmit = (Button) findViewById(R.id.botton_roundsubmit);
        button_roundsubmit.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Spinner spinner_rounds = (Spinner) findViewById(R.id.spinner_rounds);
                String temp = String.valueOf(spinner_rounds.getSelectedItem());
                roundCount = Integer.parseInt(temp);
                State_Play();
            }
        });

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                switch(state) {
                    case 0:
                        State_Menu1(); break;
                    case 1:
                        State_Menu1(); break;
                    case 2:
                        State_Menu1(); break;
                    case 3:
                        State_Menu2(); break;
                    case 4:
                        State_Menu3(); break;
                    default:
                        State_Menu1(); break;
                }

            }
        });



    }

    public void State_Menu1()
    {
        state = 1;
        RelativeLayout Menu1 =  (RelativeLayout) findViewById(R.id.RL_Menu1);
        RelativeLayout Menu2 =  (RelativeLayout) findViewById(R.id.RL_Menu2);
        RelativeLayout Menu3 =  (RelativeLayout) findViewById(R.id.RL_Menu3);
        RelativeLayout Play =  (RelativeLayout) findViewById(R.id.RL_Play);
        Menu1.setVisibility(View.VISIBLE);
        Menu2.setVisibility(View.INVISIBLE);
        Menu3.setVisibility(View.INVISIBLE);
        Play.setVisibility(View.INVISIBLE);
        mode = 0;
        level = 0;
        roundCount = 0;
    }

    public void State_Menu2()
    {
        state = 2;
        RelativeLayout Menu1 =  (RelativeLayout) findViewById(R.id.RL_Menu1);
        RelativeLayout Menu2 =  (RelativeLayout) findViewById(R.id.RL_Menu2);
        RelativeLayout Menu3 =  (RelativeLayout) findViewById(R.id.RL_Menu3);
        RelativeLayout Play =  (RelativeLayout) findViewById(R.id.RL_Play);
        Menu1.setVisibility(View.INVISIBLE);
        Menu2.setVisibility(View.VISIBLE);
        Menu3.setVisibility(View.INVISIBLE);
        Play.setVisibility(View.INVISIBLE);
        level = 0;
        roundCount = 0;
    }

    public void State_Menu3()
    {
        state = 3;
        RelativeLayout Menu1 =  (RelativeLayout) findViewById(R.id.RL_Menu1);
        RelativeLayout Menu2 =  (RelativeLayout) findViewById(R.id.RL_Menu2);
        RelativeLayout Menu3 =  (RelativeLayout) findViewById(R.id.RL_Menu3);
        RelativeLayout Play =  (RelativeLayout) findViewById(R.id.RL_Play);
        Menu1.setVisibility(View.INVISIBLE);
        Menu2.setVisibility(View.INVISIBLE);
        Menu3.setVisibility(View.VISIBLE);
        Play.setVisibility(View.INVISIBLE);

        Spinner spinner_rounds = (Spinner) findViewById(R.id.spinner_rounds);
        String[] items = new String[]{"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        spinner_rounds.setAdapter(adapter);

        roundCount = 0;
    }

    public void  State_Play()
    {
        state = 4;/*
        RelativeLayout Menu1 =  (RelativeLayout) findViewById(R.id.RL_Menu1);
        RelativeLayout Menu2 =  (RelativeLayout) findViewById(R.id.RL_Menu2);
        RelativeLayout Menu3 =  (RelativeLayout) findViewById(R.id.RL_Menu3);
        RelativeLayout Play =  (RelativeLayout) findViewById(R.id.RL_Play);
        Menu1.setVisibility(View.INVISIBLE);
        Menu2.setVisibility(View.INVISIBLE);
        Menu3.setVisibility(View.INVISIBLE);
        Play.setVisibility(View.VISIBLE);*/
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(MainActivity.this, Game.class);
                startActivity(i);

                finish();
            }
        }, 0);
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
