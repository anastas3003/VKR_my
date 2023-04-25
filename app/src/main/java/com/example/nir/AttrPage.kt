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


class AttrPage : AppCompatActivity() {
    private lateinit var textView16: TextView
    private lateinit var textView17: TextView
    private lateinit var imageView9: ImageView
    private lateinit var imageView7: ImageView
    private lateinit var seekBar: SeekBar


    // Переменная для работы с БД
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nir.R.layout.activity_attr_page)
        imageView9 = findViewById(R.id.imageView9)
        imageView7 = findViewById(R.id.imageView7)
        textView17 = findViewById(R.id.textView17)
        textView16 = findViewById(R.id.textView16)
        seekBar = findViewById(R.id.seekBar2)

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


        PMT(textView17)
        title(textView16)

    }

    fun Main(view: View)
    {
        val main = Intent(this, MainPage::class.java)
        startActivity(main);
    }

    fun Bio(view: View)
    {
        val bio = Intent(this, BioPage::class.java)
        startActivity(bio);
    }


        fun PMT(view: View) {
        imageView7.setImageResource(R.drawable.pmt)

        var descript: String = ""
            val cursor: Cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 22", null)

            cursor.moveToFirst()
            val ColumnIndex = cursor.getColumnIndex("attr_des")

            while (!cursor.isAfterLast()) {
            descript += cursor.getString(ColumnIndex)
            cursor.moveToNext()

        }
        cursor.close();

        textView17.setText(descript)
    }


    fun title(view: View) {

        var descript2: String = ""
        val cursor2: Cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 22", null)

        cursor2.moveToFirst()
        val ColumnIndex2 = cursor2.getColumnIndex("attr_name")

        while (!cursor2.isAfterLast()) {
            descript2 += cursor2.getString(ColumnIndex2)
            cursor2.moveToNext()

        }
        cursor2.close();

        textView16.setText(descript2)
    }

    fun Audio(view: View)
    {
        val audio = MediaPlayer.create(this@AttrPage, R.raw.pmta)
        audio.start()
    }

    fun Place(view: View)
    {

    }

}