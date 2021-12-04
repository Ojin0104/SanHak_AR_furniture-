package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FurnitureInfo extends Fragment {
//ShopActivity Shop=new ShopActivity();
private String name;
    private String color;
    private String img;
    private String brand;
    TextView name_t;
    TextView color_t;
    TextView brand_t;
    ImageView img_i;


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
            }


            name_t=(TextView)view.findViewById(R.id.fur_name);
            color_t=(TextView)view.findViewById(R.id.fur_color);
            brand_t=(TextView)view.findViewById(R.id.fur_brand);
            img_i=(ImageView)view.findViewById(R.id.imageView2);
            name_t.setText(name);
            color_t.setText(color);
            brand_t.setText(brand);
            Glide.with(this)
                    .load(img)
                    .into(img_i);
            return view;
        }
}