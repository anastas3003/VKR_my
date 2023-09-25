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
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable: Runnable
    private var handler = Handler()
    private lateinit var imButton: ImageButton
    private lateinit var cursor: Cursor
    private lateinit var cursor2: Cursor
    private lateinit var fb: Button
    private lateinit var button11: Button


    var descript: String = ""
    var descript2: String = ""
    var text: String = ""

    // Переменная для работы с БД
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nir.R.layout.activity_attr_page)
        imageView7 = findViewById(R.id.imageView7)
        textView17 = findViewById(R.id.textView17)
        textView16 = findViewById(R.id.textView16)
        seekBar = findViewById(R.id.seekBar1)
        button11 = findViewById(R.id.button11)
        imageButton = findViewById(R.id.play)
        button = findViewById(R.id.button12)
        imButton = findViewById(R.id.imageButton)
        imButton.setBackgroundResource(R.color.transparent)
        fb = findViewById(R.id.favBtn)

        val buttonClicked2 = intent.getBooleanExtra("buttonClicked2", false)
        val buttonClicked3 = intent.getBooleanExtra("buttonClicked3", false)
        val buttonClicked4 = intent.getBooleanExtra("buttonClicked4", false)
        val buttonClicked5 = intent.getBooleanExtra("buttonClicked5", false)
        val buttonClicked6 = intent.getBooleanExtra("buttonClicked6", false)
        val buttonClicked7 = intent.getBooleanExtra("buttonClicked7", false)
        val buttonClicked8 = intent.getBooleanExtra("buttonClicked8", false)
        val buttonClicked9 = intent.getBooleanExtra("buttonClicked9", false)
        val buttonClicked10 = intent.getBooleanExtra("buttonClicked10", false)
        val buttonClicked11 = intent.getBooleanExtra("buttonClicked11", false)
        val buttonClicked12 = intent.getBooleanExtra("buttonClicked12", false)
        val buttonClicked13 = intent.getBooleanExtra("buttonClicked13", false)
        val buttonClicked14 = intent.getBooleanExtra("buttonClicked14", false)
        val buttonClicked15 = intent.getBooleanExtra("buttonClicked15", false)
        val buttonClicked16 = intent.getBooleanExtra("buttonClicked16", false)
        val buttonClicked17 = intent.getBooleanExtra("buttonClicked17", false)
        val buttonClicked18 = intent.getBooleanExtra("buttonClicked18", false)
        val buttonClicked19 = intent.getBooleanExtra("buttonClicked19", false)

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

        val pos = intent.getIntExtra("position", -1)

        //для памятников
        if (buttonClicked2 || pos == 0)
        {imageView7.setImageResource(R.drawable.pmt)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 22", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 22", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.pmta)}
        else if (buttonClicked3 || pos == 1)
        {imageView7.setImageResource(R.drawable.nk)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 23", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 23", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.nkl)
            button11.visibility = View.INVISIBLE}
        else if (buttonClicked4 || pos == 2)
        {imageView7.setImageResource(R.drawable.pmk)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 24", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 24", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.pmik)
            button11.visibility = View.INVISIBLE}

        /*//для усадеб
        if (buttonClicked5 || course!=null)
        {imageView7.setImageResource(R.drawable.ub)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 11", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 11", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.bl)}
        else if (buttonClicked6 || course!=null&& course!=null)
        {imageView7.setImageResource(R.drawable.pz)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 12", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 12", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.pz)}
        else if (buttonClicked7 || course!=null)
        {imageView7.setImageResource(R.drawable.nik)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 28", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 28", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.nik)}

        //для музеев
        if (buttonClicked8 || course!=null)
        {imageView7.setImageResource(R.drawable.mkt)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 16", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 16", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.mts)}
        else if (buttonClicked9 || course!=null)
        {imageView7.setImageResource(R.drawable.zg)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 17", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 17", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.zg)}
        else if (buttonClicked10 || course!=null)
        {imageView7.setImageResource(R.drawable.tkg)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 18", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 18", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.tkg)}

        //для прир. объектов
        if (buttonClicked11 || course!=null)
        {imageView7.setImageResource(R.drawable.vr)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 19", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 19", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.vr)}
        else if (buttonClicked12 || course!=null)
        {imageView7.setImageResource(R.drawable.kza)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 20", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 20", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.kz)}
        else if (buttonClicked13 || course!=null)
        {imageView7.setImageResource(R.drawable.kp)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 21", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 21", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.kp)}

        //для парков
        if (buttonClicked14 || course!=null)
        {imageView7.setImageResource(R.drawable.pp)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 25", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 25", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.ppv)}
        else if (buttonClicked15 || course!=null)
        {imageView7.setImageResource(R.drawable.nk)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 26", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 26", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.nl)}
        else if (buttonClicked16 || course!=null)
        {imageView7.setImageResource(R.drawable.mk)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 27", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 27", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.npu)}

        //для храмов
        if (buttonClicked17 || course!=null)
        {imageView7.setImageResource(R.drawable.pbm)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 13", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 13", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.pbm)}
        else if (buttonClicked18 || course!=null)
        {imageView7.setImageResource(R.drawable.spp)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 14", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 14", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.spp)}
        else if (buttonClicked19 || course!=null)
        {imageView7.setImageResource(R.drawable.tup)
            cursor = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 15", null)
            cursor2 = mDb!!.rawQuery("SELECT * FROM Attr WHERE attr_id = 15", null)
            mediaPlayer = MediaPlayer.create(this, R.raw.tup)}*/

        DSC(textView17)
        title(textView16)
        Audio(imageButton)

        imButton.setOnClickListener()
        {
            val intent = Intent(this, PlacePage::class.java)
            intent.putExtra("text", text)
            startActivity(intent)
        }

        imButton.setOnClickListener()
        {
            val buttonClicked_sr = intent.getBooleanExtra("buttonClicked_sr", false)
        }
    }


    fun Bio(view: View)
    {
        val bio = Intent(this, BioPage::class.java)
        startActivity(bio);
    }

    fun DSC(view: View) {
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

        cursor2.moveToFirst()
        val ColumnIndex2 = cursor2.getColumnIndex("attr_name")

        while (!cursor2.isAfterLast()) {
            descript2 += cursor2.getString(ColumnIndex2)
            cursor2.moveToNext() }
        cursor2.close();

        text = textView16.setText(descript2).toString()
    }


    /*override fun onStop()
    {
        super.onStop()
        if(mediaPlayer != null)
        {
            mediaPlayer!!.release()
            mediaPlayer == null
        }
    }*/
}