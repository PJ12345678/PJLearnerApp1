package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class test1 extends AppCompatActivity {

    private TextView T1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        T1 = (TextView)findViewById(R.id.TV1);
        Intent i1 = getIntent();
        String S1 = i1.getStringExtra("no_ofQues");
        T1.setText(S1);

    }
}
