package com.tutorials.a7minuteworkoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.tutorials.a7minuteworkoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /* new way and recommended approach to fetch id of view elements */
    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        /* this now contains the root of activity_main xml file as container i.e. constraintLayout is the root of entire binding */
        setContentView(binding?.root)
        binding?.flStart?.setOnClickListener {
            val intent = Intent(this, WorkoutActivity::class.java)
            startActivity(intent)
        }
        // val flStartButton:FrameLayout = findViewById(R.id.flStart)
        //        flStartButton.setOnClickListener{
        //            Toast.makeText(this@MainActivity, "Here we will start the workout.", Toast.LENGTH_SHORT).show()
        //        }
    }

    override fun onDestroy(){
        super.onDestroy()
        binding = null
    }
}