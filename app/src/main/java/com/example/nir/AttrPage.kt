package com.example.nir

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.SQLException
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class AttrPage : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    // Переменная для работы с БД
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nir.R.layout.activity_attr_page)
        imageView = findViewById(R.id.imageView6)
        textView = findViewById(R.id.textView)

        mDBHelper = DatabaseHelper(this)

        try {
            mDBHelper!!.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }

        mDb = try {
            mDBHelper!!.getWritableDatabase()
        } catch (mSQLException: SQLException) {
            throw mSQLException
        }

    }

    fun Main(view: View)
    {
        val main = Intent(this, MainPage::class.java)
        startActivity(main);
    }

        fun PMT(view: View) {

        imageView.setImageResource(R.drawable.pmt)

        var descript: String = ""
        val cursor: Cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 13", null)

        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            descript += cursor.getString(1)
            cursor.moveToNext();
        }
        cursor.close();

        textView.setText(descript)
    }

}