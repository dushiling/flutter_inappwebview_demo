package com.example.flutter_inappwebview_demo

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import io.flutter.Log
import io.flutter.embedding.android.FlutterActivity

class MainActivity: FlutterActivity() {

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String?>,
            grantResults: IntArray
    ) {
        when (requestCode) {
            100 -> {
                if (grantResults.size > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        val pref1 = getSharedPreferences("data", MODE_PRIVATE)
                        val account = pref1.getBoolean("hasDENIED", false)
                        //是否已经被拒绝了
                        if (account) {
                            val settingsIntent = Intent()
                            settingsIntent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                            settingsIntent.addCategory(Intent.CATEGORY_DEFAULT)
                            settingsIntent.data = Uri.parse("package:" + activity.packageName)
                            settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                            settingsIntent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                            startActivity(settingsIntent)
                        }else{
                            pref1.edit().putBoolean("hasDENIED", true).commit()
                        }
                        Log.d("JumpChannel", "被拒绝了")
                    }
                    // 权限被用户同意，可以做你要做的事情了。
                } else {
                    // 权限被用户拒绝了，可以提示用户,关闭界面等等。

                }
                return
            }
        }
    }
}
