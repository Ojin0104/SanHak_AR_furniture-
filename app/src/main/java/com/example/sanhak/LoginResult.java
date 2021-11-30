package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginResult extends Fragment {

    private View view;
    private TextView textView;
    private String name;
    private Button logout;
    private FirebaseAuth firebaseAuth;
    private FragmentTransaction ft;
    private FragmentManager fm;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_login_result,container, false);

        logout=view.findViewById(R.id.button_logout);
        firebaseAuth=FirebaseAuth.getInstance();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                MyPage myPage=new MyPage();
                ft= getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_frame,myPage);
                ft.commit();
                Toast.makeText(getContext(),"로그아웃 성공",Toast.LENGTH_LONG).show();

            }
        });
        textView=view.findViewById(R.id.textView_name);
        if(getArguments()!=null){
            name=getArguments().getString("name");
            textView.setText(name);
        }
        return view;
    }
}