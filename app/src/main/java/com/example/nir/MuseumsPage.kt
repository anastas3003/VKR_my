package com.example.nir

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.utils.widget.ImageFilterButton

class MuseumsPage : AppCompatActivity() {

    private lateinit var imFB15: ImageFilterButton
    private lateinit var imFB16: ImageFilterButton
    private lateinit var imFB18: ImageFilterButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museums_page)

        imFB15 = findViewById(R.id.imageFilterButton15)
        imFB16 = findViewById(R.id.imageFilterButton16)
        imFB18 = findViewById(R.id.imageFilterButton18)

        imFB15.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked8", true)
            startActivity(intent)
        }

        imFB16.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked9", true)
            startActivity(intent)
        }

        imFB18.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked10", true)
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