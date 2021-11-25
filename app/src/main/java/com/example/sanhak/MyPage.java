package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyPage extends Fragment {

    private View view;
    private Button btn_myBrand;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_my_page,container, false);

        btn_myBrand = view.findViewById(R.id.btn_myBrand);
        btn_myBrand.setOnClickListener(new View.OnClickListener() {     //즐겨찾는 브랜드이동
            @Override
            public void onClick(View v) {
                /*Bundle bundle = new Bundle();
                //bundle.putString();*/
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                MyBrand myBrand = new MyBrand();
                //myBrand.setArguments(bundle);
                transaction.replace(R.id.main_frame, myBrand);
                transaction.commit();
            }
        });

        return view;
    }
}