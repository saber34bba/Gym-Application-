package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Resource;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FirstActivity extends AppCompatActivity {
Button signup,signin;
ImageView imageView;
    String s="http://192.168.56.1/FitnessImg/homme/PEC/debutant/pompe a une main.jpg";

    BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        signin=findViewById(R.id.signinbtn);
        signup=findViewById(R.id.signupbtn);
        imageView=findViewById(R.id.l);

      /*  final View bottomdesign = findViewById(R.id.regist);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomdesign);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
*/
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }*/

             Intent i=new Intent(FirstActivity.this,SignUp.class);
           startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i=new Intent(FirstActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }

}
