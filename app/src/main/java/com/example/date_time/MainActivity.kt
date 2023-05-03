package com.example.date_time

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.date_time.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeText: TextView = findViewById(R.id.time_text)
        val timePicker: TimePicker = findViewById(R.id.timePicker)
        val dateButton: Button =findViewById(R.id.date_sel)
        
        timePicker.setOnTimeChangedListener { timePicker, hourOfDay, minute ->

            timeText.text="${hourOfDay}시 ${minute}분"
        }

        dateButton.setOnClickListener{
            val date:date=date()
            val manager:FragmentManager=supportFragmentManager
            val transaction:FragmentTransaction=manager.beginTransaction()

            transaction.replace(R.id.fragment_date,date).commit()
        }
    }
}