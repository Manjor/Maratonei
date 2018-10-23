package com.example.manoeltoj.projetodefolhas;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout back ;
    ConstraintLayout midle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = findViewById(R.id.back);
        midle = findViewById(R.id.midle);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(back);
        BottomSheetBehavior bottomSheet = BottomSheetBehavior.from(midle);

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheetBehavior.setPeekHeight(200);
        bottomSheetBehavior.setHideable(false);

        bottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheet.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheet.setPeekHeight(100);
        bottomSheet.setHideable(false);
    }
}
