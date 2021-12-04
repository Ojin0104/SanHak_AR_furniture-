package com.example.sanhak;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemViewHolder>{
private ArrayList<Item> arrayList;

    private ItemClickListener listener;


    public ItemAdapter(ArrayList<Item> arrayList, ItemClickListener listener) {
        this.arrayList = arrayList;
    this.listener=listener;

    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
       itemViewHolder holder=new itemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {//그림이랑 데이터값 가져와줌
        Item item=arrayList.get(position);
        Glide.with(holder.itemView)
                .load(item.getImg())
                .into(holder.imageView);//load image from server
        //  holder.iv_profile.setImageDrawable(arrayList.get(position).getProfile());
        holder.item_name.setText(item.getName());


        final int index = position;
        holder.imageView.setOnClickListener(v -> {
            listener.onItemClick2(v, index);
        });

    }
//    public void updateData(ArrayList<Item> data){
//        this.arrayList=data;
//        notifyDataSetChanged();
//    }
    @Override
    public int getItemCount() {
         if(arrayList == null)
            return 0;
        else
            return arrayList.size();
    }
    public void updateData(ArrayList<Item> data){
        this.arrayList = data;
        notifyDataSetChanged();
    }


    public class itemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        TextView item_name;


        public itemViewHolder(@NonNull View itemView) {//여기서 그림 클릭시 상품정보 이동
            super(itemView);
            this.imageView=itemView.findViewById(R.id.imageView);
            this.item_name=itemView.findViewById(R.id.item_name);


        }
    }
}


