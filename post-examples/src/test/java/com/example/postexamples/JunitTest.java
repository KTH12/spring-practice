package com.example.postexamples;

import static org.assertj.core.api.Assertions.*;

import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JunitTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @DisplayName("5보다 작은 숫자 테스트")
    void ValueSource_test(int expected) {
        assertThat(expected).isLessThan(6);
    }

    @Test
    void isLessThan_5() {
        assertThat(1).isLessThan(6);
        assertThat(2).isLessThan(6);
        assertThat(3).isLessThan(6);
        assertThat(4).isLessThan(6);
        assertThat(5).isLessThan(6);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1,2",
        "20,30"
    })
    void csvSource(int number, int expected) {
        assertThat(number).isLessThan(expected);
    }

    @ParameterizedTest
    @MethodSource("이것은_주입인자_메소드")
    void MethodSource_test(TestNumber testNumber, int number) {
        assertThat(testNumber.getNumber()).isEqualTo(number);
    }

    private static Stream<Arguments> 이것은_주입인자_메소드() {
        return Stream.of(
            Arguments.of(new TestNumber(1), 1),
            Arguments.of(new TestNumber(2), 2),
            Arguments.of(new TestNumber(3), 3)
        );
    }
}

class TestNumber {
    private int number;

    public TestNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}