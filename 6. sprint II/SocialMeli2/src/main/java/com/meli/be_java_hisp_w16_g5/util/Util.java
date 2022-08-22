package com.meli.be_java_hisp_w16_g5.util;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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

    public static <Origen, Destino> Destino castTo(Origen t, Class<Destino> clazz) {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            return mapper.convertValue(t, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public static <Origen, Destino> List<Destino> castTo(List<Origen> data, Class<Destino> clazz) {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ArrayList<Destino> result = new ArrayList<>();
        try {
            for(Origen t: data) {
                result.add(mapper.convertValue(t, clazz));
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}
