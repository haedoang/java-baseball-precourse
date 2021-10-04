package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SetTest {
    private Set<Integer> numbers;
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void T01_요구사항1_Set의_크기_확인하기() {
        /** GIVEN */
        Set<Integer> given = numbers;

        /** WHEN */
        int size = given.size();

        /** THEN */
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})   /** GIVEN */
    void T02_요구사항2_Set의_값_확인하기(int value) {
        /** THEN */
        assertThat(numbers).contains(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')   /** GIVEN */
    void T02_요구사항3_Set의_값_확인하기_02(int input, boolean result) {
        /** THEN */
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}