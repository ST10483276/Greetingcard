package vcmsa.ci.therightbite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Get reference to UI elements
        val inputTime = findViewById<EditText>(R.id.inputTime)
        val btnSuggestion = findViewById<Button>(R.id.bntSuggest)
        val tvSuggestion = findViewById<TextView>(R.id.tvSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)

        //press to preview meal suggestion
        btnSuggestion.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()

            //press to statement to determine the meal
            val mealSuggestion = when (timeOfDay) {
                "Morning" -> "Breakfast : FutureLife cereal"
                "Mid-morning" -> "Light Snack : Peanuts"
                "Afternoon" -> "Lunch : Toasted Sandwich"
                "Afternoon" -> "Snack : Chocolate or sweets"
                "Dinner" -> "Main course : Steak"
                "After dinner" -> "Snacks : Ice Cream"
                else -> { 
                    Toast.makeText(this, "Incorrect input! Please enter a valid time of day", Toast.LENGTH_SHORT).show();

                }
            }
            //Display meal suggestion
            val tvSuggestion: TextView = findViewById(R.id.tvSuggestion)
            val mealSuggestion = "Try the pasta today!"
            tvSuggestion.text = mealSuggestion

        }
        // Button click to reset fields
        btnReset.setOnClickListener {
            inputTime.text.clear()
            tvSuggestion.text = "Meal suggestion will appear here"
        }
    }
}
