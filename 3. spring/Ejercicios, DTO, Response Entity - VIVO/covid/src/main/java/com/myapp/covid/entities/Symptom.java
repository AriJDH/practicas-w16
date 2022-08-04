package com.myapp.covid.entities;

import com.myapp.covid.utilities.Severities;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Symptom {
    private String cod;
    private String name;
    private String severity;
}
