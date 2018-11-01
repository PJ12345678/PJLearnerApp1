package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class test_title extends AppCompatActivity {


    public String noofques;
    public EditText no_of_questions;
    public String subject3;
    private Spinner testspin;
    private Button testbu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_title);

        subject3 = getIntent().getStringExtra("sub");
        no_of_questions=(EditText)findViewById(R.id.no_of_ques);
        testbu=(Button)findViewById(R.id.button234);


     /*  ArrayAdapter<String> myadaptor3= new ArrayAdapter<String>(test_title.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.testt));
        myadaptor3.setDropDownViewResource(android.R.layout.simple_list_item_1);
        testspin.setAdapter(myadaptor3);*/

    }

    public void onclicksub(View view) {
        noofques=no_of_questions.getText().toString().trim();

        //String practti = testspin.getSelectedItem().toString().trim();
        Intent intent = new Intent(this, Teacherquestions.class);
        intent.putExtra("sub",subject3);
        intent.putExtra("no_ofQues",noofques);
        startActivity(intent);


        }
}
