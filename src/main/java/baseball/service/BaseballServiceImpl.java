package baseball.service;

import baseball.utils.TextUtil;
import baseball.vo.Baseball;
import baseball.vo.Status;
import nextstep.utils.Randoms;

import static baseball.utils.Constants.*;
/**
 * date : 2021.10.04
 * Author : haedong kim
 * Description : BaseballServiceImpl
 */
public class BaseballServiceImpl implements BaseballService {
    @Override
    public Baseball createGame() {
        Baseball baseball = new Baseball();
        this.setNumbers(baseball);
        return baseball;
    }

    @Override
    public String play(Baseball baseball, String number) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < baseball.getNumbers().length; i++) {
            int index = number.indexOf(baseball.getNumbers()[i]);
            strike = (index != -1 && index == i) ? ++strike : strike;
            ball = (index != -1 && index != i) ? ++ball : ball;
        }
        return TextUtil.resultMsg(strike, ball);
    }

    @Override
    public boolean validate(String number, Status status) {
       return status == Status.START ? this.checkNumber(number) : this.checkCommand(number);
    }

    private boolean checkNumber(String number) {
        //cond1. 글자수 체크
        if(number.length() != BALL_CNT) {
            System.out.println(MSG_ERROR_LENGTH_MISMATCH);
            return false;
        }
        //cond2. 숫자인지 체크
        if(!TextUtil.isNumber(number)) {
            System.out.println(MSG_ERROR_NUMBER_FORMAT);
            return false;
        }
        //cond2. 중복된 숫자인지 확인
        if(TextUtil.hasDuplicate(number)) {
            System.out.println(MSG_ERROR_DUPLICATE_NUMBER);
            return false;
        }
        return true;
    }

    private boolean checkCommand(String number) {
        //cond1. 명령어인지 체크
        if(!TextUtil.isCommand(number)) {
            System.out.println(MSG_ERROR_NOT_COMMAND);
            return false;
        }
        return true;
    }

    /**
     *
     * @param baseball
     * Description : 세자리 서로다른 숫자 배열을 만든다.
     */
    private void setNumbers(Baseball baseball) {
        StringBuffer sb = new StringBuffer();
        while(baseball.getNumbers() == null) {
            sb.append(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
            this.checkDuplicate(sb, baseball);
        }
    }

    private void checkDuplicate(StringBuffer sb, Baseball baseball) {
        if(TextUtil.hasDuplicate(sb.toString())) {
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        if(sb.length() == BALL_CNT) {
            baseball.setNumbers(sb.toString().split(""));
            return;
        }
    }

}
