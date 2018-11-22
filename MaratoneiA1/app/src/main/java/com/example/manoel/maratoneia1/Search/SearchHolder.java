package com.example.manoel.maratoneia1.Search;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.dataMovie.manoel.maratoneia1.R;

public class SearchHolder extends RecyclerView.ViewHolder {
    private ImageView posterPath = null;

    public SearchHolder(@NonNull View itemView) {
        super(itemView);
        posterPath = itemView.findViewById(R.id.posterSearch);
    }

    public ImageView getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(ImageView posterPath) {
        this.posterPath = posterPath;
    }
}
