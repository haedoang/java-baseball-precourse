package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TextUtilTest {

    @Test
    void T01_중복된_문자_확인하기() {
        /** GIVEN */
        String notDuplicateNumbers = "123";
        String duplicateNumbers = "444";
        /** WHEN */
        boolean result1 = TextUtil.hasDuplicate(notDuplicateNumbers);
        boolean result2 = TextUtil.hasDuplicate(duplicateNumbers);
        /** THEN */
        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
    }

    @Test
    void T02_숫자인지_확인하기() {
        /** GIVEN */
        String number = "123";
        String notNumber = "abc";
        /** WHEN */
        boolean result1 = TextUtil.isNumber(number);
        boolean result2 = TextUtil.isNumber(notNumber);
        /** THEN */
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }


}
