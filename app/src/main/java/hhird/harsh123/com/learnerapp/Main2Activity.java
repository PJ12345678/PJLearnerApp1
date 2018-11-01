package hhird.harsh123.com.learnerapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public static final float MAX =7,MIN =1f;
    public static final int NBQUALITIES =3;
    private RadarChart chart;
    public DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    public Button tog;
    private FirebaseAuth ref = FirebaseAuth.getInstance();

    FirebaseUser id = ref.getCurrentUser();
    String nameid=(String)id.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tog=(Button)findViewById(R.id.buttog);
        chart=findViewById(R.id.scchart);
        chart.setBackgroundColor(Color.rgb(60,65,82));
        chart.getDescription().setEnabled(false);
        chart.setWebLineWidth(1f);
        chart.setWebColor(Color.WHITE);
        chart.setWebLineWidth(1F);
        chart.setWebColorInner(Color.WHITE);
        chart.setWebAlpha(100);

        setData();

        chart.animateXY(1400,1400, Easing.EasingOption.EaseInOutQuad,Easing.EasingOption.EaseInOutQuad);
        XAxis xAxis=chart.getXAxis();
        xAxis.setTextSize(9f);
        xAxis.setYOffset(0);
        xAxis.setXOffset(0);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] qualities=new String[]{"Last","Three","Test Score"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return qualities[(int)value%qualities.length];
            }
        });

        xAxis.setTextColor(Color.WHITE);


        YAxis yAxis=chart.getYAxis();
        yAxis.setLabelCount(NBQUALITIES,false);
        yAxis.setTextSize(10f);
        yAxis.setAxisMaximum(MIN);
        yAxis.setAxisMaximum(MAX);
        yAxis.setDrawLabels(false);


        Legend l=chart.getLegend();
        l.setTextSize(15f);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.WHITE);


    }
    private void setData(){


        //ArrayList<RadarEntry> employee1=new ArrayList<>();
        //ArrayList<RadarEntry> employee2=new ArrayList<>();
        //ArrayList<RadarEntry> employee3=new ArrayList<>();
        //for(int i=0;i<NBQUALITIES;i++)

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList<RadarEntry> employee1=new ArrayList<>();
                ArrayList<RadarEntry> employee2=new ArrayList<>();
                ArrayList<RadarEntry> employee3=new ArrayList<>();
                long i =4;

               // long i = dataSnapshot.child("Score").child("Mathematics").child(encodeUserEmail(nameid)).getChildrenCount();
                String val11= (String) dataSnapshot.child("Score").child("Mathematics").child(encodeUserEmail(nameid)).child(String.valueOf(i-1)).getValue();
                String val12= (String) dataSnapshot.child("Score").child("Mathematics").child(encodeUserEmail(nameid)).child(String.valueOf(i-2)).getValue();
                String val13= (String) dataSnapshot.child("Score").child("Mathematics").child(encodeUserEmail(nameid)).child(String.valueOf(i-3)).getValue();
                employee1.add(new RadarEntry(Float.valueOf(val11)));
                employee1.add(new RadarEntry(Float.valueOf(val12)));
                employee1.add(new RadarEntry(Float.valueOf(val13)));
                //i = dataSnapshot.child("Score").child("English").child(encodeUserEmail(nameid)).getChildrenCount();

                String val21=(String) dataSnapshot.child("Score").child("English").child(encodeUserEmail(nameid)).child(String.valueOf(i-1)).getValue();
                String val22=(String) dataSnapshot.child("Score").child("English").child(encodeUserEmail(nameid)).child(String.valueOf(i-2)).getValue();
                String val23=(String) dataSnapshot.child("Score").child("English").child(encodeUserEmail(nameid)).child(String.valueOf(i-3)).getValue();
                employee2.add(new RadarEntry(Float.valueOf(val21)));
                employee2.add(new RadarEntry(Float.valueOf(val22)));
                employee2.add(new RadarEntry(Float.valueOf(val23)));


               // i = dataSnapshot.child("Score").child("Aptitude").child(encodeUserEmail(nameid)).getChildrenCount();

                String val31=(String) dataSnapshot.child("Score").child("Aptitude").child(encodeUserEmail(nameid)).child(String.valueOf(i-1)).getValue();
                String val32=(String) dataSnapshot.child("Score").child("Aptitude").child(encodeUserEmail(nameid)).child(String.valueOf(i-2)).getValue();
                String val33=(String) dataSnapshot.child("Score").child("Aptitude").child(encodeUserEmail(nameid)).child(String.valueOf(i-3)).getValue();
                employee3.add(new RadarEntry(Float.valueOf(val31)));
                employee3.add(new RadarEntry(Float.valueOf(val32)));
                employee3.add(new RadarEntry(Float.valueOf(val33)));

                RadarDataSet set1=new RadarDataSet(employee1,"MATHEMATICS");
                set1.setColor(Color.RED);
                set1.setFillColor(Color.RED);
                set1.setDrawFilled(true);
                set1.setFillAlpha(180);
                set1.setLineWidth(2f);
                set1.setDrawHighlightIndicators(false);
                set1.setDrawHighlightCircleEnabled(true);




                RadarDataSet set2=new RadarDataSet(employee3,"APTITUDE");
                set2.setColor(Color.GREEN);
                set2.setFillColor(Color.GREEN);
                set2.setDrawFilled(true);
                set2.setFillAlpha(180);
                set2.setLineWidth(2f);
                set2.setDrawHighlightIndicators(false);
                set2.setDrawHighlightCircleEnabled(true);


                RadarDataSet set3=new RadarDataSet(employee2,"ENGLISH");
                set3.setColor(Color.BLUE);
                set3.setFillColor(Color.BLUE);
                set3.setDrawFilled(true);
                set3.setFillAlpha(180);
                set3.setLineWidth(2f);
                set3.setDrawHighlightIndicators(false);
                set3.setDrawHighlightCircleEnabled(true);



                ArrayList<IRadarDataSet> sets=new ArrayList<>();
                sets.add(set1);
                sets.add(set2);
                sets.add(set3);
                RadarData data=new RadarData(sets);
                data.setValueTextSize(10f);
                data.setDrawValues(false);
                data.setValueTextColor(Color.WHITE);

                chart.setData(data);

                chart.invalidate();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });/*
        float val11= 13;
        float val12= 10;
        float val13= 7;
        employee1.add(new RadarEntry(val11));
        employee1.add(new RadarEntry(val12) );
        employee1.add(new RadarEntry(val13));

        float val21=9;
        float val22=5;
        float val23=13;
        employee2.add(new RadarEntry(val21));
        employee2.add(new RadarEntry(val22));
        employee2.add(new RadarEntry(val23));



        float val31=2;
        float val32=12;
        float val33=5;
        employee3.add(new RadarEntry(val31));
        employee3.add(new RadarEntry(val32));
        employee3.add(new RadarEntry(val33));


        RadarDataSet set1=new RadarDataSet(employee1,"MATHEMATICS");
        set1.setColor(Color.RED);
        set1.setFillColor(Color.RED);
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightIndicators(false);
        set1.setDrawHighlightCircleEnabled(true);




        RadarDataSet set2=new RadarDataSet(employee2,"APTITUDE");
        set2.setColor(Color.GREEN);
        set2.setFillColor(Color.GREEN);
        set2.setDrawFilled(true);
        set2.setFillAlpha(180);
        set2.setLineWidth(2f);
        set2.setDrawHighlightIndicators(false);
        set2.setDrawHighlightCircleEnabled(true);


        RadarDataSet set3=new RadarDataSet(employee3,"ENGLISH");
        set3.setColor(Color.BLUE);
        set3.setFillColor(Color.BLUE);
        set3.setDrawFilled(true);
        set3.setFillAlpha(180);
        set3.setLineWidth(2f);
        set3.setDrawHighlightIndicators(false);
        set3.setDrawHighlightCircleEnabled(true);



        ArrayList<IRadarDataSet> sets=new ArrayList<>();
        sets.add(set1);
        sets.add(set2);
        sets.add(set3);
        RadarData data=new RadarData(sets);
        data.setValueTextSize(10f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);

        chart.setData(data);

        chart.invalidate();
*/
    }



    public static String encodeUserEmail(String userEmail) {
        return userEmail.replace(".", ",");
    }

    public void ontogclic(View view) {
        for (IDataSet<?> set: chart.getData().getDataSets()){
            set.setDrawValues(!set.isDrawValuesEnabled());
        }
        chart.invalidate();
    }
}
