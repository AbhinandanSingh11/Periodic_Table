package com.abhinandan.periodictable.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.abhinandan.periodictable.Adapters.AdapterRecyclerView;
import com.abhinandan.periodictable.Adapters.AdapterValue;
import com.abhinandan.periodictable.AppData.AppData;
import com.abhinandan.periodictable.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class InfoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterValue adapter;
    private TextView symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getWindow().setStatusBarColor(getResources().getColor(R.color.pink,getTheme()));

        recyclerView = findViewById(R.id.recylerviewValues);
        symbol = findViewById(R.id.nameElement);

        symbol.setText(AppData.getInstance().getValues().get(1));


        setUp();
    }

    void setUp(){
        adapter = new AdapterValue(InfoActivity.this);
        RecyclerView.LayoutManager manager = new GridLayoutManager(InfoActivity.this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
