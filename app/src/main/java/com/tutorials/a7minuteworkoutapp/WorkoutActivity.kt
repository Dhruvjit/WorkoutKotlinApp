package com.tutorials.a7minuteworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.tutorials.a7minuteworkoutapp.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity() {
    /* new way and recommended approach to fetch id of view elements */
    private var binding: ActivityWorkoutBinding? = null

    /* resting time between workouts timer */
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    /* workouts timer */
    private var workoutTimer: CountDownTimer? = null
    private var workoutProgress = 0

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
        /* start when activity is loaded */
        setupRestView()
    }

    /* when back button is pressed then reset the timer and set the progress bar */
    private fun setupRestView(){
        if(restTimer != null){
            restTimer?.cancel()
            restProgress=0
        }
        setRestProgressBar()
    }

    private fun setupWorkoutView(){
        /* if you make it visible then it will still stay in the view, with gone it is totally GONE */
        binding?.flProgressBar?.visibility = View.INVISIBLE
        binding?.tvTitle?.text = "Workout Name"
        binding?.flWorkoutView?.visibility = View.VISIBLE
        if(workoutTimer != null){
            workoutTimer?.cancel()
            workoutProgress=0
        }
        setWorkoutProgressBar()
    }

    private fun setRestProgressBar(){
        /* how much the rest will be that will be defined by rest progress bar */
        binding?.progressBar?.progress = restProgress
        /* execute the code below at every second */
        restTimer = object: CountDownTimer(10000, 1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBar?.progress = 10 - restProgress
                binding?.tvTimer?.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
                setupWorkoutView()
//                Toast.makeText(this@WorkoutActivity, "Now we wil start the exercise.", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun setWorkoutProgressBar(){
        /* how much the rest will be that will be defined by rest progress bar */
        binding?.progressBar?.progress = workoutProgress
        /* execute the code below at every second */
        workoutTimer = object: CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                workoutProgress++
                binding?.progressBarWorkout?.progress = 30 - workoutProgress
                binding?.tvTimerWorkout?.text = (30 - workoutProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@WorkoutActivity, "30 seconds are over, let's go to the rest view.", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null){
            restTimer?.cancel()
            restProgress=0
        }
        if(workoutTimer != null){
            workoutTimer?.cancel()
            workoutProgress=0
        }
        binding = null
    }
}