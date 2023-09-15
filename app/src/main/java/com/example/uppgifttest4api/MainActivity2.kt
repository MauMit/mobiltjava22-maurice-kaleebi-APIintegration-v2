package com.example.uppgifttest4api

import android.app.TaskStackBuilder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val spookybtn1 = findViewById<Button>(R.id.spookybtn1)
        val darkbtn1 = findViewById<Button>(R.id.darkbtn1)
        val dogbt1 = findViewById<Button>(R.id.dogbtn1)



        spookybtn1.setOnClickListener {
            when (navController.currentDestination?.id) {
                R.id.blankFragment -> {
                    navController.navigate(R.id.action_blankFragment_to_spookyFragment)
                    spookybtn1.isEnabled = false
                }

                R.id.darkFragment -> {
                    navController.navigate(R.id.action_darkFragment_to_spookyFragment)
                    spookybtn1.isEnabled = false
                    darkbtn1.isEnabled = true

                }

                R.id.dogFragment -> {
                    navController.navigate(R.id.action_dogFragment_to_spookyFragment)

                    dogbt1.isEnabled = true
                    spookybtn1.isEnabled = false

                }

            }
        }


        darkbtn1.setOnClickListener {
            when (navController.currentDestination?.id) {
                R.id.blankFragment -> {
                    navController.navigate(R.id.action_blankFragment_to_darkFragment)
                    darkbtn1.isEnabled = false
                }

                R.id.spookyFragment -> {
                    navController.navigate(R.id.action_spookyFragment_to_darkFragment)
                    spookybtn1.isEnabled = true
                    darkbtn1.isEnabled = false
                }

                R.id.dogFragment -> {
                    navController.navigate(R.id.action_dogFragment_to_darkFragment)
                    dogbt1.isEnabled = true
                    darkbtn1.isEnabled = false

                }
            }
        }



        dogbt1.setOnClickListener {
            when (navController.currentDestination?.id) {
                R.id.blankFragment -> {
                    navController.navigate(R.id.action_blankFragment_to_dogFragment)
                    dogbt1.isEnabled = false

                }

                R.id.spookyFragment -> {
                    navController.navigate(R.id.action_spookyFragment_to_dogFragment)
                    spookybtn1.isEnabled = true
                    dogbt1.isEnabled = false

                }

                R.id.darkFragment -> {
                    navController.navigate(R.id.action_darkFragment_to_dogFragment)
                    darkbtn1.isEnabled = true
                    dogbt1.isEnabled = false
                }
            }
        }


        findViewById<Button>(R.id.homeButton).setOnClickListener {
            navController.navigate(R.id.to_blankFragmentPop)
            val intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(this)
            stackBuilder.addNextIntentWithParentStack(intent)
            stackBuilder.startActivities(Bundle())
        }
    }
}