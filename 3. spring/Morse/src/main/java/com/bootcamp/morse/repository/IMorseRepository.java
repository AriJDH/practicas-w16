package com.bootcamp.morse.repository;

import com.bootcamp.morse.dto.MorseDto;

public interface IMorseRepository {
    MorseDto contrucMorse(String message);
}
