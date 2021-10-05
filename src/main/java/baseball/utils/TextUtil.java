package baseball.utils;

import java.util.HashSet;

/**
 * Date : 2021. 10.04
 * Author : haedong kim
 * Description : TextUtil.java
 */
public class TextUtil {
    private static StringBuffer sb = new StringBuffer();
    /**
     * @Description : 중복된 문자가 있는지 체크
     */
    public static boolean hasDuplicate(String input) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        return input.length() > set.size();
    }

    /**
     * @Description : 숫자인지 체크
     */
    public static boolean isNumber(String input) {
        return input.matches("[1-9]+");
    }

    /**
     * @Description : 명령어인지 체크
     */
    public static boolean isCommand(String input) {
        return (input.equals(Constants.COMMAND_CONTINUE) || input.equals(Constants.COMMAND_STOP)) ? true : false;
    }

    public static String resultMsg(int strikeCount, int ballCount) {
        sb.setLength(0);
        if(strikeCount > 0) {
            sb.append(strikeCount).append(Constants.MSG_STRIKE);
        }
        if(ballCount > 0) {
            sb.append(sb.length() > 0 ? " " : "").append(ballCount).append(Constants.MSG_BALL);
        }
        return (sb.length() == 0) ? Constants.MSG_NOTHING : sb.toString();
    }

}
