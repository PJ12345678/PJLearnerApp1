package hhird.harsh123.com.learnerapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class StudentAvtivity extends AppCompatActivity  {

       private TextView qued;
       private Button prev;
       private  Button next;
       private Button sub;
       public RadioGroup rdgr;
       public RadioButton selected;
       private RadioButton opa;
       private RadioButton opb;
       private  RadioButton opc;
       private RadioButton opd;
       public FirebaseAuth fbauth;
       private FirebaseDatabase queDatabase=FirebaseDatabase.getInstance();
       public DatabaseReference myque=queDatabase.getReference();
       public DatabaseReference myqueEn=myque.child("English");
       public DatabaseReference myqueMa=myque.child("Mathematics");
       public DatabaseReference myqueAp=myque.child("Aptitude");
       public String subj1;
       public String user;
       public String title_final;
       public String qno_final;
       public String qno;
       public String aa;
       public int qn=1;
       public String checkedanswer;
       public String anw;
       public int score=0;
       private TextView dispscore;
       public int x;
      private TextView txt_cd;
      private Button bu_cd;
     private CountDownTimer CdTimer;
     private long timeleftinmil=300000; //5 min
     private boolean timerunning;
     public String sscore;
     public double maxno,minno,rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_avtivity);

        maxno=9;
        minno=1;
        subj1 = getIntent().getStringExtra("sub");
        qued=(TextView)findViewById(R.id.dque);
        sub=(Button)findViewById(R.id.bu_sub);
        opa=(RadioButton)findViewById(R.id.dopa);
        opb=(RadioButton)findViewById(R.id.dopb);
        opc=(RadioButton)findViewById(R.id.dopc);
        opd=(RadioButton)findViewById(R.id.dopd);
        rdgr=(RadioGroup)findViewById(R.id.radiogrp);
        dispscore=(TextView)findViewById(R.id.scoreview);
        rand = Math.floor(Math.random()*(maxno-minno)+1);
        x=(int)Math.round(rand);
        txt_cd=(TextView)findViewById(R.id.cdtxt);
        quefunc(x);
        updattimer();
        startstop();
       // FirebaseUser user1=fbauth.getCurrentUser();
      // user=user1.getEmail();
      //  dispscore.setText(user);

       }



    public void check(StudentAvtivity view) {
            int radioid = rdgr.getCheckedRadioButtonId();
            selected = findViewById(radioid);
            checkedanswer = selected.getText().toString();
            Toast.makeText(this, "SELECTED OPTION IS  " + selected.getText(), Toast.LENGTH_SHORT).show();
            if (anw.contentEquals(checkedanswer)) {
                score++;
                sscore=String.valueOf(score);
            }

        if(qn==5) {


                Intent intent = new Intent(this,disp_score0.class);
                intent.putExtra("scr",sscore);
                intent.putExtra("subject",subj1);
            startActivity(intent);
        }
    }


    public void quefunc(final int qint){

           qno=String.valueOf(qint);
        myque.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())

                {
                    String data=(String)dataSnapshot1.getKey();
                    String q=(String)dataSnapshot.child(subj1).child(qno).child("question").getValue(String.class);
                    String a=(String)dataSnapshot.child(subj1).child(qno).child("opta").getValue(String.class);
                    String b=(String)dataSnapshot.child(subj1).child(qno).child("optb").getValue(String.class);
                    String c=(String)dataSnapshot.child(subj1).child(qno).child("optc").getValue(String.class);
                    String d=(String)dataSnapshot.child(subj1).child(qno).child("optd").getValue(String.class);
                    anw=(String)dataSnapshot.child(subj1).child(qno).child("ans").getValue(String.class);
                    qued.setText(q);
                    opa.setText(a);
                    opb.setText(b);
                    opc.setText(c);
                    opd.setText(d);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


    public void bunxtclick(View view) {
        if(rdgr.getCheckedRadioButtonId()==-1) {
            Toast.makeText(StudentAvtivity.this,"SELECT AN OPTION",Toast.LENGTH_SHORT).show();
        }
        else {
            check(this);

            qn++;
            rand = Math.floor(Math.random()*(maxno-minno)+1);
            x=(int)Math.round(rand);
            quefunc(x);
        }

        selected.setChecked(false);
    }



    private void startstop() {
        CdTimer=new CountDownTimer(timeleftinmil,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinmil=millisUntilFinished;
                updattimer();
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(),sub_screen_for_teacher_uploads.class));

            }
        }.start();
        timerunning=true;
    }

    private void updattimer() {

        int min=(int)timeleftinmil  /  60000;
        int sec=(int)timeleftinmil  %  60000 / 1000;

        String timelfttxt;
        timelfttxt=" "+min;
        timelfttxt +=":";
        if(sec<10) timelfttxt +="0";
        timelfttxt+=sec;

        txt_cd.setText(timelfttxt);


    }

}