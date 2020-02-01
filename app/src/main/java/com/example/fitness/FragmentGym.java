package com.example.fitness;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class FragmentGym extends Fragment {
View v;
Button fitness,beginExercice_btn;
CardView cardView;
ImageView imageView;
String part="";
    BottomSheetBehavior bottomSheetBehavior;
    private List<BodyModel> bodypartlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private BodyAdapter bodyAdapter;
   private BodyModel bodyModel;
ImageView imageViewweight;
    public FragmentGym() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.mainfragmentgym,container,false);
        fitness=v.findViewById(R.id.vfitnessbtn);
        imageViewweight=v.findViewById(R.id.imageweight);
        beginExercice_btn=v.findViewById(R.id.exercicebtn);

        cardView=v.findViewById(R.id.cardviewlossWeight);

        final View bottomdesign = v.findViewById(R.id.fragmentgym);
        recyclerView=v.findViewById(R.id.bodyrecyclerview);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomdesign);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        bodypartlist=new ArrayList<>();


        bodyModel=new BodyModel("Chest",8);
        bodypartlist.add(bodyModel);
         bodyModel=new BodyModel("Upper Legs",12);
        bodypartlist.add(bodyModel);

        bodyModel=new BodyModel("Forearms",115);
        bodypartlist.add(bodyModel);

        bodyModel=new BodyModel("Biceps",13);
        bodypartlist.add(bodyModel);

        bodyModel=new BodyModel("Abs",105);
        bodypartlist.add(bodyModel);

        bodyModel=new BodyModel("Shoulders",11);
        bodypartlist.add(bodyModel);


        bodyModel=new BodyModel("Lower Legs",11);
        bodypartlist.add(bodyModel);
        bodyAdapter=new BodyAdapter(getActivity(), bodypartlist, recyclerView, new BodyInteraction() {
            @Override
            public void partinteraction(String s, int i) {
                  if(i==1) {
                      beginExercice_btn.setVisibility(View.VISIBLE);
                      if (s.equalsIgnoreCase("chest"))
                      {
                          part="chest";
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.UpdatedChest);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }
                      if (s.equalsIgnoreCase("Upper Legs"))
                      {
                          part="Upper Legs";

                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.UpdatedUpperLegs);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }
                      if (s.equalsIgnoreCase("forearms"))
                      {
                          part="forearms";

                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.UpdatedForearms);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }


                      if (s.equalsIgnoreCase("biceps"))
                      {
                          part="biceps";

                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.UpdatedBiceps);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }

                      if (s.equalsIgnoreCase("abs"))
                      {
                          part="abs";
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.Updatedabs);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }

                      if (s.equalsIgnoreCase("Shoulders"))
                      {
                          part="Shoulders";

                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.Updateshoulders);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }

                      if (s.equalsIgnoreCase("Lower Legs"))
                      {
                          part="Lower Legs";
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.Updatelowerlegs);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }

                  }else {
                      beginExercice_btn.setVisibility(View.GONE);
                      part="";
                      if (s.equalsIgnoreCase("chest"))
                      {
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.DefaultChest);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }
                      if (s.equalsIgnoreCase("Upper Legs"))
                      {
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.DefaultUpperLegs);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }
                      if (s.equalsIgnoreCase("forearms"))
                      {
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.DefaultForearms);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }


                      if (s.equalsIgnoreCase("biceps"))
                      {
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.DefaultBiceps);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }

                      if (s.equalsIgnoreCase("abs"))
                      {
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.Defaultabs);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }

                      if (s.equalsIgnoreCase("Shoulders"))
                      {
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.Defaultshoulders);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }

                      if (s.equalsIgnoreCase("Lower Legs"))
                      {
                          final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.Defaultlowerlegs);
                          final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                          imageView.setImageDrawable(drawable);
                      }

                  }
            }


        });
        recyclerView.setAdapter(bodyAdapter);

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });
       imageView=v.findViewById(R.id.mus);

    /*    imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.UpdatedScene);
                final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.muscle_part, wrapper.getTheme());
                imageView.setImageDrawable(drawable);
            }
        });
*/


    beginExercice_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!part.equals(""))
            {


               Intent i=new Intent(getActivity(),WeightLossActivity.class);
                i.putExtra("part",part);
                startActivity(i);


            }
        }
    });

    cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(getActivity()!=null) {
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), imageViewweight, "image");
                Intent in = new Intent(getActivity(), WeightLossActivity.class);
                startActivity(in, activityOptionsCompat.toBundle());

            }

        }
    });


        return v;
    }





}
