package com.example.avaliacaon1;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class RandomizerActivity extends AppCompatActivity {

    ArrayList<String> valores = new ArrayList<>();
    RecyclerView valoresSorteio;
    EditText digitarValores;
    TextView valoresSorteados;
    Button bVoltar, bSortear, bAdd;
    RandomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomizer_activity);

        valoresSorteio = findViewById(R.id.randomRecycler);
        valoresSorteados = findViewById(R.id.itemSorteado);
        digitarValores = findViewById(R.id.randomInput);
        bVoltar = findViewById(R.id.bVoltar5);
        bSortear = findViewById(R.id.sortearPalavra);
        bAdd = findViewById(R.id.addPalavra);

        adapter = new RandomAdapter(this, valores);
        valoresSorteio.setAdapter(adapter);
        valoresSorteio.setLayoutManager(new LinearLayoutManager(this));

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValor();
            }
        });

        bVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        digitarValores.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    addValor();
                    return true;
                }
                return false;
            }
        });

        bSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortearValor();
            }
        });
    }

    private void addValor() {
        String valor = digitarValores.getText().toString().trim();
        if (!valor.isEmpty()) {
            valores.add(valor);
            adapter.notifyDataSetChanged();
            digitarValores.setText("");
        }
    }

    private void sortearValor() {
        if (!valores.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(valores.size());
            String valorSorteado = valores.get(index);
            valoresSorteados.setText(valorSorteado);
        }
    }
}
