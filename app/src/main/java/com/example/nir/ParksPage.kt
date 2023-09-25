package com.example.nir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.utils.widget.ImageFilterButton

class ParksPage : AppCompatActivity() {

    private lateinit var imFB4: ImageFilterButton
    private lateinit var imFB5: ImageFilterButton
    private lateinit var imFB6: ImageFilterButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parks_page)

        imFB4 = findViewById(R.id.imageFilterButton4)
        imFB5 = findViewById(R.id.imageFilterButton5)
        imFB6 = findViewById(R.id.imageFilterButton6)



        imFB4.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked14", true)
            startActivity(intent)
        }

        imFB5.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked15", true)
            startActivity(intent)
        }

        imFB6.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked16", true)
            startActivity(intent)
        }
    }

    fun Main(view: View)
    {
        val main = Intent(this, MainPage::class.java)
        startActivity(main);
    }

    fun Attr(view: View)
    {
        val attr = Intent(this, AttrPage::class.java)
        startActivity(attr)

    }
}