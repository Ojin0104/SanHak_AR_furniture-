package com.example.sanhak;


import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder;
import com.google.firebase.database.core.Context;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
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
        holder.item_price.setText("최저가  "+item.getPrice());
        holder.item_price1.setText(item.getPrice());
        holder.item_price2.setText(item.getPrice1());
        holder.item_price3.setText(item.getPrice2());

        final int index = position;
        ///////////////클릭이벤트 처리 itemClickListener 사용 ShopActivity에서 정의
        holder.item_url.setOnClickListener(v->{
            listener.onItemClick3(v,index);
        });
        holder.item_url2.setOnClickListener(v->{
            listener.onItemClick4(v,index);
        });
        holder.item_url3.setOnClickListener(v->{
            listener.onItemClick5(v,index);
        });
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
        ImageView item_url;
        ImageView item_url2;
        ImageView item_url3;
        TextView item_name;
        TextView item_price;
        TextView item_price1;
        TextView item_price2;
        TextView item_price3;

        public itemViewHolder(@NonNull View itemView) {//여기서 그림 클릭시 상품정보 이동
            super(itemView);
            this.imageView=itemView.findViewById(R.id.imageView);
            this.item_name=itemView.findViewById(R.id.item_name);
            this.item_price=itemView.findViewById(R.id.item_price);
            this.item_price1=itemView.findViewById(R.id.item_price1);
            this.item_price2=itemView.findViewById(R.id.item_price2);
            this.item_price3=itemView.findViewById(R.id.item_price3);
            this.item_url=itemView.findViewById(R.id.btn_page);
            this.item_url2=itemView.findViewById(R.id.btn_page2);
            this.item_url3=itemView.findViewById(R.id.btn_page3);
        }
    }
}


