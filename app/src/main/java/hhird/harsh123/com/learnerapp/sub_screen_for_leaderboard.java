package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sub_screen_for_leaderboard extends AppCompatActivity {

    private Button be;
    private Button bm;
    private Button ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_screen_for_leaderboard);
        be = (Button) findViewById(R.id.eng_Button2);
        bm = (Button) findViewById(R.id.math_button2);
        ba = (Button) findViewById(R.id.apti_Button2);
    }

    public void addQuestionEng(View view) {
        Intent intent = new Intent(this, display_score.class);
        intent.putExtra("sub","English");
        startActivity(intent);
    }

    public void addQuestionMath(View view) {
        Intent intent = new Intent(this, display_score.class);
        intent.putExtra("sub","Mathematics");

        startActivity(intent);
    }

    public void addQuestionApti(View view) {

        Intent intent = new Intent(this, display_score.class);
        intent.putExtra("sub","Aptitude");
        startActivity(intent);

    }
}
