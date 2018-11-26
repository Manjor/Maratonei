package com.example.manoeltoj.maratoneikotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class WelcomeActivity: AppCompatActivity(),View.OnClickListener{


    lateinit var btnEnter: Button

    companion object {
        val ARQUIVO_PREFERENCIA:String = "ArquivoPreferencia"
    }
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        var preferences:SharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,MODE_PRIVATE)
        if(preferences.contains("intro")){
            var intent:Intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }else{
            setContentView(R.layout.activity_welcome)
            btnEnter = findViewById(R.id.btnAccess)
            btnEnter.setOnClickListener(this)
        }

        setContentView(R.layout.activity_welcome)
    }

    override fun onClick(v: View?) {
        var preferences:SharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,MODE_PRIVATE)
        var editor:SharedPreferences.Editor = preferences.edit()
        editor.putBoolean("intro",true)
        editor.commit()
        var intent:Intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }

}
