package com.example.sanhak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.TypeViewHolder> {
    private String[] data;
    private ItemClickListener listener;


    public TypeAdapter(String[] data, ItemClickListener listener) {
        this.data = data;
        this.listener = listener;

    }


    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_typeselector, parent, false);
        TypeAdapter.TypeViewHolder holder = new TypeAdapter.TypeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int position) {
        holder.typeSelect.setText(data[position]);

        final int index = position;
        holder.typeSelect.setOnClickListener(v -> {
          listener.onItemClick(v, index);
        });
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        else
            return data.length;
    }

    public class TypeViewHolder extends RecyclerView.ViewHolder {
        TextView typeSelect;

        public TypeViewHolder(@NonNull View itemView) {
            super(itemView);

            typeSelect = itemView.findViewById(R.id.typeSelectTv);
        }
    }}

