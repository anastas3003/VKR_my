package com.example.nir

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView

class Search : AppCompatActivity() {

    //создание переменных
    lateinit var course: RecyclerView
    lateinit var courseAdapter: CourseAdapter
    lateinit var List: ArrayList<Course>
    private lateinit var button_sr: Button

    @SuppressLint("NotifyDataSetChanged", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.src)

        button_sr = findViewById(R.id.button_sr)

        course = findViewById(R.id.res_view)

        //инициализация списка
        List = ArrayList()

        //инициализация адаптера
        courseAdapter = CourseAdapter(List)

        //установка адаптера на RecyclerView
        course.adapter = courseAdapter

        //добавление элементов в список
        List.add(Course("Музей истории космонавтики имени К. Э. Циолковского", R.drawable.mkit))
        List.add(Course("Зайцева гора", R.drawable.mzg))
        List.add(Course("Тарусская картинная галерея", R.drawable.tkg))
        List.add(Course("Воробьи", R.drawable.nk))
        List.add(Course("Никола-Ленивец", R.drawable.kpe))
        List.add(Course("Угра", R.drawable.pmt))
        List.add(Course("Пафнутьев-Боровский монастырь", R.drawable.pbm))
        List.add(Course("Собор Петра и Павла", R.drawable.spp))
        List.add(Course("Тихонова Успенская Пустынь", R.drawable.tup))
        List.add(Course("Радужный", R.drawable.vra))
        List.add(Course("Калужские засеки", R.drawable.kza))
        List.add(Course("Кольцовские пещеры", R.drawable.kpe))
        List.add(Course("Памятник М. И. Цветаевой", R.drawable.pmt))
        List.add(Course("Нулевой километр", R.drawable.nkl))
        List.add(Course("Памятник М. И. Кутузову", R.drawable.pmk))
        List.add(Course("Белкино", R.drawable.ub))
        List.add(Course("Полотняный завод", R.drawable.pza))
        List.add(Course("Никольское", R.drawable.nik))

        //уведомление адаптера об обновлении данных
        courseAdapter.notifyDataSetChanged()
        val intent = Intent(this, AttrPage::class.java)

courseAdapter.setItemClickListener(object: CourseAdapter.onItemClickListener{
    override fun onItemClick(position: Int) {
        intent.putExtra("position", position)
        startActivity(intent)
    }
})

        button_sr.setOnClickListener()
        {
            finish()
        }
    }

    //вызов функции создания макета меню для увеличения размера файла меню
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.sr_menu, menu)

        //получение пункта меню
        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)

        //получение поискового представления элемента
        val searchView: SearchView = searchItem.getActionView() as SearchView

        //вызов метода setOnQueryTextListener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                //фильтрация RecyclerView
                filter(msg)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {
        //создание нового списка для фильтрации данных
        val filteredlist: ArrayList<Course> = ArrayList()

        //запуск цикла для сравнения элементов
        for (item in List) {
            // проверяем, совпадает ли введенная строка с каким-либо элементом RecycleView
            if (item.Name.toLowerCase().contains(text.toLowerCase())) {
                //если нашлось совпадение, добавляем элемент к списку фильтрации
                filteredlist.add(item) }
        }

        if (filteredlist.isEmpty()) {
            //если ни один элемент не добавлен в отфильтрованный список,
            //выводим всплывающее сообщение о том, что данные не найдены.
            Toast.makeText(this, "Ничего не найдено..", Toast.LENGTH_SHORT).show()
        } else {
            //передача отфильтрованного списка классу адаптера
            courseAdapter.filterList(filteredlist)
        }
    }
}