package com.example.nir

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.database.SQLException;
import java.io.IOException;


class MainPage : AppCompatActivity() {
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        textView2 = findViewById(R.id.textView2)

    }




    fun Museums(view: View)
    {
        val m = Intent(this, MuseumsPage::class.java)
        startActivity(m);
    }

    fun Parks(view: View)
    {
        val p = Intent(this, ParksPage::class.java)
        startActivity(p);
    }

    fun Templates(view: View)
    {
        val t = Intent(this, TemplatesPage::class.java)
        startActivity(t);
    }

    fun Estates(view: View)
    {
        val e = Intent(this, EstatesPage::class.java)
        startActivity(e);
    }

    fun Monuments(view: View)
    {
        val m = Intent(this, MonumentsPage::class.java)
        startActivity(m);
    }

    fun Nature(view: View)
    {
        val n = Intent(this, NaturePage::class.java)
        startActivity(n);
    }

    fun Exit(view: View)
    {
        MainPage().finish();
        System.exit(0);
    }

    fun Places(view: View)
    {
        val pl = Intent(this, PlacePage::class.java)
        startActivity(pl);
    }

    fun Lang(view: View)
    {
    }



}