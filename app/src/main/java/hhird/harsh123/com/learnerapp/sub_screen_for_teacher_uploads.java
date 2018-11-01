package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class sub_screen_for_teacher_uploads extends AppCompatActivity {

    private Button be;
    private Button bm;
    private Button ba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_screen_for_teacher_uploads);

        be = (Button) findViewById(R.id.Eng_Button);
        bm = (Button) findViewById(R.id.Math_button);
        ba = (Button) findViewById(R.id.Apti_Button);
    }


    public void addQuestionEng(View view) {
        Intent intent = new Intent(this, test_title.class);
        intent.putExtra("sub","English");
        startActivity(intent);
    }

    public void addQuestionMath(View view) {
        Intent intent = new Intent(this, test_title.class);
        intent.putExtra("sub","Mathematics");

        startActivity(intent);
    }

    public void addQuestionApti(View view) {

        Intent intent = new Intent(this, test_title.class);
        intent.putExtra("sub","Aptitude");
        startActivity(intent);

    }
}

