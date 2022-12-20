package com.example.nir

import android.R
import android.content.Intent
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class AttrPage : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView5: TextView
    private lateinit var textView7: TextView
    private lateinit var imageView: ImageView


    // Переменная для работы с БД
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nir.R.layout.activity_attr_page)
        imageView = findViewById(R.id.imageView6)
        textView = findViewById(R.id.textView)
        textView5 = findViewById(R.id.textView5)
        textView7 = findViewById(R.id.textView7)

        mDBHelper = DatabaseHelper(this)

        try {
            mDBHelper!!.openDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToOpenDatabase")
        }

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


        PMT(textView)
        title(textView7)
        Audio(textView5)

    }

    fun Main(view: View)
    {
        val main = Intent(this, MainPage::class.java)
        startActivity(main);
    }


        fun PMT(view: View) {

        imageView.setImageResource(R.drawable.pmt)


        var descript: String = ""
            val cursor: Cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 11;", null)

        while (!cursor.isAfterLast()) {
            descript += cursor.getString(1)
            cursor.moveToNext()

        }
        cursor.close();

        textView.setText(descript)
    }


    fun title(view: View) {

        var descript2: String = ""
        val cursor: Cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 11;", null)

        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            descript2 += cursor.getString(1)
            cursor.moveToNext()

        }
        cursor.close();

        textView7.setText(descript2)
    }

    fun Audio()
    {
        val music: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.PMT)
        music.start()
    }

}