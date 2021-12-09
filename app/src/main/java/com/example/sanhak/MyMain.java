package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyMain extends Fragment {

    private View view;
    private Button button2;//소파버튼
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button arTest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_my_main,container, false);






        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {     //가구선택창
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                String type=String.valueOf(button2.getText());
                bundle.putString("fur_type",type);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ShopActivity shop= new ShopActivity();
                transaction.addToBackStack(null);

                transaction.replace(R.id.main_frame, shop);
                shop.setArguments(bundle);
                transaction.commit();
//                Intent intent = new Intent(getActivity(),ShopActivity.class);
//                startActivity(intent);
            }
        });
        button4 = view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {     //가구선택창
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                String type=String.valueOf(button4.getText());
                bundle.putString("fur_type",type);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ShopActivity shop= new ShopActivity();
                transaction.addToBackStack(null);

                transaction.replace(R.id.main_frame, shop);
                shop.setArguments(bundle);
                transaction.commit();
//                Intent intent = new Intent(getActivity(),ShopActivity.class);
//                startActivity(intent);
            }
        });
        button5 = view.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {     //가구선택창
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                String type=String.valueOf(button5.getText());
                bundle.putString("fur_type",type);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ShopActivity shop= new ShopActivity();
                transaction.addToBackStack(null);

                transaction.replace(R.id.main_frame, shop);
                shop.setArguments(bundle);
                transaction.commit();
//                Intent intent = new Intent(getActivity(),ShopActivity.class);
//                startActivity(intent);
            }
        });
        button6 = view.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {     //가구선택창
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                String type=String.valueOf(button6.getText());
                bundle.putString("fur_type",type);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ShopActivity shop= new ShopActivity();
                transaction.addToBackStack(null);

                transaction.replace(R.id.main_frame, shop);
                shop.setArguments(bundle);
                transaction.commit();
//                Intent intent = new Intent(getActivity(),ShopActivity.class);
//                startActivity(intent);
            }
        });
        button7 = view.findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {     //가구선택창
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                String type=String.valueOf(button7.getText());
                bundle.putString("fur_type",type);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ShopActivity shop= new ShopActivity();
                transaction.addToBackStack(null);

                transaction.replace(R.id.main_frame, shop);
                shop.setArguments(bundle);
                transaction.commit();
//                Intent intent = new Intent(getActivity(),ShopActivity.class);
//                startActivity(intent);
            }
        });
//        arTest = view.findViewById(R.id.arTest);
//        arTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), GltfActivity.class);
//                startActivity(intent);
//            }
//        });



        return view;
    }
}