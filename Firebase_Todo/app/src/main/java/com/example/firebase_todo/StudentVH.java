package com.example.firebase_todo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentVH extends RecyclerView.ViewHolder{
    public TextView txtName,txtMSV,txtOption;
    public ImageView imageView;
    public StudentVH(@NonNull View itemView)
    {
        super(itemView);
        imageView=itemView.findViewById(R.id.img_SV);
        txtName = itemView.findViewById(R.id.txt_name);
        txtMSV = itemView.findViewById(R.id.txt_msv);
        txtOption = itemView.findViewById(R.id.txt_option);
    }
}
