package com.example.calendartest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CalendarAdapter(context: Context) :BaseAdapter(){
    val mDateManager:DateManager = DateManager()
    val dateArray:List<Date> = mDateManager.getCalendar()
    val mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
    class ViewHolder(){
        lateinit var text:TextView
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val holder: ViewHolder
           var convert = convertView
        if (convert == null){
            convert = mLayoutInflater.inflate(R.layout.calendar_cell,null)
            holder = ViewHolder()
            holder.text = convert.findViewById(R.id.dateText)

        }
        return convert
    }

}