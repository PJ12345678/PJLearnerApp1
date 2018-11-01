package hhird.harsh123.com.learnerapp;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;


public class LearnerApp extends Application {

    @Override

    public void onCreate(){

        super.onCreate();

        if (!FirebaseApp.getApps(this).isEmpty()){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }

    }
}
