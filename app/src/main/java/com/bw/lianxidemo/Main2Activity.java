package com.bw.lianxidemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String path = intent.getStringExtra("path");

        WebView wv = (WebView)findViewById(R.id.wv);

        wv.loadUrl(path);
    }


}
