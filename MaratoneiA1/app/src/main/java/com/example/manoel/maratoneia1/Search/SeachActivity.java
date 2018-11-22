package com.example.manoel.maratoneia1.Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.Search.searchResult.ResultSearch;

import java.util.ArrayList;

public class SeachActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private SearchView searchView = null;
    private RecyclerView recyclerView = null;
    private ArrayList<ResultSearch> resultSeaches = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach);
        searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.recyclerSearch);

        searchView.setQueryHint("ResultSearch Movies and Series");
        searchView.setOnQueryTextListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager1);
        //Config Seachview



//        getSupportActionBar().show();
    }

    public void setData(ArrayList<ResultSearch> resultSeaches){
        this.resultSeaches = resultSeaches;
        AdapterSearch adapterSearch = new AdapterSearch(this.resultSeaches);
        recyclerView.setAdapter(adapterSearch);
    }
    @Override
    public boolean onQueryTextSubmit(String s) {
        SearchTask searchTask = new SearchTask(this);
        searchTask.execute(Configuracao.getSearch(s,getResources().getString(R.string.language)));
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
