package com.example.nir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlacePage : AppCompatActivity() {

    private lateinit var button: Button
    //private lateinit var recyclerView: RecyclerView

    val buttonList = mutableListOf<Button>()


    //private val buttons = listOf("Кнопка", "Button 2", "Button 3")
    //private val adapter = ButtonAdapter(buttons) { button -> Toast.makeText(this, "Clicked: $button", Toast.LENGTH_SHORT).show() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_page)

        val linearLayout = findViewById<LinearLayout>(R.id.linlay)

        //recyclerView = findViewById(R.id.recycler_view)

        /*recyclerView.apply {
            layoutManager = LinearLayoutManager(this@PlacePage)
            setHasFixedSize(true)
            adapter = this@PlacePage.adapter
        }*/

        button = findViewById(R.id.button4)
        button.setOnClickListener()
        {
            finish()
        }

           /* imButton.setOnClickListener {
            val newButton = Button(this)
            newButton.text = "New Button"
            newButton.setOnClickListener {
                Toast.makeText(this, "New button clicked", Toast.LENGTH_SHORT).show()
            }
            buttonList.add(newButton)
            buttonContainer.addView(newButton)
        }*/

        val buttonClicked = intent.getBooleanExtra("buttonClicked", false)
        if (buttonClicked) {
            // кнопка была нажата
            val button = Button(this)
            linearLayout.addView(button)
        }

        //val buttonText = intent.getStringExtra("buttonText")

        //val button2 = Button(this)
        //button.text = buttonText
        // Добавляем кнопку в макет
        //linearLayout.addView(button2)
    }

    /*fun Attr(view: View)
    {
        val attr = Intent(this, AttrPage::class.java)
        startActivity(attr)

    }*/
}