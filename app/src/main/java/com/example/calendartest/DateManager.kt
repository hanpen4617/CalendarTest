package com.example.calendartest

import java.util.*

class DateManager {
    private var mCalendar = Calendar.getInstance()
    fun CalendarSet(){
        //当月のセルの総数
        var count = mCalendar.getActualMaximum(Calendar.WEEK_OF_MONTH)*7
        //当月の１日をmCalendarにセット
        //ｍCalendarは〇月1日のインスタンスになっている
        mCalendar.set(Calendar.DATE, 1)
        //dayOfWeekに１日の曜日を基準に何日文戻るかを記録
        var dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK)-1
        //カレンダーに表示する前月の日付（ない場合は当月の１日）にmCalendarをセット
        mCalendar.add(Calendar.DATE,-dayOfWeek)
        //Date型の可変リスト作って　・来月分の追加日はこの後のfor文で自動的に追加される
    }

}