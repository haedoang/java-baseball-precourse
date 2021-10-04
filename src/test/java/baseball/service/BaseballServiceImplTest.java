package baseball.service;

import baseball.ui.BaseUI;
import baseball.ui.BaseballUI;
import baseball.utils.Constants;
import baseball.vo.Baseball;
import baseball.vo.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class BaseballServiceImplTest {
    BaseballService service;

    @BeforeEach
    void init() {
        /** GIVEN */
        service = new BaseballServiceImpl();
    }

    @Test
    void T01_중복되지않은_세자리_숫자() {
        /** GIVEN */
        Baseball baseball = service.createGame();
        /** WHEN */
        String[] numbers = baseball.getNumbers();
        /** THEN */
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @Test
    void T02_숫자입력_체크() {
        /** GIVEN */
        String input1 = "123";
        String input2 = "444";
        String input3 = "abc";
        String input4 = "4";

        /** WHEN */
        boolean validate1 = service.validate(input1, Status.START);
        boolean validate2 = service.validate(input2, Status.START);
        boolean validate3 = service.validate(input3, Status.START);
        boolean validate4 = service.validate(input4, Status.START);
        /** THEN */
        assertThat(validate1).isTrue();
        assertThat(validate2).isFalse();
        assertThat(validate3).isFalse();
        assertThat(validate4).isFalse();
    }

    @Test
    void T03_명령어_체크() {
        /** GIVEN */
        String input1 = Constants.COMMAND_CONTINUE;
        String input2 = Constants.COMMAND_STOP;
        String input3 = "abc";
        /** WHEN */
        boolean validate1 = service.validate(input1, Status.STOP);
        boolean validate2 = service.validate(input2, Status.STOP);
        boolean validate3 = service.validate(input3, Status.STOP);
        /** THEN */
        assertThat(validate1).isTrue();
        assertThat(validate2).isTrue();
        assertThat(validate3).isFalse();
    }
}
