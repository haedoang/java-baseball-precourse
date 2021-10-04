package baseball.utils;

/**
 * Date : 2021.10.04
 * Author : haedong kim
 * Description : 공통 상수 정의
 */
public class Constants {

    /** Input message of command */
    public static final String COMMAND_CONTINUE = "1";
    public static final String COMMAND_STOP = "2";

    /** Send Output message */
    public static final String MSG_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String MSG_INPUT_RESTART= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ";
    public static final String MSG_BALL = "볼";
    public static final String MSG_STRIKE = "스트라이크";
    public static final String MSG_NOTHING = "낫싱";
    public static final String MSG_HOMERUN = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    /** Error Messages */
    public static final String MSG_ERROR_NUMBER_FORMAT = "[ERROR] 숫자만 입력해주세요.";
    public static final String MSG_ERROR_LENGTH_MISMATCH = "[ERROR] 자리수가 다릅니다.";
    public static final String MSG_ERROR_DUPLICATE_NUMBER = "[ERROR] 서로 다른 수를 입력해주세요.";
    public static final String MSG_ERROR_NOT_COMMAND = "[ERROR] 알수없는 명령어입니다.";



}
