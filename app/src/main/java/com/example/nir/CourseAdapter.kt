package com.example.nir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//создание класса адаптера CourseAdapter
class CourseAdapter(

    private var List: ArrayList<Course>

    ) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private lateinit var Listener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setItemClickListener(listener: onItemClickListener){
        Listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CourseAdapter.CourseViewHolder {
        //Метод используется для увеличения файла макета,
        //который был создан для RecyclerView.
        //увеличиваем файл макета
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.res_item,
            parent, false
        )

        //возврат ViewHolder с файлом просмотра элементов
        return CourseViewHolder(itemView, Listener)
    }

    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<Course>) {
        //добавление отфильтрованного списка в список массивов
        List = filterlist
        //уведомление адаптера об изменении данных в RecyclerView
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CourseAdapter.CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        val course = List[position]
        holder.NameTV.text = List.get(position).Name
        holder.IV.setImageResource(List.get(position).Img)
    }

    override fun getItemCount(): Int {
        //возврат размера списка
        return List.size
    }

    class CourseViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        //инициализация имени  и изображения достопримечательности
        val NameTV: TextView = itemView.findViewById(R.id.text_view)
        val IV: ImageView = itemView.findViewById(R.id.im_view)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)

            } } }
}
