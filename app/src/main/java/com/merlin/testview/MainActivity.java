package com.merlin.testview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.merlin.testview.view.TestPathView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.w("merlin",""+Math.sin(Math.PI / 6 * 3));
        Log.w("merlin","son-------------"+Son.getMac());



    }
}
