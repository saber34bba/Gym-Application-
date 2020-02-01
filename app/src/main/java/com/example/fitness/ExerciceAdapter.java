package com.example.fitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class ExerciceAdapter extends RecyclerView.Adapter<ExerciceAdapter.BodyViewHolder>{
     private int pos=-1;
    private String part;
    private RecyclerView recyclerView;
    private List<ExerciceModel> exerciceModels;
private  Context context;


    public ExerciceAdapter(Context c, List<ExerciceModel> exerciceModels, RecyclerView recyclerView) {
        this.context=c;
        this.recyclerView=recyclerView;
        this.exerciceModels = exerciceModels;
    }

    @NonNull
    @Override
    public BodyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercicelayout, parent, false);
        return new BodyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciceAdapter.BodyViewHolder holder, int position) {
        final ExerciceModel exerciceModel =exerciceModels.get(position);
        holder.title.setText(exerciceModel.getTitle());
        holder.nb.setText(String.valueOf(exerciceModel.getNb()));

    }


    @Override
    public int getItemCount() {
        return exerciceModels.size();
    }

    class BodyViewHolder extends RecyclerView.ViewHolder {
        TextView title,nb;
        RelativeLayout relativeLayout;
        CardView cardView;
        BodyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.titleofExercice);
            nb = view.findViewById(R.id.nbExercice);
        }
    }

}