package com.example.demoproject;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {

    private Context context;
    private List<DataClass> dataList;
    public static class Viewholder extends RecyclerView.ViewHolder{
        public TextView a1,a2,a3,a4,a5;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            a1=itemView.findViewById(R.id.a1);
            a2=itemView.findViewById(R.id.a2);
            a3=itemView.findViewById(R.id.a3);
            a4=itemView.findViewById(R.id.a4);
            a5=itemView.findViewById(R.id.a5);
        }
    }

    public RecyclerViewAdapter(Context context, List<DataClass> imagelist) {
        this.context = context;
        this.dataList = imagelist;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.recycleview,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        DataClass d1=dataList.get(position);
        holder.a1.setText(d1.getA1());
        holder.a2.setText(d1.getA2());
        holder.a3.setText(d1.getA3());
        holder.a4.setText(d1.getA4());
        holder.a5.setText(d1.getA5());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}


