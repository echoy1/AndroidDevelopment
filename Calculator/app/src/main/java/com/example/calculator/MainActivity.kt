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
    private var secPart = false
    private var firstPart = false
    private var operator = false
    private  var canBeNegative = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onDigit(view: View) {
        if ((!secPart && !operator) || (secPart && operator)) {
            binding.txtInput.append((view as Button).text)
            lastNumeric = true
            firstPart = true
        }
    }

    fun onClear(view: View) {
        binding.txtInput.setText("")
        binding.txtInput2.setText("")
        binding.txtInputSymbol.setText("")
        lastNumeric = false
        lastDot = false
        secPart = false
        firstPart = false
        operator = false
        canBeNegative = true
    }

    fun onDecimalPoint(view: View) {
        if ((!secPart && !operator) || (secPart && operator)) {
            if (binding.txtInput.text.toString()
                    .equals("") || lastNumeric && !lastDot || binding.txtInput.text.toString()
                    .substring(1).equals("")
            ) {
                binding.txtInput.append(".")
                lastNumeric = false
                lastDot = true
                firstPart = true
            }
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var firstInput = binding.txtInput.text.toString()
            var secInput = binding.txtInput2.text.toString()
            var symbol = binding.txtInputSymbol.text.toString()

            try {
                if (!secPart && !operator) {
                    binding.txtInput2.text = firstInput
                } else {
                    if (symbol.equals("+")) { // || symbol.equals("")
                        binding.txtInput2.text =
                            removeZeroAfterDot((secInput.toDouble() + firstInput.toDouble()).toString())
                    } else if (symbol.equals("-")) {
                        binding.txtInput2.text =
                            removeZeroAfterDot((secInput.toDouble() - firstInput.toDouble()).toString())
                    } else if (symbol.equals("*")) {
                        binding.txtInput2.text =
                            removeZeroAfterDot((secInput.toDouble() * firstInput.toDouble()).toString())
                    } else if (symbol.equals("/")) {
                        binding.txtInput2.text =
                            removeZeroAfterDot((secInput.toDouble() / firstInput.toDouble()).toString())
                    }
                }
                binding.txtInput.text = ""
                binding.txtInputSymbol.text = ""

                lastNumeric = false
                lastDot = false
                secPart = true
                operator = false
                firstPart = false
                canBeNegative = true

            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(result: String): String {
        var value = result
        if (result.contains("0"))
            value = result.substring(0, result.length - 2)
        return value
    }

    fun onOperator(view: View) {
        if (((!secPart && !operator) || (secPart && operator)) && !firstPart && ((view as Button).text.toString()
                .equals("-") && canBeNegative)
        ) {
            binding.txtInput.append("-")
            lastNumeric = false
            canBeNegative = false
        } else if (firstPart && secPart && operator) {
            onEqual(view)
            binding.txtInputSymbol.append((view as Button).text)
            operator = true
        } else {
            if ((secPart && !operator) || (firstPart && !operator)) {

                binding.txtInputSymbol.append((view as Button).text)

                if (!secPart && firstPart) {
                    binding.txtInput2.setText(binding.txtInput.text)
                    binding.txtInput.setText("")
                }

                lastNumeric = false
                lastDot = false
                firstPart = false
                secPart = true
                operator = true
                canBeNegative = true
            }  // && !isOperatorAdded(binding.txtInput.text.toString())
        }
    }
}


/*private fun isOperatorAdded(value: String) : Boolean {
    return if (!            false
    } else {
        value.contains("/") || value.contains("*")
                || value.contains("+") || value.contains("-")
    }
}*/

