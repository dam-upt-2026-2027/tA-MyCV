package pt.uptomar.dam2026.mycurriculumvitae

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // find the button and control it
        findViewById<Button>(R.id.button).setOnClickListener {
            showCV(it)
        }
    }

    private fun showCV(view: View) {
        /**
         * if user's answer is YES or SIM or EVET
         *     show CV
         *     show my name
         *     hide button
         *     hide textbox
         * else
         *     do nothing
         */

        // access to the textbox
        var textBox = findViewById<EditText>(R.id.editTextText)

        // test the user's answer
        if (textBox.text.toString().lowercase().equals("yes") ||
            textBox.text.toString().lowercase().equals("sim") ||
            textBox.text.toString().lowercase().equals("evet")
        ) {
            findViewById<LinearLayout>(R.id.show_cv).visibility = View.VISIBLE
            findViewById<TextView>(R.id.my_name).visibility = View.VISIBLE
            textBox.visibility = View.GONE
            findViewById<Button>(R.id.button).visibility = View.GONE
        }


    }

}