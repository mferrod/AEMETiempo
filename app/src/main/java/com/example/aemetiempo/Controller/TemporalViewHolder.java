package com.example.aemetiempo.Controller;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aemetiempo.R;

public class TemporalViewHolder extends RecyclerView.ViewHolder {

    final TemporalAdapter mAdapter;
    private TextView tvMax;
    private TextView tvMin;
    private TextView tvDay;
    //private ImageView ivTiempo;

    public TemporalViewHolder(View itemView, TemporalAdapter adapter) {
        super(itemView);

        //ivTiempo = itemView.findViewById(R.id.imagenTiempo);
        tvDay = itemView.findViewById(R.id.tvDia);
        tvMax = itemView.findViewById(R.id.tvMaxima);
        tvMin = itemView.findViewById(R.id.tvMinima);
        this.mAdapter = adapter;
    }

    public void setDay(String data) {
        tvDay.setText(data);
    }

    public void setMax(String data) {
        tvMax.setText(data);
    }

    public void setMin(String data) {
        tvMin.setText(data);
    }
}
