package hhird.harsh123.com.learnerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

public class videoactivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<ytvid>ytvids=new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoactivity);
        recyclerView=(RecyclerView)findViewById(R.id.recv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ytvids.add(new ytvid("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eWEF1Zrmdow\" frameborder=\"0\" allowfullscreen></iframe>"));

         vidadap vidadap1=new vidadap(ytvids);
         recyclerView.setAdapter(vidadap1);
    }
}
