package com.atguigu.exer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author k
 * @create 2021-04-15 19:44
 */
public class DateExer {

    @Test
    public void test() {

    }

    //三天打鱼两天晒网，问自 1990-5-8起打鱼，那么year年month月day日在干嘛
    public String method(int year, int month, int day) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String str = String.valueOf(year) + String.valueOf(month) + String.valueOf(day);
        Date date = dateFormat.parse(str);
        Date date1 = dateFormat.parse("19900508");
        long l = date.getTime() - date1.getTime();
        long d = l / (1000 * 60 * 60 * 24) + 1;
        if ((d % 5) > 0 && d % 5 < 4) {
            return "晒网";
        } else if (d % 5 == 0 || d % 5 == 4) {
            return "打鱼";
        } else {
            throw new RuntimeException("输入有误");
        }
    }
}
