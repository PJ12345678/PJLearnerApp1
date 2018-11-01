package hhird.harsh123.com.learnerapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupactivity extends AppCompatActivity implements View.OnClickListener {


    private EditText email_signup;
    private EditText passcode_signup;
    private Button register;
    private TextView gotologin;
    private EditText fname;
    private EditText lname;
    private EditText mno;
    private Spinner myspinner;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    DatabaseReference databaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        databaseUser= FirebaseDatabase.getInstance().getReference("USER");




        firebaseAuth = FirebaseAuth.getInstance();



        progressDialog = new ProgressDialog(this);

        email_signup = (EditText) findViewById(R.id.su_email);
        passcode_signup = (EditText) findViewById(R.id.su_passcode);
        register = (Button) findViewById(R.id.ru_button);
        gotologin = (TextView) findViewById(R.id.tv_movetologiin);
       fname=(EditText)findViewById(R.id.fname_signup);
       lname=(EditText)findViewById(R.id.lname_signup);
       mno=(EditText)findViewById(R.id.pmno);
        myspinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myadaptor = new ArrayAdapter<String>(signupactivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.profile));
        myadaptor.setDropDownViewResource(android.R.layout.simple_list_item_1);
        myspinner.setAdapter(myadaptor);


        register.setOnClickListener(this);
        gotologin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == register) {
            registeruser();
        }

        if (view == gotologin) {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

    private void registeruser() {


        //String name = fname.getText().toString().trim();
        //String namel = lname.getText().toString().trim();
       // String birth = dob.getText().toString().trim();
       // String uprofile = myspinner.getSelectedItem().toString().trim();
        final String email = email_signup.getText().toString().trim();
        String passcode = passcode_signup.getText().toString().trim();
      //  String con_passcode = cpasscode.getText().toString().trim();

        //Intent intent = new Intent(this, getuser.class);
       // intent.putExtra("user_eid",email);


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "PLEASE ENTER AN EMAIL ID", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(passcode)) {
            Toast.makeText(this, "PLEASE ENTER A PASSCODE", Toast.LENGTH_SHORT).show();
            return;
        }

        final String name = fname.getText().toString().trim();
        final String namel = lname.getText().toString().trim();
        final String mob_no= mno.getText().toString().trim();
        final String uprofile = myspinner.getSelectedItem().toString().trim();
        final  String mailid=email_signup.getText().toString().trim();



        progressDialog.setMessage("REGISTERING USER.....");

        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, passcode).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(signupactivity.this, "REGISTERED USER SUCCESFULLY", Toast.LENGTH_SHORT).show();





                    User user= new User(name,namel,mob_no,uprofile,mailid);
                    databaseUser.child(mob_no).setValue(user);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }
            }
        });
    }

    public void ruclick(View view) {
    }
}


