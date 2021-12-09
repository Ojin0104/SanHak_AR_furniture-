package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FurnitureInfo extends Fragment {
//ShopActivity Shop=new ShopActivity();
private String name;
    private String color;
    private String img;
    private String brand;
    private String price;
    TextView name_t;
    TextView color_t;
    TextView brand_t;
    ImageView img_i;
    String url;
    TextView price_t;
Button urlb;
        private View view;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.activity_furniture_info, container, false);
            //Shop.GetItemList();
            if(getArguments()!=null){
                name=getArguments().getString("name");
                brand=getArguments().getString("brand");
                img=getArguments().getString("img");
                color=getArguments().getString("color");
                url=getArguments().getString("url");
                price=getArguments().getString("price");
            }

urlb=view.findViewById(R.id.btn_link);
            urlb.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent urlintent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    urlintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(urlintent);
                }
            });
            name_t=(TextView)view.findViewById(R.id.fur_name);
            color_t=(TextView)view.findViewById(R.id.fur_color);
            brand_t=(TextView)view.findViewById(R.id.fur_brand);
            img_i=(ImageView)view.findViewById(R.id.imageView2);
            price_t=(TextView)view.findViewById(R.id.fur_price);
            name_t.setText(name);
            color_t.setText("색깔 : "+color);
            brand_t.setText("브랜드 명: "+brand);
            price_t.setText("최저가 : "+price);
            Glide.with(this)
                    .load(img)
                    .into(img_i);
            return view;
        }
}