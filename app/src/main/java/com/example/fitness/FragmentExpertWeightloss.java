package com.example.fitness;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class FragmentExpertWeightloss extends Fragment {
View v;
Button fitness;
CardView cardView;
ImageView imageView;
    BottomSheetBehavior bottomSheetBehavior;

ImageView imageViewweight;
    private List<ExerciceModel> exerciceModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private ExerciceAdapter exerciceAdapter;
    private ExerciceModel exerciceModel;
    TextView objective;
    String partname;
    public FragmentExpertWeightloss() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.weightloss_expert,container,false);



        objective=v.findViewById(R.id.objective);

/*
        final View bottomdesign = v.findViewById(R.id.dialoglayout);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomdesign);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
*/
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

        if(partname.equalsIgnoreCase("chest")) {
            exerciceModel = new ExerciceModel("pompe Spiderman", "20", "4");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("pompe a une main", "10", "4");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("pompe prise moyenne", "25", "5");
            exerciceModels.add(exerciceModel);
        }

        if(partname.equalsIgnoreCase("Abs")) {

            exerciceModel = new ExerciceModel("Sit-Up", "20");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("Russian twiste", "20");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("Crunch inverse lateral", "20");
            exerciceModels.add(exerciceModel);

            exerciceModel = new ExerciceModel("marche en aire", "30 Sec");
            exerciceModels.add(exerciceModel);

            exerciceModel = new ExerciceModel("Mountain climber out", "20");
            exerciceModels.add(exerciceModel);

            exerciceModel = new ExerciceModel("Mountain climber in", "20");
            exerciceModels.add(exerciceModel);

            exerciceModel = new ExerciceModel("Kick out", "20");
            exerciceModels.add(exerciceModel);

            exerciceModel = new ExerciceModel("Comandos", "30 Sec");
            exerciceModels.add(exerciceModel);

            exerciceModel = new ExerciceModel("Twiste planche latéral", "30 + 30 Sec");
            exerciceModels.add(exerciceModel);
        }

        if(partname.equalsIgnoreCase("Upper Legs")) {
            exerciceModel = new ExerciceModel("Fente charge marche", "20", "4");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("Squat Saut", "20", "4");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("Box Jump", "20", "4");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("Gainage Chaise", "1 min", "4");
            exerciceModels.add(exerciceModel);
        }

        if(partname.equalsIgnoreCase("Lower Legs")) {
            exerciceModel = new ExerciceModel("Extension debout", "20", "5");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("Extension debout 1 pied", "5+1", "10");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("Extension debout écarté", "5+1", "10");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("Extension debout Saut", "3+1", "10");
            exerciceModels.add(exerciceModel);
        }


        if(partname.equalsIgnoreCase("Shoulders")) {
            exerciceModel = new ExerciceModel("pompe militaire", "10", "4");
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("elevation frontal supination", "15","3" );
            exerciceModels.add(exerciceModel);
            exerciceModel = new ExerciceModel("elevation frontal", "15", "3");
            exerciceModels.add(exerciceModel);

            exerciceModel = new ExerciceModel("elevation latéral", "15","3" );
            exerciceModels.add(exerciceModel);

        }



        exerciceAdapter =new ExerciceAdapter(getActivity(), exerciceModels, recyclerView);
      recyclerView.setAdapter(exerciceAdapter);

      objective.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              showexercice();
             /* if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
                  bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
              }else{
                  bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
              }*/
          }
      });
        return v;


    }


Dialog exerciceDialog;
    private void showexercice()
    {
        exerciceDialog = new Dialog(getActivity(), R.style.Theme_CustomDialog);
        exerciceDialog.setCancelable(true);
        exerciceDialog.setTitle("");
        exerciceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        exerciceDialog.setContentView(R.layout.dialoglayout);
        //prod_img=(ImageView)exerciceDialog.findViewById(R.id.img_product);
        //mbuy=(Button)exerciceDialog.findViewById(R.id.buy_btnview);
        //total=(TextView)exerciceDialog.findViewById(R.id.somme_price);
        //multiprice=(TextView)exerciceDialog.findViewById(R.id.multi_price);


        WindowManager.LayoutParams layoutParamss = new WindowManager.LayoutParams();
        layoutParamss.copyFrom(exerciceDialog.getWindow().getAttributes());

        layoutParamss.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParamss.height =WindowManager.LayoutParams.MATCH_PARENT;

        exerciceDialog.getWindow().setAttributes(layoutParamss);

        exerciceDialog.show();





    }

}
