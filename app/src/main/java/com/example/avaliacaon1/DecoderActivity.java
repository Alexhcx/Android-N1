package com.example.avaliacaon1;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DecoderActivity extends AppCompatActivity {

    EditText codificador, decodificador;
    Button ok1, ok2, bVoltar;
    TextView decoderResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.decoder_activity);

        codificador = findViewById(R.id.codificador);
        decodificador = findViewById(R.id.decodificador);
        ok1 = findViewById(R.id.ok1);
        ok2 = findViewById(R.id.ok2);
        bVoltar = findViewById(R.id.bVoltar);
        decoderResultado = findViewById(R.id.decoderResultado);


        ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoCodificado = codificarTexto(codificador.getText().toString(), 3);
                decoderResultado.setText(textoCodificado);
                esconderTeclado();
            }
        });

        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDecodificado = decodificarTexto(decodificador.getText().toString(), 3);
                decoderResultado.setText(textoDecodificado);
                esconderTeclado();
            }
        });

        decoderResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Texto Copiado", decoderResultado.getText());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(DecoderActivity.this, "Texto copiado", Toast.LENGTH_SHORT).show();
            }
        });

        bVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String codificarTexto(String texto, int chave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            char novoCaracter;

            if (Character.isLetter(caracter)) {
                int base = Character.isUpperCase(caracter) ? 'A' : 'a';
                novoCaracter = (char) (((caracter - base + chave) % 26) + base);

            } else {
                novoCaracter = caracter;
            }
            resultado.append(novoCaracter);
        }

        return resultado.toString();
    }
    private String decodificarTexto(String texto, int chave) {
        return codificarTexto(texto, 26 - chave);
    }

    private void esconderTeclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
