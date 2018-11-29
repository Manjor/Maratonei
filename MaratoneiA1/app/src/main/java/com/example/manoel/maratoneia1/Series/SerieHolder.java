package com.example.manoel.maratoneia1.Series;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataMovie.manoel.maratoneia1.R;

public class SerieHolder extends RecyclerView.ViewHolder {

    private TextView serieName;
    private ImageView seriePosterPath;

    public SerieHolder(View itemView) {
        super(itemView);
        seriePosterPath = itemView.findViewById(R.id.imageSerie);
    }

    public TextView getSerieName() {
        return serieName;
    }

    public void setSerieName(TextView serieName) {
        this.serieName = serieName;
    }

    public ImageView getSeriePosterPath() {
        return seriePosterPath;
    }

    public void setSeriePosterPath(ImageView seriePosterPath) {
        this.seriePosterPath = seriePosterPath;
    }

}
