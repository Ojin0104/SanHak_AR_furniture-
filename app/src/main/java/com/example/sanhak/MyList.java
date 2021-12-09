package com.example.sanhak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyList extends Fragment implements ItemClickListener2{

    private View view;
    private FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private ArrayList<zzim> arrayList=new ArrayList<>();
    private ArrayList<zzim> zData=new ArrayList<>();
    private zzimadapter zAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_good_list,container, false);

        mDatabase = FirebaseDatabase.getInstance();
        databaseReference = mDatabase.getReference("zzim");//데이터 베이스

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                arrayList.clear();

                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    zzim zim = snapshot.getValue(zzim.class);//
                    arrayList.add(zim);


                }
                zAdapter.notifyDataSetChanged();//iAdapter에 값전달
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }


        });


       showzzim();
        return view;
    }
    private void showzzim() {//전체상품보여주기 이쪽건들여서 가구 종류 클릭시 만들기


        zData=GetList();//여기서는 pData에 없는상태 setAdapter후에 onDataChange가 돔



        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = view.findViewById(R.id.zzimRecycler);
        recyclerView.setLayoutManager(layoutManager);
        zAdapter=new zzimadapter(zData,this);
        recyclerView.setAdapter(zAdapter);

    }
    public ArrayList<zzim> GetList(){
        return arrayList;
    }


    @Override
    public void onItemClick(View v, int position) {

        databaseReference=FirebaseDatabase.getInstance().getReference();
        databaseReference.child("zzim").child(arrayList.get(position).getName()).setValue(null);
        zData.remove(position);
        zAdapter.updateData(zData);
    }
}