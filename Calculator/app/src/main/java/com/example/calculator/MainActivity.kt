package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import java.lang.ArithmeticException
import kotlin.text.Regex.Companion.escapeReplacement

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastNumeric = false
    private var lastDot = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    
    fun onDigit(view: View) {
//        val txtInput = findViewById<TextView>(R.id.txtInput)
        binding.txtInput.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View) {
        binding.txtInput.setText("")
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view: View) {
        if (binding.txtInput.text.toString().equals("") || lastNumeric && !lastDot) {
            binding.txtInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var txtValue = binding.txtInput.text.toString()
            var prefix = ""
            try {
                if (txtValue.startsWith("-")) {
                    prefix = "-"
                    txtValue = txtValue.substring(1)
                }

                if(txtValue.contains("-")) {
                    val splitValue = txtValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()) {
                        one = prefix + one
                    }

                    binding.txtInput.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())

                } else if(txtValue.contains("+")) {
                    val splitValue = txtValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()) {
                        one = prefix + one
                    }

                    binding.txtInput.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())

                } else if(txtValue.contains("*")) {
                    val splitValue = txtValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()) {
                        one = prefix + one
                    }

                    binding.txtInput.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())

                } else if(txtValue.contains("/")) {
                    val splitValue = txtValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()) {
                        one = prefix + one
                    }

                    binding.txtInput.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())

                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(result: String) : String{
        var value = result
        if (result.contains("0"))
            value = result.substring(0,result.length - 2)
        return value
    }

    fun onOperator(view: View) {
        if (lastNumeric && !isOperatorAdded(binding.txtInput.text.toString())) {
            binding.txtInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    private fun isOperatorAdded(value: String) : Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*")
                    || value.contains("+") || value.contains("-")
        }
    }

}