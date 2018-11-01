package hhird.harsh123.com.learnerapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class display_score extends AppCompatActivity {

    ListView listView;
    String[] listitem;
    public String getstring;
    private TextView tvsc;
    public ArrayList<String> listarray=new ArrayList<>();
    public ArrayAdapter<String> aadp;
    public DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    public String email,nameid;
    public String subj;
    long x,i,j;
    String y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);

        subj=getIntent().getStringExtra("sub");
        listView = (ListView)findViewById(R.id.leaderlist);
        aadp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listarray);
        listView.setAdapter(aadp);
        tvsc=(TextView)findViewById(R.id.textView654);

       /* email = "me@gmail,com";
        nameid=decodeUserEmail(email);
        getstring = "5";
        listarray.add(email+"       "+getstring);
        tvsc.setText(email);
        //  listarray.add(x,getstring);
        aadp.notifyDataSetChanged();
*/

      ValueEventListener v= db.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   for (x=0;x<=5;x++) {
                       i=dataSnapshot.child("Score").child(subj).child(String.valueOf(x)).getChildrenCount();
                        for (j=1;j<i;j++){
                            email = (String)dataSnapshot.child("Score").child(subj).child(String.valueOf(x)).child(String.valueOf(j)).getValue();
                            if (email!= null){
                                nameid = decodeUserEmail(email);
                                getstring = String.valueOf(x);
                                listarray.add(nameid+"\t"+getstring);
                                aadp.notifyDataSetChanged();
                            }
                        }
                   }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

    }

    static String decodeUserEmail(String userEmail) {
        return userEmail.replace(",", ".");
    }
}
