package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Activity!!", Toast.LENGTH_SHORT).show()
     findViewById<Button>(R.id.button).setOnClickListener {
         supportFragmentManager.commit {
             add<FragmentFirst>(R.id.container)
             addToBackStack(null)
         }
     Toast.makeText(this,  "Fragment added", Toast.LENGTH_SHORT).show()
     }
        findViewById<Button>(R.id.button2).setOnClickListener{
            supportFragmentManager.commit{
                replace<FragmentSecond>(R.id.container)
                addToBackStack(null)
            }
            Toast.makeText(this,  "Fragment Replaced", Toast.LENGTH_SHORT).show()

        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            supportFragmentManager.commit{
                val fragment = supportFragmentManager.findFragmentById(R.id.container)
                remove(fragment as Fragment)
                addToBackStack(null)
            }
            Toast.makeText(this, "no more fragments", Toast.LENGTH_SHORT).show()
        }

     }
}