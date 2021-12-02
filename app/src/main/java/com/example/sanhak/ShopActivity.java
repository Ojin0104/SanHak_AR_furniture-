package com.example.sanhak;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShopActivity extends Fragment implements ItemClickListener{
    private static  String COLOR_BLACK="검정색";
    private static  String COLOR_GRAY="회색";

    private FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
   private ArrayList<Item> arrayList=new ArrayList<>();
    private ArrayList<Item> colorList=new ArrayList<>();
    public RecyclerView.Adapter adapter;
    //private static GetItemDB db = null;
    public Context mContext;




    private RecyclerView recyclerView;

    private ItemAdapter iAdapter;
    private TypeAdapter tAdapter;
    private String[] tData={"검정색","회색"};
   private ArrayList<Item> iData=new ArrayList<>();
    private ArrayList<Item> pData=new ArrayList<>();
   // private GetItemDB getItem;
private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_shop,container, false);


        mDatabase = FirebaseDatabase.getInstance();
        databaseReference = mDatabase.getReference("Item");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
               // arrayList.clear();

                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Item item = snapshot.getValue(Item.class);//
                    arrayList.add(item);

                }
iAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }


        });


        showTypeSelector();
        showProduct();
        return view;
    }

    private void showTypeSelector(){

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView = view.findViewById(R.id.typeSelectRecycler);
        recyclerView.setLayoutManager(layoutManager);
        tAdapter = new TypeAdapter(tData, this);
        recyclerView.setAdapter(tAdapter);

    }
    private void showProduct() {//전체상품보여주기 이쪽건들여서 가구 종류 클릭시 만들기

        pData.clear();
        pData=GetItemList();
        System.out.println(arrayList.size());
        iAdapter=new ItemAdapter(pData,this);



        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = view.findViewById(R.id.productRecycler);
        recyclerView.setLayoutManager(layoutManager);
        //iAdapter = new ItemAdapter(arrayList,this);
        recyclerView.setAdapter(iAdapter);//setAdapter실행해야지 OnDataChange 실행됨 -> 이 위에 arraylist는 빈배열
    }

    private void showProduct(String type){//필터에 해당하는 상품보여주기


       iData.clear();
       iData=GetCOLORList(type);
       iAdapter.updateData(iData);//update해주면서 기존 데이터지워줌
    }

    @Override
    public void onItemClick(View v, int position) {
        String type = String.valueOf(((TextView)(v.findViewById(R.id.typeSelectTv))).getText());

        if(type.equals(COLOR_BLACK)) {
            showProduct(type);
        } else if(type.equals(COLOR_GRAY)) {
            showProduct(type);

    }}


        public ArrayList<Item> GetCOLORList(String color){
        for(int i=0; i<arrayList.size();i++){
if (arrayList.get(i).getColor().equals(color)){
    colorList.add(arrayList.get(i));
}}
        return colorList;}


        public ArrayList<Item> GetItemList(){


        return arrayList;}

}

