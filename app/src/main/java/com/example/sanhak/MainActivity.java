package com.example.sanhak;

/*
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
                ft.addToBackStack(null);
                ft.replace(R.id.main_frame, myMain);
                ft.commit();
                break;

            case 1:
                ft.addToBackStack(null);
                ft.replace(R.id.main_frame, myList);
                ft.commit();
                break;
            case 2:
                ft.addToBackStack(null);
                ft.replace(R.id.main_frame, myPage);
                ft.commit();
                break;
        }

    }

}
*/
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ArFragment arFragment;

    private int clickNo = 0;

    public static boolean checkSystem(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String openGlVersion = ((ActivityManager) Objects.requireNonNull(activity.getSystemService(Context.ACTIVITY_SERVICE))).getDeviceConfigurationInfo().getGlEsVersion();

            if (Double.parseDouble(openGlVersion) >= 3.0) {
                return true;
            } else {
                Toast.makeText(activity, "App needs OpenGl Version 3.0 or later", Toast.LENGTH_SHORT).show();
                activity.finish();
                return false;
            }
        } else {
            Toast.makeText(activity, "App does not support required Build Version", Toast.LENGTH_SHORT).show();
            activity.finish();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkSystem(this)) {

            arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
            Objects.requireNonNull(arFragment).setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
                clickNo++;
                if (clickNo == 1) {
                    Anchor anchor = hitResult.createAnchor();
                    ModelRenderable.builder()
                            .setSource(this, R.raw.gladiador)
                            .setIsFilamentGltf(true)
                            .build()
                            .thenAccept(modelRenderable -> add(anchor, modelRenderable))
                            .exceptionally(throwable -> {
                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                builder.setMessage("Something is not right" + throwable.getMessage()).show();
                                return null;
                            });
                }
            });
        }
    }

    private void add(Anchor anchor, ModelRenderable modelRenderable) {

        AnchorNode anchorNode = new AnchorNode(anchor);
        anchorNode.setParent(arFragment.getArSceneView().getScene());
        TransformableNode model = new TransformableNode(arFragment.getTransformationSystem());
        model.setParent(anchorNode);
        model.setRenderable(modelRenderable);
        model.select();
    }
}
