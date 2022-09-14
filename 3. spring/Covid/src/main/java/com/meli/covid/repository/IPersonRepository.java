package com.meli.covid.repository;

import com.meli.covid.dto.PersonDto;

import java.util.List;

public interface IPersonRepository {
    List<PersonDto> findRiskPerson();
}
