package com.example.calendartest

import java.text.SimpleDateFormat
import java.time.temporal.ValueRange
import java.util.*

class DateManager {
    private var mCalendar = Calendar.getInstance()

    //現在の状態を保持
    var startDate = mCalendar.time
    fun  getCalendar():List<Date> {
        //当月のセルの総数
        var count = mCalendar.getActualMaximum(Calendar.WEEK_OF_MONTH) * 7
        //当月の１日をmCalendarにセット
        //ｍCalendarは〇月1日のインスタンスになっている
        mCalendar.set(Calendar.DATE, 1)
        //dayOfWeekに１日の曜日を基準に何日文戻るかを記録
        var dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK) - 1
        //カレンダーに表示する前月の日付（ない場合は当月の１日）にmCalendarをセット
        mCalendar.add(Calendar.DATE, -dayOfWeek)
        //Date型の可変リスト作って　・来月分の追加日はこの後のfor文で自動的に追加される
        var list = mutableListOf<Date>()
        for (i in 0..count-1) {
            list.add(mCalendar.time)
            mCalendar.add(Calendar.DATE, 1)
        }
        mCalendar.setTime(startDate);
        //当月のカレンダーがリストで返される
        return list
    }

    fun isCurrentMonth(date: Date): Boolean{
        val format = SimpleDateFormat("yyyy.MM", Locale.US)
        val currentMonth = format.format(mCalendar.time)
        if(currentMonth.equals(format.format(date))){
            return true
        } else {
            return false
        }
    }

    fun getDayOfWeek(date: Date): Int{
        val calendar = Calendar.getInstance()
        calendar.setTime(date)
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

}
