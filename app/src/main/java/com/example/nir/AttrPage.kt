package com.example.nir

import android.annotation.SuppressLint
import android.content.Intent
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


class AttrPage : AppCompatActivity() {
    private lateinit var textView16: TextView
    private lateinit var textView17: TextView
    private lateinit var imageView7: ImageView
    private lateinit var seekBar: SeekBar
    private lateinit var imageButton: ImageButton
    private lateinit var button: Button
    private lateinit var runnable: Runnable
    private var handler = Handler()
    private lateinit var imButton: ImageButton


    // Переменная для работы с БД
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null

    var mMediaPlayer: MediaPlayer? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nir.R.layout.activity_attr_page)
        imageView7 = findViewById(R.id.imageView7)
        textView17 = findViewById(R.id.textView17)
        textView16 = findViewById(R.id.textView16)
        seekBar = findViewById(R.id.seekBar1)
        imageButton = findViewById(R.id.play)
        button = findViewById(R.id.button12)
        imButton = findViewById(R.id.imageButton)

        val buttonClicked2 = intent.getBooleanExtra("buttonClicked2", false)
        val buttonClicked3 = intent.getBooleanExtra("buttonClicked3", false)
        val buttonClicked4 = intent.getBooleanExtra("buttonClicked4", false)

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



        button.setOnClickListener()
        {
            finish()
        }

        /*imButton.setOnClickListener {
            val newButton = Button(this)
            newButton.text = "New Button"
            newButton.setOnClickListener {

            }
            buttonList.add(newButton)
            buttonContainer.addView(newButton)
        }*/

        /*imButton.setOnClickListener()
        {
            val intent = Intent(this, PlacePage::class.java)
            intent.putExtra("textButton", "Кнопка")
            startActivity(intent)
        }*/

        imButton.setOnClickListener()
        {
            val intent = Intent(this, PlacePage::class.java)
            intent.putExtra("buttonClicked", true)
            startActivity(intent)
        }

        if (buttonClicked2)
            imageView7.setImageResource(R.drawable.pmt)
        else if (buttonClicked3)
            imageView7.setImageResource(R.drawable.nk)
        else if (buttonClicked4)
            imageView7.setImageResource(R.drawable.mk)


        PMT(textView17)
        title(textView16)
        Audio(imageButton)

    }


    fun Bio(view: View)
    {
        val bio = Intent(this, BioPage::class.java)
        startActivity(bio);
    }


        fun PMT(view: View) {

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
        textView17.setMovementMethod(ScrollingMovementMethod())
        //scrollView.addView(textView17)


    }

    fun Audio(button: ImageButton)
    {
        val mediaPlayer:MediaPlayer = MediaPlayer.create(this, R.raw.pmta)

        seekBar.progress = 0
        seekBar.max = mediaPlayer.duration

        imageButton.setOnClickListener{
            if(!mediaPlayer.isPlaying)
            {
                mediaPlayer.start()
                imageButton.setImageResource(R.drawable.ic_baseline_pause_24)
            }else{
                mediaPlayer.pause()
                imageButton.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if(changed) {
                    mediaPlayer.seekTo(pos) } }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        runnable = Runnable {
            seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
        mediaPlayer.setOnCompletionListener {
            imageButton.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            seekBar.progress = 0
        }
    }


    fun title(view: View) {

        var descript2: String = ""
        val cursor2: Cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 22", null)

        cursor2.moveToFirst()
        val ColumnIndex2 = cursor2.getColumnIndex("attr_name")

        while (!cursor2.isAfterLast()) {
            descript2 += cursor2.getString(ColumnIndex2)
            cursor2.moveToNext() }
        cursor2.close();

        textView16.setText(descript2) }


    override fun onStop()
    {
        super.onStop()
        if(mMediaPlayer != null)
        {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    fun Place(view: View)
    {}

}