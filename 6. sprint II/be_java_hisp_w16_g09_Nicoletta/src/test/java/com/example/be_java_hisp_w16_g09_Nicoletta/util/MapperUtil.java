package com.example.be_java_hisp_w16_g09_Nicoletta.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperUtil {

    private final ModelMapper modelMapper;

    public MapperUtil() {
        this.modelMapper = new ModelMapper();
    }

    public <S, T> List<T> mapList(List<S> objectsToMap, Class<T> targetClass) {
        return objectsToMap
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
    public <T> T map(Object anObject, Class<T> targetClass) {
        return modelMapper.map(anObject, targetClass);
    }
}
