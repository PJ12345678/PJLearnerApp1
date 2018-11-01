package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class pract_title extends AppCompatActivity {

    public String nooofquestions;
    private EditText no_of_ques;
    private Spinner prac_spin;
    public String subject;
    private Button subbu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pract_title);


        //Read from intent : -
        subject = getIntent().getStringExtra("sub");
        subbu=(Button)findViewById(R.id.button_sub);
        no_of_ques=(EditText)findViewById(R.id.no_of_quesprac);


        ArrayAdapter<String> myadaptor2 = new ArrayAdapter<String>(pract_title.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pract));
        myadaptor2.setDropDownViewResource(android.R.layout.simple_list_item_1);
        prac_spin.setAdapter(myadaptor2);

    }

    public void ssub_clicked(View view) {
        nooofquestions = no_of_ques.getText().toString().trim();
        String practti = prac_spin.getSelectedItem().toString().trim();
        Intent intent = new Intent(this, Teacherquestions.class);
        intent.putExtra("sub",subject);
        intent.putExtra("no_ofQues",nooofquestions);
        startActivity(intent);




    }
}
