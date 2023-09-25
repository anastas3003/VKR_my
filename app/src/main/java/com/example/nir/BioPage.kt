package com.example.nir

import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class BioPage : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView6: TextView
    private lateinit var imageView: ImageView
    private lateinit var seekBar2: SeekBar
    private lateinit var imageButton: ImageButton
    private lateinit var button: Button
    private lateinit var runnable: Runnable
    private lateinit var mediaPlayer2: MediaPlayer
    private var handler2 = Handler()

    // Переменная для работы с БД
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nir.R.layout.activity_bio_page)
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        textView6 = findViewById(R.id.textView6)
        seekBar2 = findViewById(R.id.seekBar1)
        imageButton = findViewById(R.id.play)
        button = findViewById(R.id.button10)

        mDBHelper = DatabaseHelper(this)

        val buttonClicked20 = intent.getBooleanExtra("buttonClicked20", false)

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

        button.setOnClickListener()
        {
            finish()
        }

        if (buttonClicked20)
        {}

    }


        fun MTB(view: View) {

        imageView.setImageResource(R.drawable.mtbio)

        var descript: String = ""
            val cursor: Cursor = mDb!!.rawQuery("SELECT * FROM Bio WHERE bio_id = 211", null)

            cursor.moveToFirst()
            val ColumnIndex = cursor.getColumnIndex("bio_des")

            while (!cursor.isAfterLast()) {
            descript += cursor.getString(ColumnIndex)
            cursor.moveToNext()
        }
        cursor.close();

            textView6.setText(descript)
            textView6.setMovementMethod(ScrollingMovementMethod())

            mediaPlayer2 = MediaPlayer.create(this, R.raw.mtbio)

            seekBar2.progress = 0
            seekBar2.max = mediaPlayer2.duration

            imageButton.setOnClickListener{
                if(!mediaPlayer2.isPlaying)
                {
                    mediaPlayer2.start()
                    imageButton.setImageResource(R.drawable.ic_baseline_pause_24)
                }else{
                    mediaPlayer2.pause()
                    imageButton.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                }
            }

            seekBar2.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                    if(changed) {
                        mediaPlayer2.seekTo(pos) } }

                override fun onStartTrackingTouch(p0: SeekBar?) {}

                override fun onStopTrackingTouch(p0: SeekBar?) {}
            })

            runnable = Runnable {
                seekBar2.progress = mediaPlayer2.currentPosition
                handler2.postDelayed(runnable, 1000)
            }
            handler2.postDelayed(runnable, 1000)
            mediaPlayer2.setOnCompletionListener {
                imageButton.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                seekBar2.progress = 0
            }
        }


    fun name(view: View) {

        var descript2: String = ""
        val cursor2: Cursor = mDb!!.rawQuery("SELECT * FROM Bio WHERE bio_id = 211", null)

        cursor2.moveToFirst()
        val ColumnIndex2 = cursor2.getColumnIndex("bio_name")

        while (!cursor2.isAfterLast()) {
            descript2 += cursor2.getString(ColumnIndex2)
            cursor2.moveToNext()

        }
        cursor2.close();

        textView.setText(descript2)
    }

    /*override fun onStop()
    {
        super.onStop()
        if(mediaPlayer2 != null)
        {
            mediaPlayer2!!.release()
            mediaPlayer2 == null
        }
    }*/


}