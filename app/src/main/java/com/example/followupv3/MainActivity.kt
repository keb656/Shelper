package com.example.followupv3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(intent.hasExtra("online")){
            network_textview.text = intent.getStringExtra("online")
        }else{
            network_textview.text = "네트워크 연결이 확인되지 않았습니다"
        }

        soonstart_button.setOnClickListener{
            val mainIntent = Intent(this, FragmentActivity::class.java)
            startActivity(mainIntent)
            finish()
        }

    }
}
