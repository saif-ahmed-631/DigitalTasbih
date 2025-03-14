package com.opu.digitaltasbih;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static android.widget.Toast.LENGTH_LONG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tCounter;
    Button bAdd, bSub, bReset;
    int count = 0;

    Button bShow, bHide, bToast, bAboutMe;
    ImageView iImg1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tCounter = findViewById(R.id.txtCounter);
        bAdd = findViewById(R.id.btnAdd);
        bSub = findViewById(R.id.btnSub);
        bReset = findViewById(R.id.btnReset);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tCounter.setText(""+count);
            }
        });
        bSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count--;
                    tCounter.setText(""+count);
                }
            });
        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                tCounter.setText(""+count);
            }
        });

        iImg1 = findViewById(R.id.img1);
        bShow = findViewById(R.id.btnShow);
        bHide = findViewById(R.id.btnHide);
        bToast = findViewById(R.id.btnToast);
        bAboutMe = findViewById(R.id.btnAboutMe);

        bShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iImg1.setVisibility(VISIBLE);
            }
        });

        bHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iImg1.setVisibility(INVISIBLE);
            }
        });

        bToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello I am a Toast...", LENGTH_LONG).show();
            }
        });

        bAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iAboutMe = new Intent(MainActivity.this, AboutMe.class);
                startActivity(iAboutMe);
            }
        });

    }
}