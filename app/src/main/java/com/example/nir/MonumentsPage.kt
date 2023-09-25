package com.example.nir

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.utils.widget.ImageFilterButton

class MonumentsPage : AppCompatActivity() {

    private lateinit var imFB7: ImageFilterButton
    private lateinit var imFB10: ImageFilterButton
    private lateinit var imFB11: ImageFilterButton
    private lateinit var button9: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monuments_page)

        imFB7 = findViewById(R.id.imageFilterButton7)
        imFB10 = findViewById(R.id.imageFilterButton10)
        imFB11 = findViewById(R.id.imageFilterButton11)
        button9 = findViewById(R.id.button9)


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

        button9.setOnClickListener()
        {
            finish()
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