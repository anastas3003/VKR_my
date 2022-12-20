package com.example.nir

import android.content.Intent
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.io.IOException

class EstatesPage : AppCompatActivity() {
    private lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estates_page)
        textView3 = findViewById(R.id.textView3)

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
