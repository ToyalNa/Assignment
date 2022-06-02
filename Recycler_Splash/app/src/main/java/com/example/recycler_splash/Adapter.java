package com.example.recycler_splash;


import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Phone>PhoneList = new ArrayList<>();

    public Adapter(List<Phone> phonetList) {
        PhoneList = phonetList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imgView.setImageResource(PhoneList.get(position).getImgID());
        holder.tvView.setText(PhoneList.get(position).getName());
        holder.tvphone.setText(PhoneList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return PhoneList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        ImageView imgView;
        TextView tvView;
        TextView tvphone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.img_std);
            tvView = itemView.findViewById(R.id.tV_std);
            tvphone = itemView.findViewById(R.id.tV_phone);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Select Any One");
            contextMenu.add(getAdapterPosition(),101,0,"Add");
            contextMenu.add(getAdapterPosition(),102,2,"Delete");
        }
    }
    public void RemoveItem(int position){
        PhoneList.remove(position);
        notifyDataSetChanged();
    }
}
