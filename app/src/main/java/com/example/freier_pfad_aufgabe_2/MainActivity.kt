package com.example.freier_pfad_aufgabe_2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerMode = findViewById<Spinner>(R.id.spinnerMode)
        val editInput = findViewById<EditText>(R.id.editInput)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textResult = findViewById<TextView>(R.id.textResult)

        val options = arrayOf(
            "Fläche in Fußballfelder",
            "Alter (in Jahren) in Minuten",
            "Geld in Zeit",
            "Meter in Cheeseburger",
            "Gigabyte in Bits"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMode.adapter = adapter

        buttonCalculate.setOnClickListener {
            val inputText = editInput.text.toString()

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Bitte gib einen Wert ein!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val inputValue = inputText.toDoubleOrNull()
            if (inputValue == null) {
                Toast.makeText(this, "Ungültige Zahl eingegeben!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedOption = spinnerMode.selectedItemPosition

            when (selectedOption) {
                0 -> {
                    val fields = inputValue / 7140.0
                    textResult.text = "Das entspricht ca. %.2f Fußballfeldern.".format(fields)
                }
                1 -> {
                    val minutes = inputValue * 525960
                    textResult.text = "Das entspricht ca. %.0f Minuten.".format(minutes)
                }
                2 -> { // Geld in Zeit
                    if (inputValue >= 1_000_000_000_000_000) {
                        val millionYears = (inputValue / 1_000_000_000_000_000) * 31.7
                        textResult.text = "Das sind ca. %.1f Millionen Jahre! Selbst wenn Elon Musk jede Sekunde einen Tausender verbrennt, erlebt er das Ende dieser Zeitspanne nicht mal ansatzweise.".format(millionYears)
                    } else if (inputValue >= 1_000_000_000_000) {
                        val thousandYears = (inputValue / 1_000_000_000_000) * 31.7
                        textResult.text = "Das sind ca. %.1f tausend Jahre! Glückwunsch, du hast gerade die Maßeinheit 'Konto von Elon Musk im Jahr 2030' erreicht.".format(thousandYears)
                    } else if (inputValue >= 1_000_000_000) {
                        val years = (inputValue / 1_000_000_000) * 31.7
                        textResult.text = "Geld als Sekunden visualisiert: Ca. %.1f Jahre!".format(years)
                    } else {
                        val days = (inputValue / 1_000_000) * 11.0
                        textResult.text = "Geld als Sekunden visualisiert: Ca. %.1f Tage.".format(days)
                    }
                }
                3 -> {
                    val cheeseburgers = inputValue / 0.095
                    textResult.text = "Das entspricht der Länge von ca. %.1f Cheeseburgern. God bless America! 🇺🇸".format(cheeseburgers)
                }
                4 -> {
                    val bits = inputValue * 1024 * 1024 * 1024 * 8
                    textResult.text = "Das sind exakt %.0f Bits.".format(bits)
                }
            }
        }
    }
}