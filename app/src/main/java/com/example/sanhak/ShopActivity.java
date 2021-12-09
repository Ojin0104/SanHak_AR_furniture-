package com.example.sanhak;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private static  String COLOR_TREE="나무";
    private static  String COLOR_GREEN="초록색";
    private static  String COLOR_WHITE="하얀색";


    private FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
   private ArrayList<Item> arrayList=new ArrayList<>();
    private ArrayList<Item> colorList=new ArrayList<>();
    private ArrayList<Item> AllList=new ArrayList<>();
    public RecyclerView.Adapter adapter;
    //private static GetItemDB db = null;
    public Context mContext;




    private RecyclerView recyclerView;
private String fur_type;//가구 종류결정
    private ItemAdapter iAdapter;
    private TypeAdapter tAdapter;
    private String[] tData={"검정색","회색","나무","초록색","하얀색"};
   private ArrayList<Item> iData=new ArrayList<>();
    private ArrayList<Item> pData=new ArrayList<>();
   // private GetItemDB getItem;
private View view;
//private ImageView img=findViewById(R.id.imageView)

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_shop,container, false);
        if(getArguments()!=null) {
            fur_type = getArguments().getString("fur_type");
            System.out.println("-----------------------------");
            System.out.println(fur_type);
        }


        mDatabase = FirebaseDatabase.getInstance();
        databaseReference = mDatabase.getReference("Item");//데이터 베이스 Item참조

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
               arrayList.clear();

                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Item item = snapshot.getValue(Item.class);//
                    AllList.add(item);
                    if(item.getType().equals(fur_type)) {
                        arrayList.add(item);
                    }

                }
            iAdapter.notifyDataSetChanged();//iAdapter에 값전달
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }


        });


        showTypeSelector();//색깔필터표시
        showProduct();//종류별로 상품나오게
        return view;
    }

    private void showTypeSelector(){//위에 필터 보여주는 부분

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView = view.findViewById(R.id.typeSelectRecycler);
        recyclerView.setLayoutManager(layoutManager);
        tAdapter = new TypeAdapter(tData, this);
        recyclerView.setAdapter(tAdapter);

    }
    private void showProduct() {//전체상품보여주기 이쪽건들여서 가구 종류 클릭시 만들기

        pData.clear();
        pData=GetTypeList();//여기서는 pData에 없는상태 setAdapter후에 onDataChange가 돔


            iAdapter=new ItemAdapter(pData,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = view.findViewById(R.id.productRecycler);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(iAdapter);

    }

    private void showProduct(String type){//필터에 해당하는 상품보여주기


       iData.clear();
       iData=GetCOLORList(type);
       iAdapter.updateData(iData);//update해주면서 기존 데이터지워줌
    }

    @Override
    public void onItemClick(View v, int position) {//filter 클릭시 그에맞는 product show
        String type = String.valueOf(((TextView)(v.findViewById(R.id.typeSelectTv))).getText());

        if(type.equals(COLOR_BLACK)) {
            showProduct(type);
        } else if(type.equals(COLOR_GRAY)) {
            showProduct(type);

    }
        else if(type.equals(COLOR_TREE)) {
            showProduct(type);

        }
        else if(type.equals(COLOR_GREEN)) {
            showProduct(type);

        }else if(type.equals(COLOR_WHITE)) {
            showProduct(type);

        }

    }


@Override
    public void onItemClick2(View v, int position) {//filter 클릭시 그에맞는 product show
        String name = arrayList.get(position).getName();
        String img = arrayList.get(position).getImg();
        String color = arrayList.get(position).getColor();
        String brand=arrayList.get(position).getBrand();
        Bundle bundle=new Bundle();//번들로 이름 저장후
        bundle.putString("name",name);
        bundle.putString("img",img);
        bundle.putString("color",color);
        bundle.putString("brand",brand);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        FurnitureInfo fur= new FurnitureInfo();
        fur.setArguments(bundle);
        transaction.addToBackStack(null);

        transaction.replace(R.id.main_frame,fur);

        transaction.commit();
        }



    public ArrayList<Item> GetCOLORList(String color){//색깔에 맞는 데이터 colorList로 전달
        for(int i=0; i<arrayList.size();i++){
if (arrayList.get(i).getColor().equals(color)){
    colorList.add(arrayList.get(i));
}}
        return colorList;}



        public ArrayList<Item> GetTypeList(){


        return arrayList;}

    public ArrayList<Item> GetAllList(){//다른 클래스에서 모든 데이터베이스 가져갈떄 이것 사용


        return AllList;}

        public Item GetItem(String id){//같은 Id데이터 뽑아줌

        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).getId().equals(id)){
                return arrayList.get(i);
            }
        }
        return null;
        }
}

