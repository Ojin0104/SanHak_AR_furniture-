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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyPage extends Fragment {

    private View view;
    private Button btn_myBrand;
    private Button button3;//로그인
    private Button button8;//회원가입
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_my_page,container, false);
//        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        textView=view.findViewById(R.id.textView4);
//        if(firebaseUser!=null){
//            //String temp=getArguments().getString("name");
//            //textView.setText(temp);
//            textView.setText("1234");
//        }
//        else{
//            textView.setText("회원정보가 없습니다.");
//        }
        button3 = view.findViewById(R.id.button3);
        //if(firebaseUser==null){ //로그인 되어있으면
            button3.setOnClickListener(new View.OnClickListener() {     //로그인이동
                @Override
                public void onClick(View v) {
                /*Bundle bundle = new Bundle();
                //bundle.putString();*/
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Login login = new Login();
                    //myBrand.setArguments(bundle);
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.main_frame, login);

                    transaction.commit();
                }
            });

        //else{//로그인이 안되어 있으면
//            button3.setVisibility(View.GONE);
//        }


        button8 = view.findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {     //로그인이동(회원가입)
                @Override
                public void onClick(View v) {
                /*Bundle bundle = new Bundle();
                //bundle.putString();*/
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Login login = new Login();
                    //myBrand.setArguments(bundle);
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.main_frame, login);

                    transaction.commit();
                }
            });



        return view;
    }
}