package com.tomas.qatester.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListTestCaseDTO {

    private List test = new ArrayList<>();

}
