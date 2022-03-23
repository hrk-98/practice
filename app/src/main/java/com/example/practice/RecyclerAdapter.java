package com.example.practice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>{

    MainActivity mainActivity;
    List<StudentData> dataList;


    public RecyclerAdapter(MainActivity mainActivity, List<StudentData> dataList) {
        this.dataList=dataList;
        this.mainActivity=mainActivity;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mainActivity).inflate(R.layout.list_item,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, int position) {
        holder.id.setText("ID :"+dataList.get(position).id+"");
        holder.name.setText("Name :"+dataList.get(position).name);
        holder.surname.setText("Surname :"+dataList.get(position).surname);
        holder.std.setText("Std :"+dataList.get(position).std);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        public TextView id,name,surname,std;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            surname=itemView.findViewById(R.id.surname);
            std=itemView.findViewById(R.id.std);
        }
    }
}
