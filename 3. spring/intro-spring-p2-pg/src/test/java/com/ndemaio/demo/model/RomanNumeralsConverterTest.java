package com.ndemaio.demo.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsConverterTest {

    private RomanNumeralsConverter romanNumeralsConverter;

    @BeforeEach
    void setUp() {
        romanNumeralsConverter = new RomanNumeralsConverter();
    }

    @Test
    public void test_convert_1() {
        assertThat(romanNumeralsConverter.convert(1)).isEqualTo("I");
    }

    @Test
    public void test_convert_2() {
        assertThat(romanNumeralsConverter.convert(2)).isEqualTo("II");
    }

    @Test
    public void test_convert_3() {
        assertThat(romanNumeralsConverter.convert(3)).isEqualTo("III");
    }

    @Test
    public void test_convert_4() {
        assertThat(romanNumeralsConverter.convert(4)).isEqualTo("IV");
    }

    @Test
    public void test_convert_9() {
        assertThat(romanNumeralsConverter.convert(9)).isEqualTo("IX");
    }

    @Test
    public void test_convert_1010() {
        assertThat(romanNumeralsConverter.convert(1010)).isEqualTo("MX");
    }

}
