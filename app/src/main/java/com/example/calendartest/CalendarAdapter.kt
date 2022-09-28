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
    //カレンダー制作クラスのインスタンス化
    val mDateManager:DateManager = DateManager()
    //カレンダーデータが入ったリスト
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
        var holder= ViewHolder()
        var convert = convertView
        if(convert == null){
            //convertに一セル分のデータデザインを格納
            convert = mLayoutInflater.inflate(R.layout.calendar_cell,parent,false)
            //holderの中に格納
            holder.text = convert.findViewById(R.id.dateText)
            convert.tag = holder
        } else {
            holder = convert.tag as ViewHolder
        }
        //ここから具体的なデータを入れる処理

        return convert
    }

}