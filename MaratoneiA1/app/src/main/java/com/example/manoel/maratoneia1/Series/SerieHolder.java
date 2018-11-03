package com.example.manoel.maratoneia1.Series;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataMovie.manoel.maratoneia1.R;

public class SerieHolder extends RecyclerView.ViewHolder {

    private TextView serieName;
    private ImageView serieBackdrop;

    public SerieHolder(View itemView) {
        super(itemView);
        serieName = itemView.findViewById(R.id.txtSerieNameFrag);
        serieBackdrop = itemView.findViewById(R.id.serieBackdropFrag);
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
