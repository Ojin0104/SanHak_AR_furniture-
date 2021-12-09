package com.example.sanhak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class zzimadapter extends RecyclerView.Adapter<zzimadapter.zzimViewHolder>{
private ArrayList<zzim> arrayList;
    private ItemClickListener2 listener;
    public zzimadapter(ArrayList<zzim> arrayList, ItemClickListener2 listener) {
        this.arrayList = arrayList;
        this.listener=listener;

    }
    @NonNull
    @Override
    public zzimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.zzim_layout,parent,false);
        zzimViewHolder holder=new zzimadapter.zzimViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull zzimViewHolder holder, int position) {
        zzim zim=arrayList.get(position);
        Glide.with(holder.itemView)
                .load(zim.getImg())
                .into(holder.zzim_img);//load image from server
        //  holder.iv_profile.setImageDrawable(arrayList.get(position).getProfile());
        holder.zzim_name.setText(zim.getName());
        holder.zzim_price.setText(zim.getPrice());
        holder.zzim_delete.setOnClickListener(v->{
            listener.onItemClick(v,position);
        });

    }

    @Override
    public int getItemCount() {
        if(arrayList == null)
            return 0;
        else
            return arrayList.size();
    }

    public void updateData(ArrayList<zzim> data){
        this.arrayList = data;
        notifyDataSetChanged();
    }
    public class zzimViewHolder extends RecyclerView.ViewHolder {
        ImageView zzim_img;
        TextView zzim_name;
        TextView zzim_price;
Button zzim_delete;
        public zzimViewHolder(@NonNull View itemView) {
            super(itemView);
            this.zzim_img=itemView.findViewById(R.id.zzim_img);
            this.zzim_name=itemView.findViewById(R.id.zzim_name);
            this.zzim_price=itemView.findViewById(R.id.zzim_price);
            this.zzim_delete=itemView.findViewById(R.id.zzim_delete);
        }
    }
}



