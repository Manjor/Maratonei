package com.example.manoel.maratoneia1;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permissions {

    public static boolean validPermission(String[] permissions, Activity activity, int requestCode){

        if (Build.VERSION.SDK_INT >= 23 ){

            List<String> listPermissions = new ArrayList<>();


            for ( String permissao : permissions ){
                Boolean temPermissao = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED;
                if ( !temPermissao ) listPermissions.add(permissao);
            }

            if ( listPermissions.isEmpty() ) return true;
            String[] novasPermissoes = new String[ listPermissions.size() ];
            listPermissions.toArray( novasPermissoes );

            ActivityCompat.requestPermissions(activity, novasPermissoes, requestCode );

        }

        return true;

    }
}
