package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class FragmentBeginnerWeightloss extends Fragment /*implements ScrollViewListener*/{
View v;
Button fitness;
ScrollView scrollView;
ImageView imageView;
TextView objective;
CoordinatorLayout coordinatorLayout;
Context context;
String partname;
    private List<ExerciceModel> exerciceModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private ExerciceAdapter exerciceAdapter;
    private ExerciceModel exerciceModel;
String s="http://192.168.56.1/FitnessImg/homme/PEC/debutant/pompe sur genoux prise large.jpg";
    private ProgressBar progressBar;

    public FragmentBeginnerWeightloss() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.weightloss_beginner,container,false);
         scrollView=(ScrollViewpr) v.findViewById(R.id.scroll);
         objective=v.findViewById(R.id.objective);
        progressBar=v.findViewById(R.id.progressBarweight);
imageView=v.findViewById(R.id.sss);
context=getActivity();



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







        progressBar.setProgress(80);

        //((ScrollViewpr) scrollView).setScrollViewListener(this);

        coordinatorLayout=v.findViewById(R.id.cord);


        return v;
    }

/*
    @Override
    public void onScrollChanged(ScrollViewpr scrollView, int x, int y, int oldx, int oldy) {
// We take the last son in the scrollview
        View view = (View) scrollView.getChildAt(scrollView.getChildCount() - 1);
        int diff = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));

        // if diff is zero, then the bottom has been reached
        if (diff == 0) {
            // do stuff
            coordinatorLayout.setVisibility(View.GONE);
        }
    }*/
}

