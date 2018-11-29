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

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewFragment extends Fragment implements ValueEventListener  {

    private View view;
    private RecyclerView recyclerView;
    static List<New> newList;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    public int i = 0;

    String title;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news,container,false);

        recyclerView = view.findViewById(R.id.recyclerNew);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        if (MainActivity.CONNECTION == false) {

        }else{
            DatabaseReference news = reference.child("new");
            news.addListenerForSingleValueEvent(this);
        }
        return view;

    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int i;
        this.newList = new ArrayList<>();
        for (i = 1; i <= dataSnapshot.getChildrenCount(); i++) {

            String pos = String.valueOf(i);
            String autor = dataSnapshot.child(pos).child("autor").getValue().toString();
            String title = dataSnapshot.child(pos).child("title").getValue().toString();
            String description = dataSnapshot.child(pos).child("description").getValue().toString();
            String date = dataSnapshot.child(pos).child("date").getValue().toString();
            String id = dataSnapshot.child(pos).child("id").getValue().toString();
            this.addList(autor,title,description,date);

        }
        NewAdapter newAdapter = new NewAdapter(this.newList);
        recyclerView.setAdapter(newAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    public void addList(String autor,String title,String description, String date){
        this.newList.add(new New(autor,title,date,description,"SEM IMAGEM"));
    }
}
