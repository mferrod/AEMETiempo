package com.example.aemetiempo.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aemetiempo.Model.Tiempo;
import com.example.aemetiempo.R;

import java.util.LinkedList;

public class TemporalAdapter extends RecyclerView.Adapter<TemporalViewHolder> {
    private final LinkedList<Tiempo> mList;
    private LayoutInflater mInflater;

    public TemporalAdapter(Context context,
                          LinkedList<Tiempo> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }


    @NonNull
    @Override
    public TemporalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycler_activity,
                parent, false);
        return new TemporalViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull TemporalViewHolder holder, int position) {
        //TODO: fill data
        holder.setDay(this.mList.get(position).getDiaSemana());
        holder.setMax(this.mList.get(position).getMaxima());
        holder.setMin(this.mList.get(position).getMinima());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
}
