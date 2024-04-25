package com.example.avaliacaon1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecretCodeWinActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.secretcodewin_layout);

        TextView nTentativas;
        Button bVoltar;
        int tentativasSize = getIntent().getIntExtra("tentativas", 0);

        nTentativas = findViewById(R.id.nTentativas);
        bVoltar = findViewById(R.id.bVoltar4);

        nTentativas.setText(String.valueOf(tentativasSize + 1));

        bVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
