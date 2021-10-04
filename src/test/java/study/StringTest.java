package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @Date : 2021.10.03
 * @Author : haedong kim
 * @Description : String Class에 대한 학습 테스트
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class StringTest {

    @Test
    void T01_요구사항_split확인하기() {
        /** GIVEN */
        String given = "1,2";

        /** WHEN */
        String[] result = given.split(",");

        /** THEN */
        assertThat(result.length).isEqualTo(2);
        assertThat(result).contains("2","1"); //포함 여부 확인
        assertThat(result).containsExactly("1","2"); //포함 및 order 확인
    }

    @Test
    void T01_요구사항_split확인하기2() {
        /** GIVEN */
        String given = "1";

        /** WHEN */
        String[] result = given.split(",");

        /** THEN */
        assertThat(result.length).isEqualTo(1);
        assertThat(result).contains("1"); //포함 여부 확인
        assertThat(result).containsExactly("1"); //포함 및 order 확인
    }

    @Test
    void T03_요구사항2_substring확인하기() {
        /** GIVEN */
        String given = "(1,2)";

        /** WHEN */
        String result = given.substring(1, given.length()-1);

        /** THEN */
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("T4_요구사항3()_charAt 메소드는 범위를 벗어날 경우 StringIndexOutOfBoundsException을 발생시킨다.")
    void T04_요구사항3() {
        /** GIVEN */
        String given = "abc";

        /** WHEN */
        char result = given.charAt(0);

        /** THEN */
        assertThat(given.length()).isEqualTo(3);
        assertThat(result).isEqualTo('a');
        assertThatThrownBy(()-> given.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}