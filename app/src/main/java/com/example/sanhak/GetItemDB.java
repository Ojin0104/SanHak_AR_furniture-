package com.example.sanhak;


 import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
//안씀
public class GetItemDB extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
    ArrayList<Item> arrayList=new ArrayList();
    ArrayList<Item> colorList=new ArrayList();
    RecyclerView.Adapter adapter;
    private static GetItemDB db = null;
    private Context mContext;


public static GetItemDB getInstance(Context context){
    if(db == null){
        db = new GetItemDB(context.getApplicationContext());
    }

    return db;
}
   private GetItemDB(Context context){
    this.mContext=context;
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance();
        System.out.println(arrayList.size()+"anjsirhtlqkf");
        databaseReference = mDatabase.getReference("item");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                arrayList.clear();
                System.out.println(arrayList.size()+"anjsirhtlqkf");
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Item item = snapshot.getValue(Item.class);//
                    arrayList.add(item);
                    System.out.println(arrayList.size()+"anjsirhtlqkf");
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MainActivity", String.valueOf(error.toException()));
            }


        });
    }
    public ArrayList<Item> GetItemList(){
        System.out.println(arrayList.size()+"anjsirhtlqkf");

        return arrayList;}


    public ArrayList<Item> GetCOLORList(String color){
        for(int i=0; i<arrayList.size();i++){
if (arrayList.get(i).getColor().equals(color)){
    colorList.add(arrayList.get(i));
}}
        return colorList;}
}
