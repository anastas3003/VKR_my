package com.example.nir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.utils.widget.ImageFilterButton

class NaturePage : AppCompatActivity() {

    private lateinit var imFB17: ImageFilterButton
    private lateinit var imFB8: ImageFilterButton
    private lateinit var imFB19: ImageFilterButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nature_page)

        imFB17 = findViewById(R.id.imageFilterButton17)
        imFB8 = findViewById(R.id.imageFilterButton8)
        imFB19 = findViewById(R.id.imageFilterButton19)



        imFB17.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked11", true)
            startActivity(intent)
        }

        imFB8.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked12", true)
            startActivity(intent)
        }

        imFB19.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked13", true)
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