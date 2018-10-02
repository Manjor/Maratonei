package com.example.manoel.prototipomaratonei.HoldersFragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manoel.prototipomaratonei.R;

public class SeriesHolder extends RecyclerView.ViewHolder {

    private ImageView imgSerie;
    private TextView txtSerie;

    public SeriesHolder(View itemView) {
        super(itemView);

        this.imgSerie =  (ImageView) itemView.findViewById(R.id.imgSerie);
        this.txtSerie = (TextView) itemView.findViewById(R.id.txtSerie);

    }

    public ImageView getImgSerie() {
        return imgSerie;
    }

    public void setImgSerie(ImageView imgSerie) {
        this.imgSerie = imgSerie;
    }

    public TextView getTxtSerie() {
        return txtSerie;
    }

    public void setTxtSerie(TextView txtSerie) {
        this.txtSerie = txtSerie;
    }
}
