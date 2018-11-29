package com.example.manoel.maratoneia1.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class DataBaseOffline extends SQLiteOpenHelper {

    Context context = null;

    String[] createBD = {
            "create table movieintro(_id integer primary key autoincrement, title text not null, backdrop text, idmovie integer)",
            "create table serieintro(_id integer primary key autoincrement, name text not null, poster text, idserie integer)",
    };

    private final String scriptDropMovie = "DROP TABLE IF EXISTS movieintro";
    private final String scriptDropSerie = "DROP TABLE IF EXISTS serieintro";
    private ArrayList<MovieIntro> movies = null;
    private ArrayList<SerieIntro> series = null;

    /**
     * Constructor of the class is necessary
     * Context of activity
     * Name of database
     * Version 1*/
    public DataBaseOffline(Context context, String name, int version){
        super(context,name,null,version);
        this.context = context;
    }

    /**
     * DataBase*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        for(int iIndex = 0; iIndex < createBD.length; iIndex++){
            db.execSQL(createBD[iIndex]);
        }
    }
    public void clearMovies(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(this.scriptDropMovie);
        database.execSQL(createBD[0]);
    }
    public void clearSeries(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(this.scriptDropSerie);
        database.execSQL(createBD[1]);
    }
    public void insertMovieIntro(ContentValues movieintro){
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert("movieintro",null,movieintro);
    }
    public void insertSerieIntro(ContentValues serieinto){
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert("serieintro",null,serieinto);
    }

    public ArrayList<MovieIntro> getItensMovieIntro(){
        ArrayList<MovieIntro> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query("movieintro",new String[]{"title","backdrop","idmovie"},null,null,null,null,null);
        while (cursor.moveToNext()){
            list.add(new MovieIntro(cursor.getString(0),cursor.getString(1),cursor.getInt(2)));
        }
        return list;
    }
    public ArrayList<SerieIntro> getItensSerieIntro(){
        ArrayList<SerieIntro> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query("serieintro",new String[]{"name","poster","idserie"},null,null,null,null,null);
        while (cursor.moveToNext()){
            list.add(new SerieIntro(cursor.getString(0),cursor.getString(1),cursor.getInt(2)));
        }
        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptDropMovie);
        db.execSQL(scriptDropSerie);
    }
}
