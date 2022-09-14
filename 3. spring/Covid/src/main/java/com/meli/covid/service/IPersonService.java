package com.meli.covid.service;

import com.meli.covid.dto.PersonDto;

import java.util.List;

public interface    IPersonService {
    List<PersonDto> findRiskPerson();
}
