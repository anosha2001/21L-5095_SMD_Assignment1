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

public class Q9 extends AppCompatActivity {

    int score;
    Button next;
    Button prev;
    RadioGroup rg;
    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_q9);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rg=findViewById(R.id.rg_q9);
        next=findViewById(R.id.btn_next);
        prev=findViewById(R.id.btn_prev);
        score = getIntent().getIntExtra("score", 0);
        scoreText = findViewById(R.id.scoreText);
        scoreText.setText("Score: " + score);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rg.getCheckedRadioButtonId();

                if (selectedId == R.id.rbD9) { // Correct answer: 8
                    score += 1;
                }

                Intent intent = new Intent(Q9.this, Q10.class);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Q9.this, Q8.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish(); // Finish current activity to avoid duplicate screens
            }
        });
    }
}