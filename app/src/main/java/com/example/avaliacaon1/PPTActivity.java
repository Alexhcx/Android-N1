package com.example.avaliacaon1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PPTActivity extends AppCompatActivity {

    private static final int PEDRA = 0;
    private static final int PAPEL = 1;
    private static final int TESOURA = 2;

    private String compararEscolhas(int escolhaJogador, int escolhaAdversario) {
        if (escolhaJogador == escolhaAdversario) {
            return "Empate!";
        } else if ((escolhaJogador == PEDRA && escolhaAdversario == TESOURA) ||
                (escolhaJogador == PAPEL && escolhaAdversario == PEDRA) ||
                (escolhaJogador == TESOURA && escolhaAdversario == PAPEL)) {
            return "Você venceu!";
        } else {
            return "Você perdeu!";
        }
    }

    private int escolhaAdversario(ImageView imageView){

        int escolhaAdversario = new Random().nextInt(3);

        switch (escolhaAdversario) {
            case PEDRA:
                imageView.setImageResource(R.drawable.pedraai);
                break;
            case PAPEL:
                imageView.setImageResource(R.drawable.papelai);
                break;
            case TESOURA:
                imageView.setImageResource(R.drawable.tesouraai);
                break;
        }

        return escolhaAdversario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ppt_activity);

        ImageView pedra, papel, tesoura, jogadorView, adversarioView;
        TextView vencedor;
        Button bVoltar2;

        pedra = findViewById(R.id.pedraJogador);
        papel = findViewById(R.id.papelJogador);
        tesoura = findViewById(R.id.tesouraJogador);
        jogadorView = findViewById(R.id.jogador);
        adversarioView = findViewById(R.id.adversario);
        vencedor = findViewById(R.id.vencedor);
        bVoltar2 = findViewById(R.id.bVoltar2);

        pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogadorView.setImageResource(R.drawable.pedra);
                String resultado = compararEscolhas(PEDRA, escolhaAdversario(adversarioView));
                vencedor.setText(resultado);
            }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogadorView.setImageResource(R.drawable.papel);
                String resultado = compararEscolhas(PAPEL, escolhaAdversario(adversarioView));
                vencedor.setText(resultado);
            }
        });

        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogadorView.setImageResource(R.drawable.tesoura);
                String resultado = compararEscolhas(TESOURA, escolhaAdversario(adversarioView));
                vencedor.setText(resultado);
            }
        });

        bVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
