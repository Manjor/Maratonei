package com.example.manoel.maratoneia1.Series;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manoel.maratoneia1.R;

public class SerieHolder extends RecyclerView.ViewHolder {

    private TextView serieName;
    private ImageView serieBackdrop;
    private ImageButton serieLike;
    private ImageButton serieShare;

    public SerieHolder(View itemView) {
        super(itemView);
        serieName = itemView.findViewById(R.id.serieNameFrag);
        serieBackdrop = itemView.findViewById(R.id.serieBackdropFrag);
        this.serieLike = itemView.findViewById(R.id.serieLike);
        this.serieShare = itemView.findViewById(R.id.serieShare);
    }

    public TextView getSerieName() {
        return serieName;
    }

    public void setSerieName(TextView serieName) {
        this.serieName = serieName;
    }

    public ImageView getSerieBackdrop() {
        return serieBackdrop;
    }

    public void setSerieBackdrop(ImageView serieBackdrop) {
        this.serieBackdrop = serieBackdrop;
    }

    public ImageButton getSerieLike() {
        return serieLike;
    }

    public void setSerieLike(ImageButton serieLike) {
        this.serieLike = serieLike;
    }

    public ImageButton getSerieShare() {
        return serieShare;
    }

    public void setSerieShare(ImageButton serieShare) {
        this.serieShare = serieShare;
    }
}
