package com.example.manoel.maratoneia1.ResultsMovie.detailsMovie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataMovie.manoel.maratoneia1.R;

public class HolderPeople extends RecyclerView.ViewHolder {

    private ImageView imageProfile = null;
    private TextView movieName = null;
    private TextView realName = null;

    public HolderPeople(@NonNull View itemView) {
        super(itemView);
        imageProfile = itemView.findViewById(R.id.imageProfile);
        movieName = itemView.findViewById(R.id.textMovieName);
        realName = itemView.findViewById(R.id.textRealName);
    }

    public ImageView getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(ImageView imageProfile) {
        this.imageProfile = imageProfile;
    }

    public TextView getMovieName() {
        return movieName;
    }

    public void setMovieName(TextView movieName) {
        this.movieName = movieName;
    }

    public TextView getRealName() {
        return realName;
    }

    public void setRealName(TextView realName) {
        this.realName = realName;
    }
}
