package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

public class FragmentRunning extends Fragment {
View v;
LottieAnimationView lottieAnimationView;
Button mgo;
    public FragmentRunning() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.fragmentrun,container,false);
       mgo=v.findViewById(R.id.gobtn);
      lottieAnimationView=v.findViewById(R.id.lottie);

      lottieAnimationView.setAnimation("clock.json");
       lottieAnimationView.loop(true);
       lottieAnimationView.playAnimation();

       mgo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getActivity(),ChronoActivity.class));
           }
       });

        return v;
    }



}


