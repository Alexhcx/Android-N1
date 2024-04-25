package com.example.avaliacaon1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ProgramasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.programas_activity);

        LinearLayout decoderLayout, pPTLayout, secretCodeLayout, randomizerLayout;

        decoderLayout = findViewById(R.id.decoderLayout);
        pPTLayout = findViewById(R.id.pPTLayout);
        secretCodeLayout = findViewById(R.id.secretCodeLayout);
        randomizerLayout = findViewById(R.id.randomizerLayout);

        decoderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPrograma("Decoder");
            }
        });

        pPTLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPrograma("Pedra, Papel e Tesoura");
            }
        });

        secretCodeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPrograma("SecretCode");
            }
        });

        randomizerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPrograma("Randomizer");
            }
        });
    }

    private void abrirPrograma(String nomePrograma) {
        Toast.makeText(ProgramasActivity.this, "Abrindo o " + nomePrograma, Toast.LENGTH_SHORT).show();

        if(nomePrograma.equalsIgnoreCase("Decoder")){
            Intent intent = new Intent(ProgramasActivity.this, DecoderActivity.class);
            startActivity(intent);
        } else if (nomePrograma.equalsIgnoreCase("Pedra, Papel e Tesoura")) {
            Intent intent = new Intent(ProgramasActivity.this, PPTActivity.class);
            startActivity(intent);
        } else if (nomePrograma.equalsIgnoreCase("SecretCode")) {
            Intent intent = new Intent(ProgramasActivity.this, SecretCodeActivity.class);
            startActivity(intent);
        } else{
            Intent intent = new Intent(ProgramasActivity.this, RandomizerActivity.class);
            startActivity(intent);
        }

    }
}

