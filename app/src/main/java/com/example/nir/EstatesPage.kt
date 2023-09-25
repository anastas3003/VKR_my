package com.example.nir

import android.content.Intent
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterButton
import java.io.IOException

class EstatesPage : AppCompatActivity() {
    private lateinit var textView3: TextView
    private lateinit var imFB: ImageFilterButton
    private lateinit var imFB2: ImageFilterButton
    private lateinit var imFB3: ImageFilterButton
    private lateinit var button7: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estates_page)
        textView3 = findViewById(R.id.textView3)

        imFB = findViewById(R.id.imageFilterButton)
        imFB2 = findViewById(R.id.imageFilterButton2)
        imFB3 = findViewById(R.id.imageFilterButton3)
        button7 = findViewById(R.id.button7)


        imFB.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked5", true)
            startActivity(intent)
        }

        imFB2.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked6", true)
            startActivity(intent)
        }

        imFB3.setOnClickListener()
        {val intent = Intent(this, AttrPage::class.java)
            intent.putExtra("buttonClicked7", true)
            startActivity(intent)
        }

        button7.setOnClickListener()
        {
            finish()
        }

    }

    fun Main(view: View)
    {
        val main = Intent(this, MainPage::class.java)
        startActivity(main);
    }

}
