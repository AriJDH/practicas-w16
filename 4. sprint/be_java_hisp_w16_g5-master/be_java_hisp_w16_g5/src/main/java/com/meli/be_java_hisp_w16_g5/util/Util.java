package com.meli.be_java_hisp_w16_g5.util;
import java.time.LocalDate;

import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;

public class Util {
    public static Long WEEK_VALUE = 1000 * 60 * 60 * 24 * 7l;
    
    public static LocalDate timeAgo(Integer times) {
        LocalDate date = LocalDate.now();
        return date.minusWeeks(times);
    }

    public static Integer getSortCondition(String order, String tag) throws UnknownRequestException {
        if(order == null) return null;
        if(order.equals(tag + "_asc")) return 1;
        if(order.equals(tag + "_desc")) return -1;

        throw new UnknownRequestException("Unknown order: " + order);
    }
}
