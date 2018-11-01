package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class quesinput extends AppCompatActivity {


    private Button tst;
    private Button prac;
    public String subject1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quesinput);

        tst=(Button)findViewById(R.id.butst);
        prac=(Button)findViewById(R.id.buprac);

         subject1 = getIntent().getStringExtra("sub");




    }

    public void butstclick(View view) {
       // startActivity(new Intent(this,test_title.class));
        Intent intent = new Intent(this, test_title.class);
        intent.putExtra("sub",subject1);
        intent.putExtra("title","test");
        startActivity(intent);

    }

    public void bupracclick(View view) {


        //startActivity(new Intent(this,pract_title.class));

        Intent intent = new Intent(this, pract_title.class);
        intent.putExtra("sub",subject1);
        intent.putExtra("title","practice");
        startActivity(intent);

    }
}
