package com.just8.apps.hellomoon;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


public class HelloMoonActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_moon);                   // IS DEFINED WITH A FRAGMENT TAG
    }

}
