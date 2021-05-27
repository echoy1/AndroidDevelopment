package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)


        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val dateNow = myCalendar.time
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, selectedYear, selectedMonth, selectedDayOfMonth ->

            val selectedDate = "${selectedMonth+1}/$selectedDayOfMonth/$selectedYear"

            txtSelectedDate.setText(selectedDate)

            val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            txtSelectedDateInMinutes.setText(((year - selectedYear)*525600+(month - selectedMonth)*43800+(day - selectedDayOfMonth)*1440).toString())


        }
            , year
            , month
            , day).show()
    }

}