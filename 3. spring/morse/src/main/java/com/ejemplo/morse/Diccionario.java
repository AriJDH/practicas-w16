package com.ejemplo.morse;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Diccionario {

    A(".-"),
    B("-..."),
    C("-.-."),
    D("-.."),
    E("."),
    F("..-."),
    G("--."),
    H("...."),
    I(".."),
    J(".---"),
    K("-.-"),
    L(".-.."),
    M("--"),
    N("-."),
    O("---"),
    P(".--."),
    Q("--.-"),
    R(".-."),
    S("..."),
    T("-"),
    U("..-"),
    V("...-"),
    W(".--"),
    X("-..-"),
    Y("-.--"),
    Z("--.."),
    CERO("-----"),
    UNO(".----"),
    DOS("..---"),
    TRES("...--"),
    CUATRO("....-"),
    CINCO("....."),
    SEIS("-...."),
    SIETE("--..."),
    OCHO("---.."),
    NUEVE("----."),
    PREGUNTA("..--.."),
    ADMIRACION("-.-.--"),
    PUNTO(".-.-.-"),
    COMA("--..--");

    private String letraMorse;
    private static Map<String,Diccionario> ENUM_MAP = null;

    Diccionario(String s) {
        this.letraMorse = s;
    }

    public String getName() {
        return this.letraMorse;
    }

    static {
        Map<String,Diccionario> map = new ConcurrentHashMap<>();
        for (Diccionario instance : Diccionario.values()) {
            map.put(instance.getName(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Diccionario get(String name) {
        return ENUM_MAP.get(name);
    }


}
