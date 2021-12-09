package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyPage extends Fragment {

    private View view;
    private Button btn_myBrand;
    private Button button3;//로그인
    private Button button_logout;//로그아웃
    private Button button8;//회원가입
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private TextView textView;
    private FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_my_page,container, false);
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        textView=view.findViewById(R.id.textView4);

        button3 = view.findViewById(R.id.button3);
        if(firebaseUser==null) { //로그인 안되어있으면
            button3.setVisibility(View.VISIBLE);
            button3.setOnClickListener(new View.OnClickListener() {     //로그인이동
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivity(intent);
                }
            });
        }
        else{//로그인이 안되어 있으면
            button3.setVisibility(View.GONE);
        }

        button_logout=view.findViewById(R.id.button_logout);
        if(firebaseUser==null) { //로그인 안되어있으면
            button_logout.setVisibility(View.GONE);

        }
        else{//로그인이 되어 있으면
            button_logout.setVisibility(View.VISIBLE);
            button_logout.setOnClickListener(new View.OnClickListener() {     //로그인이동
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity().getApplicationContext() , "안녕히가세요",Toast.LENGTH_LONG).show();
                    FirebaseAuth.getInstance().signOut();
                    MyMain myMain=new MyMain();
                    fragmentTransaction= getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_frame,myMain);
                    fragmentTransaction.commit();
                }
            });
        }

        button8 = view.findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {     //로그인이동(회원가입)
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivity(intent);

                }
            });



        return view;
    }
}