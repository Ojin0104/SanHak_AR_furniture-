package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private View view;
    private SignInButton signInButton;      //구글 로그인 버튼
    private FirebaseAuth auth;              //파이어베이스 인증갯체
    private GoogleApiClient googleApiClient;//구글 API 클라이언트 객체
    private GoogleSignInClient googleSignInClient;
    private static final int REQ_GOOGLE=100;//구글 로그인 결과코드
    private FragmentTransaction ft;
    private FragmentManager fm;
    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)  //sign in 버튼이 눌릴떄 옵션세팅
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .build();
        auth=FirebaseAuth.getInstance();//파이어베이스 인증 객체 초기화

        signInButton=findViewById(R.id.SignIn_Button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,REQ_GOOGLE);
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_GOOGLE){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
              //  GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                try {
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                   // Toast.makeText(Login.this,"연결성공1",Toast.LENGTH_LONG).show();

                    resultLogin(account);
                }
                 catch (ApiException e) {
                    // Google Sign In failed, update UI appropriately
                     Toast.makeText(Login.this,"연결실패1",Toast.LENGTH_LONG).show();
                    }
                }
        }




    private void resultLogin(GoogleSignInAccount account) {
        AuthCredential credential= GoogleAuthProvider.getCredential(account.getIdToken(),null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){ //로그인 성공시
                         //   Toast.makeText(Login.this ,"로그인성공",Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            Toast.makeText(Login.this ,account.getDisplayName()+"님 안녕하세요",Toast.LENGTH_LONG).show();


                        }
                        else{
                            Toast.makeText(Login.this,"로그인실패",Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(Login.this,"연결실패3",Toast.LENGTH_LONG).show();
    }

}