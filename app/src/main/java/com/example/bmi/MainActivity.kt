package com.example.bmi


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the views by their IDs
        val etHeight=findViewById< EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)


        // Set the onClick listener for the calculate button
        btnCalculate.setOnClickListener {
            val height = etHeight.text.toString().toDoubleOrNull()
            val weight = etWeight.text.toString().toDoubleOrNull()

            if (height != null && weight != null && height > 0) {
                // Calculate BMI
                val bmi = weight / (height * height)
                val bmiResult = String.format("%.2f", bmi)

                // Display the result based on BMI value
                tvResult.text = when {
                    bmi < 18.5 -> "Underweight: Your BMI is $bmiResult"
                    bmi in 18.5..24.9 -> "Normal weight: Your BMI is $bmiResult"
                    bmi in 25.0..29.9 -> "Overweight: Your BMI is $bmiResult"
                    else -> "Obese: Your BMI is $bmiResult"
                }
            } else {
                // Handle invalid input
                tvResult.text = "please enter valid value for height and weight."
            }
        }
    }
}