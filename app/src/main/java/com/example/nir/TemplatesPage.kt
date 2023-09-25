package com.example.nir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterButton

class TemplatesPage : AppCompatActivity() {
    private var list: MutableList<String> = mutableListOf()
    private lateinit var imFB12: ImageFilterButton
    private lateinit var imFB13: ImageFilterButton
    private lateinit var imFB14: ImageFilterButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_templates_page)

        imFB12 = findViewById(R.id.imageFilterButton12)
        imFB13 = findViewById(R.id.imageFilterButton13)
        imFB14 = findViewById(R.id.imageFilterButton14)



        imFB12.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked17", true)
            startActivity(intent)
        }

        imFB13.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked18", true)
            startActivity(intent)
        }

        imFB14.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked19", true)
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