package baseball.service;

import baseball.vo.Baseball;
import baseball.vo.Status;

public interface BaseballService {
    /** 서로 다른 세 숫자의 최소 값 */
    int MIN_NUMBER = 1;
    /** 서로 다른 세 숫자의 최대 값 */
    int MAX_NUMBER = 9;
    /** 볼의 개수 */
    int BALL_CNT = 3;

    Baseball createGame();

    void play(Baseball baseball, String number);

    boolean validate(String number, Status status);

}
