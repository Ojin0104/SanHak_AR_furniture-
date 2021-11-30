//package com.example.sanhak;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder;
//import com.google.firebase.database.core.Context;
//
//import java.util.ArrayList;
//
//public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemViewHolder>{
//private ArrayList<Item> arrayList;
//private Context context;
//
//    public ItemAdapter(ArrayList<Item> arrayList, Context context) {
//        this.arrayList = arrayList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
//       ItemViewHolder holder=new ItemViewHolder(view);
//    return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).getProfile())
//                .into(holder.iv_profile);//load image from server
//        //  holder.iv_profile.setImageDrawable(arrayList.get(position).getProfile());
//        holder.tv_id.setText(arrayList.get(position).getId());
//        holder.tv_pw.setText(String.valueOf(arrayList.get(position).getPw()));
//        holder.tv_userName.setText(arrayList.get(position).getUserName());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public class itemViewHolder extends RecyclerView.ViewHolder {
//        ImageView iv_profile;
//        TextView tv_id;
//        TextView tv_pw;
//        TextView tv_userName;
//
//        public itemViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.iv_profile=itemView.findViewById(R.id.iv_profile);
//            this.tv_id=itemView.findViewById(R.id.tv_id);
//            this.tv_pw=itemView.findViewById(R.id.tv_pw);
//            this.tv_userName=itemView.findViewById(R.id.tv_userName);
//        }
//    }
//}


