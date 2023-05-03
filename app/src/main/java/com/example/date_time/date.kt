package com.example.date_time

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class date : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_date, container, false)

        val dayText: TextView = view.findViewById(R.id.day_text)
        val datePicker: DatePicker = view.findViewById(R.id.datePicker)

        val iYear: Int = datePicker.year
        val iMonth: Int = datePicker.month + 1
        val iDay: Int = datePicker.dayOfMonth

        dayText.text = "${iYear}년 ${iMonth}월 ${iDay}일"

        datePicker.setOnDateChangedListener { datePicker, year, month, dayOfMonth ->

            dayText.text = "${year}년 ${month+1}월 ${dayOfMonth}일"
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            date().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}