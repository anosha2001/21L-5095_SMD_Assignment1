package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Q1 extends AppCompatActivity {

    TextView heading;
    int score = 0;
    Button next;
    Button prev;
    RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_q1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rg1.getCheckedRadioButtonId();

                if (selectedId == R.id.rbC1) {
                    score = 1;
                }

                // Pass score to next question
                Intent intent = new Intent(Q1.this, Q2.class);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
    }


    private void init(){
        heading=findViewById(R.id.tv_heading);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        heading.setText(name);
        rg1 = findViewById(R.id.rg_q1);
        next = findViewById(R.id.btn_next);

    }
}