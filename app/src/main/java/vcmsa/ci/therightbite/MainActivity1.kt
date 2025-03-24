package vcmsa.ci.therightbite

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTime: EditText = findViewById(R.id.inputTime)
        val tvSuggestion: TextView = findViewById(R.id.tvSuggestion)
        val btnReset: Button = findViewById(R.id.btnReset)
        val btnSuggest: Button = findViewById(R.id.bntSuggest)

        // Button click to determine the meal suggestion
        btnSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim()

            val mealSuggestion: String = when (timeOfDay) {
                "Morning" -> "Breakfast: FutureLife cereal"
                "Mid-morning" -> "Light Snack: Peanuts"
                "Afternoon" -> "Lunch: Toasted Sandwich"
                "Evening" -> "Snack: Chocolate or sweets"
                "Dinner" -> "Main course: Steak"
                "After dinner" -> "Snacks: Ice Cream"
                else -> {
                    Toast.makeText(this, "Incorrect input! Please enter a valid time of day", Toast.LENGTH_SHORT).show()
                    "Incorrect input"
                }
            }

            // Display meal suggestion
            tvSuggestion.text = mealSuggestion
        }

        // Button click to reset fields
        btnReset.setOnClickListener {
            inputTime.text.clear()
            tvSuggestion.text = "Meal suggestion will appear here"
        }
    }
}
