package baseball.service;

import baseball.vo.Baseball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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
        Assertions.assertThat(numbers).doesNotHaveDuplicates();
    }

}
