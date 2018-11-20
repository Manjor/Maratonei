package com.example.manoel.maratoneia1.News;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dataMovie.manoel.maratoneia1.R;

import java.util.ArrayList;
import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewHolder>
{
    List<New> newList = new ArrayList<>();


    public NewAdapter(List<New> newList){
        this.newList = newList;
    }


    @NonNull
    @Override
    public NewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_card,parent,false);

        return new NewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull NewHolder holder, int position) {
        New news = newList.get(position);
        //holder.getNewImageProfile().setImageDrawable();
        holder.getNewAutor().setText(news.getNewAutor());
        holder.getNewTitle().setText(news.getNewTitle());
        holder.getNewDate().setText(news.getNewDate());
        holder.getNewDescription().setText(news.getNewDesc());
    }

    @Override
    public int getItemCount() {
        return  this.newList.size();
    }
}
