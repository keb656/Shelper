package com.example.followupv3

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)


        fun isOnline():String{
            val cm: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo: NetworkInfo? = cm.activeNetworkInfo?:null

            if (networkInfo != null && networkInfo.isConnected){
                return "인터넷이 연결되었습니다"
            } else {
                return "인터넷이 연결되지 않았습니다"
            }

        }

        val background = object : Thread(){
            override fun run(){
                try {
                    Thread.sleep(5000)

                    val onlineResult = isOnline()

                    val intent = Intent(baseContext, MainActivity::class.java)
                    intent.putExtra("online", onlineResult)
                    startActivity(intent)
                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }

        background.start()
/*
        Handler().postDelayed(Runnable {

        }, 5000)
*/
    }
}