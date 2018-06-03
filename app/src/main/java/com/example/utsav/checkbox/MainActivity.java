package com.example.utsav.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataAdapter.PostsAdapterListener {
private RecyclerView recyclerView;
private TextView textView;
private ArrayList<UserData> dataArrayList;
private ArrayList<String> stringArrayList;
    DataAdapter radiosDataAdapter;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataArrayList=new ArrayList<>();
        stringArrayList=new ArrayList<>();
        recyclerView=findViewById(R.id.rvData);
        textView=findViewById(R.id.text);
        button=findViewById(R.id.button);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        createDummyData();
         radiosDataAdapter = new DataAdapter(this, dataArrayList,this);
        recyclerView.setAdapter(radiosDataAdapter);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (UserData user : dataArrayList) {
                    user.setSelected(false);
                    radiosDataAdapter.notifyDataSetChanged();

                }

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <dataArrayList.size() ; i++) {
                    if (dataArrayList.get(i).getSelected()){
                        Log.d("check"," "+dataArrayList.get(i).getName());
                    }
                }
            }
        });
    }
    private void createDummyData() {
        for (int i = 0; i < 6; i++) {



            UserData whatsapp = new UserData();
            whatsapp.setName("utsav shah"+i);
            whatsapp.setSelected(false);

            dataArrayList.add(whatsapp);

        }
    }

    @Override
    public void onPostClicked(UserData post) {
        if (post.getSelected()){

        }else {

        }
        Log.d("data"," "+post.getName()+" "+post.getSelected());

    }
}
