package hhird.harsh123.com.learnerapp;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email_login;
    private EditText passcode_login;
    private Button login;
    private TextView gotosignup;
    private Button gotoQuestions;
    private EditText phn_no;
    private FirebaseAuth firebaseAuth;
    public String no_phn;
    public String p2 ;
    private TextView disp;
    private FirebaseDatabase userDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference myuser = userDatabase.getReference();
    private DatabaseReference getmyuser = myuser.child("USER");
     private TextView disp2;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        p2=null;
        no_phn=null;
        if (firebaseAuth.getCurrentUser() != null) {
            //profileactivity
            finish();
            startActivity(new Intent(getApplicationContext(), profileactivity.class));
        }

        email_login = (EditText) findViewById(R.id.et_email_login);
        passcode_login = (EditText) findViewById(R.id.et_passcode_login);
        login = (Button) findViewById(R.id.bu_login);
        gotosignup = (TextView) findViewById(R.id.tv_login);
        // gotoQuestions = (Button)findViewById(R.id.BuQues);
       // phn_no = (EditText) findViewById(R.id.phno1);

        progressDialog = new ProgressDialog(this);

        login.setOnClickListener(this);
        gotosignup.setOnClickListener(this);

        //no_phn = phn_no.getText().toString().trim();
        disp = (TextView) findViewById(R.id.textView235);
         disp2=(TextView)findViewById(R.id.textView45678);
      //   disp2.setText(no_phn);
        getmyuser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    //String p= (String) dataSnapshot.child(no_phn).getValue(String.class);
                 //   no_phn = phn_no.getText().toString().trim();
                 //   p2 = (String) dataSnapshot2.child(no_phn).child("userprofile").getValue(String.class);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void onClick(View view) {

        if (view == login) {
            loginuser();


        }

        if (view == gotosignup) {
            finish();
            startActivity(new Intent(getApplicationContext(), signupactivity.class));
              //  no_phn = phn_no.getText().toString().trim();
        }
    }

    private void loginuser() {

        String email = email_login.getText().toString().trim();
        String passcode = passcode_login.getText().toString().trim();
      //  no_phn = phn_no.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "PLEASE ENTER EMAIL ID", Toast.LENGTH_LONG).show();
            return;
        }


        if (TextUtils.isEmpty((passcode))) {
            Toast.makeText(this, "PLEASE ENTER PASSCODE", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Loging In Please Wait.....");
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(email, passcode)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //disp.setText(p2);
                        if (task.isSuccessful()) {
                            //start profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(),profileactivity.class));
                         //   if (p2.contentEquals("STUDENT")) {
                               // startActivity(new Intent(getApplicationContext(), StudentAvtivity.class));
                           // }


                              //  if (p2.contentEquals("STUDENT")) {
                                 //   startActivity(new Intent(getApplicationContext(), sub_screen_for_teacher_uploads.class));
                              //  }
                            }
                            // else
                            // {
                            //    startActivity(new Intent(getApplicationContext(),profileactivity.class));
                            //  }
                        }



                });

    }

    public void buclick123(View view) {


       startActivity(new Intent(getApplicationContext(), teacheraskpassword.class));

        //disp.setText(p2);
        //disp2.setText(no_phn);
    }

    public void buclick456(View view) {
        startActivity(new Intent(getApplicationContext(),display_score.class));
    }
}

