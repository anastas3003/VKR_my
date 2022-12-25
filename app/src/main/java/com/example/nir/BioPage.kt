package com.example.nir

import android.content.Intent
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class BioPage : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView6: TextView
    private lateinit var imageView: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var seekBar2: SeekBar


    // Переменная для работы с БД
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nir.R.layout.activity_bio_page)
        imageView = findViewById(R.id.imageView)
        imageView3 = findViewById(R.id.imageView3)
        textView = findViewById(R.id.textView)
        textView6 = findViewById(R.id.textView6)
        seekBar2 = findViewById(R.id.seekBar2)

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


        MTB(textView6)
        name(textView)

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

        fun MTB(view: View) {

        imageView.setImageResource(R.drawable.mtbio)


        var descript: String = ""
            val cursor: Cursor = mDb!!.rawQuery("SELECT * FROM Bio WHERE bio_id = 211", null)

            cursor.moveToFirst()
            val ColumnIndex = cursor.getColumnIndex("bio_des")

            while (!cursor.isAfterLast()) {
            descript += cursor.getString(1)
            cursor.moveToNext()

        }
        cursor.close();

        textView6.setText(descript)
    }


    fun name(view: View) {

        var descript2: String = ""
        val cursor2: Cursor = mDb!!.rawQuery("SELECT * FROM Bio WHERE bio_id = 212", null)

        cursor2.moveToFirst()
        val ColumnIndex2 = cursor2.getColumnIndex("bio_name")

        while (!cursor2.isAfterLast()) {
            descript2 += cursor2.getString(1)
            cursor2.moveToNext()

        }
        cursor2.close();

        textView.setText(descript2)
    }

    fun Audio2(view: View)
    {
        val audio2: MediaPlayer = MediaPlayer.create(this@BioPage, R.raw.mtbio)
        audio2.start()
    }

}