//package com.example.manoel.maratoneia1;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.design.widget.BottomSheetBehavior;
//import android.support.design.widget.BottomSheetDialog;
//import android.support.design.widget.BottomSheetDialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.dataMovie.manoel.maratoneia1.R;
//import com.example.manoel.maratoneia1.ResultsMovie.Result;
//import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.MovieDetail;
//
//public class BottomSheetDetails extends BottomSheetDialog {
//
//    private TextView movieTitle = null;
//    private TextView overView = null;
//    public BottomSheetDetails(@NonNull Context context) {
//        super(context);
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        View layout = getLayoutInflater().inflate(R.layout.bottomsheet_overview,null);
//        this.movieTitle = layout.findViewById(R.id.sheetTitle);
//        this.movieTitle = layout.findViewById(R.id.textView9);
//        setContentView(layout);
//    }
//}
