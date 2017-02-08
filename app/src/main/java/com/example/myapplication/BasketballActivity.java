package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BasketballActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button mA3pButton;
    private Button mA2pButton;
    private Button mA1pButton;
    private Button mB3pButton;
    private Button mB2pButton;
    private Button mB1pButton;
    private Button mResetButton;
    private TextView mAscoreTextView;
    private TextView mBscoreTextView;

    private int Ascore = 0;
    private int Bscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_basketball);

        mA3pButton = (Button) findViewById(R.id.teamA_3p);
        mA2pButton = (Button) findViewById(R.id.teamA_2p);
        mA1pButton = (Button) findViewById(R.id.teamA_1p);
        mB3pButton = (Button) findViewById(R.id.teamB_3p);
        mB2pButton = (Button) findViewById(R.id.teamB_2p);
        mB1pButton = (Button) findViewById(R.id.teamB_1p);
        mResetButton = (Button) findViewById(R.id.reset_text);
        mAscoreTextView = (TextView) findViewById(R.id.teamA_score);
        mBscoreTextView = (TextView) findViewById(R.id.teamB_score);


        mA3pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ascore = Ascore + 3;
                mAscoreTextView.setText("" + Ascore);
            }
        });
        mA2pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ascore = Ascore + 2;
                mAscoreTextView.setText("" + Ascore);
            }
        });
        mA1pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ascore = Ascore + 1;
                mAscoreTextView.setText("" + Ascore);
            }
        });
        mB3pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bscore = Bscore + 3;
                mBscoreTextView.setText("" + Bscore);
            }
        });
        mB2pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bscore = Bscore + 2;
                mBscoreTextView.setText("" + Bscore);
            }
        });
        mB1pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bscore = Bscore + 1;
                mBscoreTextView.setText("" + Bscore);
            }
        });
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ascore = 0;
                mAscoreTextView.setText("" + Ascore);
                Bscore = 0;
                mBscoreTextView.setText("" + Bscore);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                return true;
            case R.id.action_setting2:
                return true;
            case R.id.action_setting3:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
