package com.example.nir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.utils.widget.ImageFilterButton

class MonumentsPage : AppCompatActivity() {

    private lateinit var imFB7: ImageFilterButton
    private lateinit var imFB10: ImageFilterButton
    private lateinit var imFB11: ImageFilterButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monuments_page)

        imFB7 = findViewById(R.id.imageFilterButton7)
        imFB10 = findViewById(R.id.imageFilterButton10)
        imFB11 = findViewById(R.id.imageFilterButton11)

        imFB7.setOnClickListener()
        {
            val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked2", true)
            startActivity(intent)
        }

        imFB10.setOnClickListener()
        {
            val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked3", true)
            startActivity(intent)
        }

        imFB11.setOnClickListener()
        {
            val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked4", true)
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