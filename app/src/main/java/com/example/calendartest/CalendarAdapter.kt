package com.example.calendartest

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.Locale;
import java.text.SimpleDateFormat
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
        return dateArray.size
    }

    override fun getItem(position: Int): Any? {
        return null;
    }

    override fun getItemId(position: Int): Long {
        return 0
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

        //日付を表示させる処理↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        //日付表示のフォーマット作成
        var dateFormat: SimpleDateFormat = SimpleDateFormat("d", Locale.US)
        holder.text.setText(dateFormat.format(dateArray[position]))
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        //当月以外の日付の背景を灰色にする↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        if (convert != null) {
            if (mDateManager.isCurrentMonth(dateArray.get(position))) {
                convert.setBackgroundColor(Color.WHITE)
            } else {
                convert.setBackgroundColor(Color.LTGRAY)
            }
        }
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        //土日の時文字色を変更する↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        val colorId:Int
        when(mDateManager.getDayOfWeek(dateArray.get(position))){
            1    -> colorId = Color.RED
            7    -> colorId = Color.BLUE
            else -> colorId = Color.BLACK
        }
        holder.text.setTextColor(colorId)
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
        return convert
    }

}