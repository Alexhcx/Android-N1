package com.example.avaliacaon1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class SecretCodeActivity extends AppCompatActivity {

    private EditText n1, n2, n3, n4;
    private ArrayList<EditText> editTextList = new ArrayList<>();
    private ArrayList<SecretCodeData> tentativas = new ArrayList<>();
    private int[] numeroSorteado = new int[4];
    private int[] palpite = new int[4];
    private int editTextPreenchidoCont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secretcode_activity);

        numeroSorteado = gerarNumeroSecreto();

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);

        n1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
        n2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
        n3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
        n4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);


        n1.setFilters(new InputFilter[] {new FiltroNumeroInput(0, 9)});
        n2.setFilters(new InputFilter[] {new FiltroNumeroInput(0, 9)});
        n3.setFilters(new InputFilter[] {new FiltroNumeroInput(0, 9)});
        n4.setFilters(new InputFilter[] {new FiltroNumeroInput(0, 9)});

        editTextList.add(n1);
        editTextList.add(n2);
        editTextList.add(n3);
        editTextList.add(n4);

        for (int i = 0; i < 4; i++) {
            setEditTextListeners(editTextList.get(i));
        }

        Button bVoltar = findViewById(R.id.bVoltar3);
        bVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setEditTextListeners(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    int position = editTextList.indexOf(editText);
                    int numeroDigitado = Integer.parseInt(s.toString());
                    palpite[position] = numeroDigitado;

                    editTextPreenchidoCont++;

                    int nextIndex = position + 1;
                    if (nextIndex < editTextList.size()) {
                        EditText nextEditText = editTextList.get(nextIndex);
                        nextEditText.requestFocus();
                    }

                    if (editTextPreenchidoCont == 4) {
                        compararPalpite();
                    }

                    if (s.toString().isEmpty()) {
                        editTextPreenchidoCont--;
                    }
                }
            }
        });
    }
    private void compararPalpite() {
        SecretCodeData tentativa = new SecretCodeData();
        boolean acertou = true;
        for (int i = 0; i < 4; i++) {
            if (numeroSorteado[i] != palpite[i]) {
                acertou = false;
                break;
            }
        }

        tentativa.setN1(String.valueOf(palpite[0]));
        tentativa.setN2(String.valueOf(palpite[1]));
        tentativa.setN3(String.valueOf(palpite[2]));
        tentativa.setN4(String.valueOf(palpite[3]));
        tentativas.add(new SecretCodeData(tentativa));

        RecyclerView recyclerView = findViewById(R.id.recyclerCode);
        SecretCodeAdapter adapter = new SecretCodeAdapter(this, tentativas, numeroSorteado);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (acertou) {
            Intent intent = new Intent(SecretCodeActivity.this, SecretCodeWinActivity.class);
            intent.putExtra("tentativas", tentativas.size());
            startActivity(intent);
            Toast.makeText(this, "Parabéns! Você acertou o código secreto!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            for (EditText editText : editTextList) {
                editText.setText("");
            }
            editTextPreenchidoCont = 0;

            editTextList.get(0).requestFocus();

            Toast.makeText(this, "Código incorreto. Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }
    private int[] gerarNumeroSecreto() {
        Random random = new Random();
        int[] digitos = new int[4];
        for (int i = 0; i < 4; i++) {
            digitos[i] = random.nextInt(10);
        }
        return digitos;
    }
}
