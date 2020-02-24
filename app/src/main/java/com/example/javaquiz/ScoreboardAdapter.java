package com.example.javaquiz;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ScoreboardAdapter extends RecyclerView.Adapter<ScoreboardAdapter.ViewHolder>{
    private List<Score> scoreList;

    public ScoreboardAdapter(List<Score> myScoreList) {
        scoreList = myScoreList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new  ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

            holder.idView.setText(Integer.toString(position+1)+".");
            holder.nameView.setText(scoreList.get(position).name);
            holder.scoreView.setText(Integer.toString(scoreList.get(position).score));

    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

     static class ViewHolder extends RecyclerView.ViewHolder {
        TextView idView;
        TextView nameView;
        TextView scoreView;
        ViewHolder(View itemView) {
            super(itemView);
            idView = itemView.findViewById(R.id.itemID);
            nameView = itemView.findViewById(R.id.itemName);
            scoreView = itemView.findViewById(R.id.itemScore);
        }
}
}