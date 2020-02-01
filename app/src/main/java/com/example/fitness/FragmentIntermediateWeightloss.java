package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentIntermediateWeightloss extends Fragment {
View v;
Button fitness;
CardView cardView;
ImageView imageView;
    private List<ExerciceModel> exerciceModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private ExerciceAdapter exerciceAdapter;
    private ExerciceModel exerciceModel;
ImageView imageViewweight;
String partname;
TextView objective;
    public FragmentIntermediateWeightloss() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.weightloss_beginner,container,false);
          objective=v.findViewById(R.id.objective);





        Intent si = getActivity().getIntent();
        Bundle extras = si.getExtras();
        if (extras != null) {

            if (extras.containsKey("part")) {
                partname =si.getStringExtra("part");
                // TODO: Do something with the value of isNew.
            }
        }
        objective.setText(partname);



        recyclerView=v.findViewById(R.id.recyclerexercice);
        recyclerView.setHasFixedSize(true);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        exerciceModels=new ArrayList<>();




        return v;
    }





}
