package hhird.harsh123.com.learnerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ScrollView;

public class learningpage extends AppCompatActivity {

    private ScrollView scrollView = (ScrollView)findViewById(R.id.scrollView4);
    private EditText theory = (EditText)findViewById(R.id.editText);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learningpage);
        theory.setText();

    }
}
