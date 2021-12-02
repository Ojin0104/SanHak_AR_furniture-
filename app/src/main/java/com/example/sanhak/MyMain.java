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

public class MyMain extends Fragment {

    private View view;
    private Button button2;//소파버튼

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_my_main,container, false);





        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {     //가구선택창
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ShopActivity shop= new ShopActivity();
                transaction.addToBackStack(null);

                transaction.replace(R.id.main_frame, shop);

                transaction.commit();
//                Intent intent = new Intent(getActivity(),ShopActivity.class);
//                startActivity(intent);
            }
        });
        return view;
    }
}