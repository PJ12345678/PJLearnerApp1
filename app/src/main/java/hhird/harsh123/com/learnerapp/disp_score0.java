package hhird.harsh123.com.learnerapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class disp_score0 extends AppCompatActivity {

    private TextView scor;
    private String s1;
    public DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    public DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();

    private String nameid;
    private FirebaseAuth ref;
    private String sub;
   public   long y;
    long z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_score0);
        scor = (TextView)findViewById(R.id.scoredisplay);
        ref=FirebaseAuth.getInstance();
        FirebaseUser id=ref.getCurrentUser();
        nameid=(String)id.getEmail();
        s1 = getIntent().getStringExtra("scr");
        sub = getIntent().getStringExtra("subject");
        scor.setText("Your Score is :   " +s1 +"/5");

        //db.child("Score").child(sub).child(s1).push().setValue(encodeUserEmail(nameid));
        //z=db.child("Score").child(sub).child(s1).push().getKey();

       ValueEventListener v= db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot5 : dataSnapshot.getChildren()) {
                    y = dataSnapshot.child("Score").child(sub).child(s1).getChildrenCount();
                    z = dataSnapshot.child("Score").child(sub).child(encodeUserEmail(nameid)).getChildrenCount();
                    //scor.setText("Your Score is :   " + y + "/5");
                    db.child("Score").child(sub).child(encodeUserEmail(nameid)).child(String.valueOf(z)).setValue(s1);

                    //Date currenttime = Calendar.getInstance().getTime();
                    //db.child(sub).child(encodeUserEmail(nameid)).child("score").setValue(s1);
                    //db.child(sub).child(encodeUserEmail(nameid)).child("email").setValue(encodeUserEmail(nameid));
                    db.child("Score").child(sub).child(s1).child(String.valueOf(y)).setValue(encodeUserEmail(nameid));
                    db.removeEventListener(this);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
       // db.removeEventListener(v);
        //y++;
        //z++;
         // db.child("Score").child(sub).child(encodeUserEmail(nameid)).child(String.valueOf(z)).setValue(s1);

        //Date currenttime = Calendar.getInstance().getTime();
        //db.child(sub).child(encodeUserEmail(nameid)).child("score").setValue(s1);
        //db.child(sub).child(encodeUserEmail(nameid)).child("email").setValue(encodeUserEmail(nameid));
        //db.child("Score").child(sub).child(s1).child(String.valueOf(y)).setValue(encodeUserEmail(nameid)+"$"+String.valueOf(z));



    }



    public static String encodeUserEmail(String userEmail) {
        return userEmail.replace(".", ",");
    }
}

