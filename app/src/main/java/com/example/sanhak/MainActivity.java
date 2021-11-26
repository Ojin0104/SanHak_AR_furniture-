package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; //하단바
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MyList myList;
    private MyPage myPage;
    private MyMain myMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
        startActivity(intent);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.main:
                        setFrag(0);
                        break;
                    case R.id.my_list:
                        setFrag(1);
                        break;
                    case R.id.my_page:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });


        myMain = new MyMain();
        myList = new MyList();
        myPage = new MyPage();
        setFrag(0);



    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame, myMain);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.main_frame, myList);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, myPage);
                ft.commit();
                break;
        }

    }

}
