package com.redare.shop.unifyworkbench.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @Author yj
 * @email yangj@redare.cn
 * @Date 2020/2/18 13:07 
 * 用于当天、本周、本月、本季度、本年时间范围查询
 **/
public class DateUtils {
    /**
     * 当天0点时间
     * @return
     */
    public static Date getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 昨天0点时间
     * @return
     */
    public static Date getYesTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 当天24点时间
     * @return
     */
    public static Date getTodayEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 59);
        return cal.getTime();
    }

    /**
     * 昨天24点时间
     * @return
     */
    public static Date getYesTodayEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 59);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 获得本周一0点时间
     * @return
     */
    public static Date getThisWeekMonday() {
//        Calendar cal = Calendar.getInstance();
//        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
//        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        return cal.getTime();
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setFirstDayOfWeek(Calendar.MONDAY);//以周一为首日
        cal.setTimeInMillis(System.currentTimeMillis());//当前时间
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//周一
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得本周日24点时间
     * @return
     */
    public static Date getThisWeekSunday() {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(getThisWeekMonday());
//        cal.add(Calendar.DAY_OF_WEEK, 7);
//        return cal.getTime();
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setFirstDayOfWeek(Calendar.MONDAY);//以周一为首日
        cal.setTimeInMillis(System.currentTimeMillis());//当前时间
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//周日
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取上个月第一天0点时间
     * @return
     */
    public static Date getLastMonthStartTime(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    /**
     * 获取上个月最后一天24点时间
     * @return
     */
    public static Date getLastMonthEndTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得本月第一天0点时间
     * @return
     */
    public static Date getThisMonthStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获得上月第一天0点时间
     * @return
     */
    public static Date getThisPreviousMonthStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获得本月最后一天24点时间
     * @return
     */
    public static Date getThisMonthEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 59);
        return cal.getTime();
    }

    /**
     * 获得上月最后一天24点时间
     * @return
     */
    public static Date getThisPreviousMonthEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 59);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取本季度第一天0点时间
     * @return
     */
    public static Date getThisQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     * @return
     */
    public static Date getThisQuarterEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisQuarterStartTime());
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    /**
     * 本年第一天0点时间
     * @return
     */
    public static Date getThisYearStartTime() {
        Calendar cal = Calendar.getInstance();
        int dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        cal.add(Calendar.DAY_OF_YEAR, -dayOfYear + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 本年最后一天24点时间
     * @return
     */
    public static Date getThisYearEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisYearStartTime());
        cal.add(Calendar.YEAR, 1);
        return cal.getTime();
    }

    /**
     * 得到给定时间的小时数
     * @param date
     * @return
     */
    public static int getDayOfHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 得到给定日期是星期几
     * 1-7表示星期一至星期天(为了排序方便和符合中国习惯)
     * @param date
     * @return
     */
    public static int getWeekByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekDay=cal.get(Calendar.DAY_OF_WEEK);
        int returnWeekDay=0;
        switch(weekDay) {
            case 1 : returnWeekDay=7; break;
            case 2 : returnWeekDay=1; break;
            case 3 : returnWeekDay=2; break;
            case 4 : returnWeekDay=3; break;
            case 5 : returnWeekDay=4; break;
            case 6 : returnWeekDay=5; break;
            case 7 : returnWeekDay=6; break;
            default: break;
        }
        return returnWeekDay;
    }

    /**
     * 获取给定日期是月中的几号
     * @param date
     * @return
     */
    public static int getDayOfMonthByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取给定日期是在年中的月份
     * @param date
     * @return
     */
    public static int getMonthOfYearByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH)+1;
    }

    /**
     * 得到给定日期是星期几
     * @param date
     * @return
     */
    public static String getWeekCnByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekDay=cal.get(Calendar.DAY_OF_WEEK);
        String strweekDay="";
        switch(weekDay) {
            case 1 : strweekDay="星期天"; break;
            case 2 : strweekDay="星期一"; break;
            case 3 : strweekDay="星期二"; break;
            case 4 : strweekDay="星期三"; break;
            case 5 : strweekDay="星期四"; break;
            case 6 : strweekDay="星期五"; break;
            case 7 : strweekDay="星期六"; break;
            default: break;
        }
        return strweekDay;
    }


    /**
     * 日期转字符串
     *
     * @param date
     *            日期
     * @param pattern
     *            格式
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        }
        return "";
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }
    /**
     * * 字符串转日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date stringToDate(String date, String pattern) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Date();
    }

    /**
     * * 字符串转日期
     *
     * @param date
     * @return
     */
    public static Date stringToDate(String date) {
        return stringToDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 毫秒转换为多少天取整
     * @param ms
     * @return
     */
    public static long milliSecondToDays(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
        if(day > 0) {
            return day;
        }else{
            return 0;
        }
    }

    /**
     * 毫秒转化为字符串的天时分秒毫秒
     * @param ms
     * @return
     */
    public static String milliSecondToDayHour(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if(day > 0) {
            sb.append(day+"天");
        }else{
            sb.append("0天");
        }
        if(hour > 0) {
            sb.append(hour+"小时");
        }
        if(minute > 0) {
            sb.append(minute+"分");
        }
        if(second > 0) {
            sb.append(second+"秒");
        }
        if(milliSecond > 0) {
            sb.append(milliSecond+"毫秒");
        }
        return sb.toString();
    }

    /**
     * 获取指定月份的天数
     * @param datestr yyyy-MM格式
     */
    public static int getDaysByYearMonth(String datestr){
        //获取当前时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(stringToDate(datestr,"yyyy-MM"));
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定月份的天数
     * @param year 年
     * @param month 月
     * @return
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取指定月份的所有日期
     * @param yearMonth
     * yyyy-MM年月日期格式
     * @return
     */
    public static List<String> getMonthDaysList(String yearMonth) {
        List<String> list=new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(stringToDate(yearMonth,"yyyy-MM"));
        int dayNumOfMonth = getDaysByYearMonth(yearMonth);
        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始
        for (int i = 0; i < dayNumOfMonth; i++, cal.add(Calendar.DATE, 1)) {
            Date d = cal.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String df = simpleDateFormat.format(d);
            list.add(df);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("获得当天0点时间：" + getTodayStartTime().toLocaleString());
        System.out.println("获得当天24点时间：" + getTodayEndTime().toLocaleString());

        System.out.println("获得本周一0点时间：" + getThisWeekMonday().toLocaleString());
        System.out.println("获得本周日24点时间：" + getThisWeekSunday().toLocaleString());

        System.out.println("获得本月第一天0点时间：" + getThisMonthStartTime().toLocaleString());
        System.out.println("获得本月最后一天24点时间：" + getThisMonthEndTime().toLocaleString());

        System.out.println("获得本季度第一天0点时间：" + getThisQuarterStartTime().toLocaleString());
        System.out.println("获得本季度最后一天24点时间：" + getThisQuarterEndTime().toLocaleString());

        System.out.println("获得本年第一天0点时间：" + getThisYearStartTime().toLocaleString());
        System.out.println("获得本年最后一天24点时间：" + getThisYearEndTime().toLocaleString());

        System.out.println("获得上月第一天0点时间：" + getLastMonthStartTime().toLocaleString());
        System.out.println("获得上月最后一天24点时间：" + getLastMonthEndTime().toLocaleString());

        System.out.println("小时数："+getDayOfHour(new Date()));

//        System.out.println(millisecondTOType(1000*60*60*24,"d"));
//        System.out.println(millisecondTOType(1000*60*60*24,"h"));
//        System.out.println(millisecondTOType(1000*60*60*24,"m"));

        long milliSecond = 1000*60*60*24*100L;
        System.out.println(milliSecondToDays(milliSecond));

        System.out.println(getWeekByDate(new Date()));
        System.out.println(getWeekCnByDate(new Date()));
        System.out.println(getDayOfMonthByDate(stringToDate("2020-02-29 14:02:03")));
        System.out.println(getMonthOfYearByDate(stringToDate("2020-12-20 14:02:03")));

    }


}
