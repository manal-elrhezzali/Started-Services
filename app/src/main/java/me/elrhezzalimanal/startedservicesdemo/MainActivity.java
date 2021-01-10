package me.elrhezzalimanal.startedservicesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, ExampleOfService.class);
//        intent.putExtra("number",10);
//        startService(intent);
//        startService(intent);

        Intent intent = new Intent(this, ExampleOfIntentService.class);
        intent.putExtra("number",10);
        startService(intent);
        startService(intent);
    }
}