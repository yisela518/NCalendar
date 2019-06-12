package com.necer.adapter;

import android.content.Context;

import com.necer.MyLog;
import com.necer.utils.Util;
import com.necer.view.CalendarView;
import com.necer.view.WeekView;

import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by necer on 2018/9/11.
 * qq群：127278900
 */
public class WeekCalendarAdapter extends BaseCalendarAdapter {
    public WeekCalendarAdapter(Context context, LocalDate startDate, LocalDate endDate, LocalDate initializeDate, int firstDayOfWeek) {
        super(context, startDate, endDate, initializeDate, firstDayOfWeek);
    }

    @Override
    protected CalendarView getCalendarView(int position) {
        LocalDate localDate = mInitializeDate.plusDays((position - mCurr) * 7);
        List<LocalDate> dateList = Util.getWeekCalendar(localDate, mFirstDayOfWeek);
        return new WeekView(mContext, localDate, dateList);
    }

    @Override
    protected int getIntervalCount(LocalDate startDate, LocalDate endDate, int type) {
        return Util.getIntervalWeek(startDate, endDate, type);
    }
}
