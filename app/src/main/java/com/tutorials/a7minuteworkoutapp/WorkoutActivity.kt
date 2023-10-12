package com.tutorials.a7minuteworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorials.a7minuteworkoutapp.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity() {
    /* new way and recommended approach to fetch id of view elements */
    private var binding: ActivityWorkoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarWorkout)

        /* show back button */
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarWorkout?.setNavigationOnClickListener{
            onBackPressed()
        }
    }
}