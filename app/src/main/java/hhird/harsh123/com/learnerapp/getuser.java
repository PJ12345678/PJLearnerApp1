package hhird.harsh123.com.learnerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class getuser extends AppCompatActivity {



        private EditText fname;
        private EditText lname;
        private EditText mno;
        private Spinner  myspinner;
        private TextView md;
        public String id;

        DatabaseReference databaseUser;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_getuser);
            databaseUser= FirebaseDatabase.getInstance().getReference("USER");

            myspinner = (Spinner) findViewById(R.id.spinner_profile);
            fname = (EditText) findViewById(R.id.fname_signup);
            lname = (EditText) findViewById(R.id.lname_signup);
            mno=(EditText)findViewById(R.id.pmno);
            md=(TextView)findViewById(R.id.dism);
         ArrayAdapter<String> myadaptor = new ArrayAdapter<String>(getuser.this,
         android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.profile));
         myadaptor.setDropDownViewResource(android.R.layout.simple_list_item_1);
          myspinner.setAdapter(myadaptor);


            //Read from intent : -
            id = getIntent().getStringExtra("user_eid");

            md.setText(id);


        }

    public void submituser(View view) {



        String name = fname.getText().toString().trim();
        String namel = lname.getText().toString().trim();
        String mob_no= mno.getText().toString().trim();
        String uprofile = myspinner.getSelectedItem().toString().trim();
        String mailid=id;
        //String id =databaseUser.push().getKey();

        User user= new User(name,namel,mob_no,uprofile,mailid);


        databaseUser.child(mob_no).setValue(user);


    }
}
