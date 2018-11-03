package com.example.manoel.maratoneia1.News;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataMovie.manoel.maratoneia1.R;

public class NewHolder extends RecyclerView.ViewHolder {

    private ImageView newImageProfile;
    private TextView newTitle;
    private TextView newDate;
    private ImageView newImage;
    private TextView newDescription;

    public NewHolder(View itemView) {
        super(itemView);

        newImageProfile = itemView.findViewById(R.id.newImageProfile);
        newTitle = itemView.findViewById(R.id.newTitle);
        newDate = itemView.findViewById(R.id.newDate);
        newImage = itemView.findViewById(R.id.newMedia);
        newDescription = itemView.findViewById(R.id.newDescription);
    }

    public ImageView getNewImageProfile() {
        return newImageProfile;
    }

    public void setNewImageProfile(ImageView newImageProfile) {
        this.newImageProfile = newImageProfile;
    }

    public TextView getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(TextView newTitle) {
        this.newTitle = newTitle;
    }

    public TextView getNewDate() {
        return newDate;
    }

    public void setNewDate(TextView newDate) {
        this.newDate = newDate;
    }

    public ImageView getNewImage() {
        return newImage;
    }

    public void setNewImage(ImageView newImage) {
        this.newImage = newImage;
    }

    public TextView getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(TextView newDescription) {
        this.newDescription = newDescription;
    }
}
