package com.example.avaliacaon1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.ViewHolder> {

    Context context;
    ArrayList<String> valores;

    public RandomAdapter(Context context, ArrayList<String> palavras){
        this.context = context;
        this.valores = palavras;
    }

    @NonNull
    @Override
    public RandomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.random_item_view, parent, false);

        return new RandomAdapter.ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomAdapter.ViewHolder holder, int position) {
        holder.valorView.setText(valores.get(position));
    }

    @Override
    public int getItemCount() {
        return valores.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView valorView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            valorView = itemView.findViewById(R.id.randomWord);
        }
    }
}
