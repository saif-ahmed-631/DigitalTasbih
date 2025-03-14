package com.opu.digitaltasbih;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutMe extends AppCompatActivity {

    WebView wAstha;
    Button bWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_me);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        wAstha = findViewById(R.id.wvAstha);
        bWebView = findViewById(R.id.btnWebview);

        bWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iWebView = new Intent(AboutMe.this, WebviewActivity.class);
                startActivity(iWebView);
            }
        });


        wAstha.getSettings().setJavaScriptEnabled(true);
        //wAstha.loadUrl("https://www.youtube.com/embed/y6oMutwJQCw");
        wAstha.loadUrl("https://www.youtube.com/embed/LXb3EKWsInQ");
        //wAstha.loadUrl("https://www.youtube.com/watch?v=LXb3EKWsInQ");


    }
}