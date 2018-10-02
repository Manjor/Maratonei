package com.example.manoel.maratoneia1.Series;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manoel.maratoneia1.R;

public class SerieHolder extends RecyclerView.ViewHolder {

    private TextView serieName;
    private ImageView serieBackdrop;

    public SerieHolder(View itemView) {
        super(itemView);
        serieName = itemView.findViewById(R.id.serieBackdropFrag);
        serieBackdrop = itemView.findViewById(R.id.serieNameFrag);
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
}
