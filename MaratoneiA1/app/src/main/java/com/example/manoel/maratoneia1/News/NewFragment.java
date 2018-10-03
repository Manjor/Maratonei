package com.example.manoel.maratoneia1.News;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manoel.maratoneia1.R;

import java.util.ArrayList;
import java.util.List;

public class NewFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<New> newList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new,container,false);

        recyclerView = view.findViewById(R.id.recycleNew);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        this.newList.add(new New("Sem Imagem","Novidade em Capitã Marvel","10 de Outubro de 2018","Vazou fotos do set de gravações de capitã marvel","SEM IMAGEM"));
        this.newList.add(new New("Sem Imagem","Novidade em ","10 de Outubro de 2018","Vazou fotos do set de gravações de capitã marvel","SEM IMAGEM"));
        this.newList.add(new New("Sem Imagem","Novidade em ","11 de Outubro de 2018","Vazou fotos do set de ","SEM IMAGEM"));
        this.newList.add(new New("Sem Imagem","Novidade em ","12 de Outubro de 2018","Vazou fotos do set de ","SEM IMAGEM"));
        this.newList.add(new New("Sem Imagem","Novidade em ","13 de Outubro de 2018","Vazou fotos do set de ","SEM IMAGEM"));
        this.newList.add(new New("Sem Imagem","Novidade em ","14 de Outubro de 2018","Vazou fotos do set de ","SEM IMAGEM"));
        this.newList.add(new New("Sem Imagem","Novidade em ","15 de Outubro de 2018","Vazou fotos do set de ","SEM IMAGEM"));
        this.newList.add(new New("Sem Imagem","Novidade em ","16 de Outubro de 2018","Vazou fotos do set de ","SEM IMAGEM"));


        NewAdapter newAdapter = new NewAdapter(this.newList);
        recyclerView.setAdapter(newAdapter);

        return view;
    }
}
