package com.ndemaio.ejercicioproductoselasticsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductType {
    EDIBLE, CLEANING;
}
