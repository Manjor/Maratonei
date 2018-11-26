package com.example.manoeltoj.maratoneikotlin

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

class Permission {
    companion object {

        fun validPermission(permissions: Array<String>, activity: Activity, requestCode: Int): Boolean {
            if (Build.VERSION.SDK_INT >= 23) {
                var listPermission: ArrayList<String> = ArrayList()

                for (permission in permissions) {
                    var havePermission: Boolean = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
                    if (!havePermission) listPermission.add(permission)
                }
                if (listPermission.isEmpty()) return true
                var newsPermissions: Array<String> = Array(listPermission.size, { i -> (i * i).toString() })

                listPermission.toArray(newsPermissions)

                ActivityCompat.requestPermissions(activity, newsPermissions, requestCode)
            }
            return true
        }
    }
}