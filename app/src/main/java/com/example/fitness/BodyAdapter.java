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

public class BodyAdapter extends RecyclerView.Adapter<BodyAdapter.BodyViewHolder>{
     private int pos=-1;
    private String part;
    private RecyclerView recyclerView;
    private List<BodyModel> bodylist;
private  Context context;
    private BodyInteraction bodyInteraction;


    public BodyAdapter(Context c, List<BodyModel> bodylist, RecyclerView recyclerView,BodyInteraction bodyInteraction) {
        this.context=c;
        this.bodyInteraction=bodyInteraction;
        this.recyclerView=recyclerView;
        this.bodylist = bodylist;
    }

    @NonNull
    @Override
    public BodyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bodylayout, parent, false);
        return new BodyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BodyAdapter.BodyViewHolder holder, int position) {
        final BodyModel bd_model=bodylist.get(position);
        holder.partname.setText(bd_model.getPartName());
        holder.nb.setText(String.valueOf(bd_model.getNb()));

        holder.cardView.animate()
                .scaleX(0.8f)
                .scaleY(0.8f)
                .setStartDelay(100)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(450)
                .start();
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



               if(pos==-1) {
                   holder.cardView.animate()
                           .scaleX(1.1f)
                           .scaleY(1.1f)
                           .setStartDelay(100)
                           .setInterpolator(new FastOutSlowInInterpolator())
                           .setDuration(450)
                           .start();
                   bodyInteraction.partinteraction(holder.partname.getText().toString(),1);
                   part=holder.partname.getText()
                           .toString();
                   pos = position;

               }
               else {
                   View v=  Objects.requireNonNull(recyclerView.getLayoutManager()).findViewByPosition(pos);

                   v.animate()
                           .scaleX(0.8f)
                           .scaleY(0.8f)
                           .setStartDelay(100)
                           .setInterpolator(new FastOutSlowInInterpolator())
                           .setDuration(450)
                           .start();
                   bodyInteraction.partinteraction(part,0);

                   if(pos!=position)
                   {
                       holder.cardView.animate()
                               .scaleX(1.1f)
                               .scaleY(1.1f)
                               .setStartDelay(100)
                               .setInterpolator(new FastOutSlowInInterpolator())
                               .setDuration(450)
                               .start();
                       pos = position;
                       part=holder.partname.getText().toString();
                       bodyInteraction.partinteraction(holder.partname.getText().toString(),1);

                   }
                   else {
                       pos=-1;

                   }

               }


            }
        });
        if(position%2==0)
        {

            holder.cardView.getResources().getColor(R.color.colorg);
        }
    }


    @Override
    public int getItemCount() {
        return bodylist.size();
    }

    class BodyViewHolder extends RecyclerView.ViewHolder {
        TextView partname,nb;
        RelativeLayout relativeLayout;
        CardView cardView;
        BodyViewHolder(View view) {
            super(view);
            cardView=view.findViewById(R.id.cardrecycler);
            partname = view.findViewById(R.id.partname);
            nb = view.findViewById(R.id.totalexercicenumber);
        }
    }

}