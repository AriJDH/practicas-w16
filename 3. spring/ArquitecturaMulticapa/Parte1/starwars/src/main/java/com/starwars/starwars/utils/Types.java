package com.starwars.starwars.utils;

import java.lang.reflect.Type;

public class Types {
    public String name;
    public Object value;
    public Type type;

    public Types(Type type, String name, Object value) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Types{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }    
}
