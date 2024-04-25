package com.example.avaliacaon1;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecretCodeAdapter extends RecyclerView.Adapter<SecretCodeAdapter.ViewHolder> {
    Context context;
    ArrayList<SecretCodeData> tentativas;
    int[] numeroSorteado;

    public SecretCodeAdapter(Context context, ArrayList<SecretCodeData> tentativas, int[] numeroSorteado){
        this.context = context;
        this.tentativas = tentativas;
        this.numeroSorteado = numeroSorteado;
    }

    @NonNull
    @Override
    public SecretCodeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_view, parent, false);

        return new SecretCodeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecretCodeAdapter.ViewHolder holder, int position) {

        holder.nr1.setText(tentativas.get(position).getN1());
        holder.nr2.setText(tentativas.get(position).getN2());
        holder.nr3.setText(tentativas.get(position).getN3());
        holder.nr4.setText(tentativas.get(position).getN4());

        int[] palpite = {
                Integer.parseInt(tentativas.get(position).getN1()),
                Integer.parseInt(tentativas.get(position).getN2()),
                Integer.parseInt(tentativas.get(position).getN3()),
                Integer.parseInt(tentativas.get(position).getN4())
        };

        for (int i = 0; i < 4; i++) {
            if (palpite[i] == numeroSorteado[i]) {
                switch (i) {
                    case 0:
                        holder.nr1.setTextColor(ContextCompat.getColor(context, R.color.verde));
                        break;
                    case 1:
                        holder.nr2.setTextColor(ContextCompat.getColor(context, R.color.verde));
                        break;
                    case 2:
                        holder.nr3.setTextColor(ContextCompat.getColor(context, R.color.verde));
                        break;
                    case 3:
                        holder.nr4.setTextColor(ContextCompat.getColor(context, R.color.verde));
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        holder.nr1.setTextColor(ContextCompat.getColor(context, R.color.vermelho));
                        break;
                    case 1:
                        holder.nr2.setTextColor(ContextCompat.getColor(context, R.color.vermelho));
                        break;
                    case 2:
                        holder.nr3.setTextColor(ContextCompat.getColor(context, R.color.vermelho));
                        break;
                    case 3:
                        holder.nr4.setTextColor(ContextCompat.getColor(context, R.color.vermelho));
                        break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return tentativas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView nr1, nr2, nr3, nr4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nr1 = itemView.findViewById(R.id.nr1);
            nr2 = itemView.findViewById(R.id.nr2);
            nr3 = itemView.findViewById(R.id.nr3);
            nr4 = itemView.findViewById(R.id.nr4);

        }
    }
}
