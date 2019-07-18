package com.example.a7md7.dosageprototype;

import android.content.pm.ActivityInfo;
import android.preference.CheckBoxPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.xw.repo.BubbleSeekBar;

public class MainActivity extends AppCompatActivity {

    public int age = 0;

    int[] treatmentImages = {R.drawable.dexamethasone, R.drawable.encephalitis};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(treatmentImages[position]);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);


        final CarouselView carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(treatmentImages.length);
        carouselView.stopCarousel();


        carouselView.setImageListener(imageListener);
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {

                Toast.makeText(MainActivity.this, "you clicked me" + position, Toast.LENGTH_SHORT).show();
                // do an action

            }
        });
// age seekBar
        BubbleSeekBar bubbleSeekBar = findViewById(R.id.bubbleSeekBar);

        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                TextView txt = findViewById(R.id.age_txt);
                txt.setText("patient's Age is " + progress);
                age = progress;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });
// weight seekBar
        BubbleSeekBar weightSeekBar = findViewById(R.id.weightSeekBar);
        weightSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                TextView weightTxt = findViewById(R.id.weight_txt);
                weightTxt.setText("patient's weight is " + progress);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        Button dosage = findViewById(R.id.dosageBtn);
        final CheckBox diabetes = findViewById(R.id.diabetes);
        dosage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diabetes.isChecked()) {
                    Toast.makeText(MainActivity.this, "diabetes is checked", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
