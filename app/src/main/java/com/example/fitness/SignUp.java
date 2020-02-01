package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class SignUp extends AppCompatActivity {
FrameLayout manfram,womanfram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        manfram=findViewById(R.id.framman);
        womanfram=findViewById(R.id.womanfram);


        manfram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                womanfram.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.imageuns, null));
                manfram.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.imageselect, null));


            }
        });


        womanfram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manfram.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.imageuns, null));
                womanfram.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.imageselect, null));

            }
        });
    }
}
