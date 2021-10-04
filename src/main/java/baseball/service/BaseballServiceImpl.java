package baseball.service;

import baseball.vo.Baseball;
import baseball.vo.Status;
import nextstep.utils.Randoms;

import java.util.HashSet;

public class BaseballServiceImpl implements BaseballService {
    @Override
    public Baseball createGame() {
        Baseball baseball = new Baseball();
        this.setNumbers(baseball);
        return baseball;
    }

    @Override
    public void play(Baseball baseball, String number) {
        System.out.println("do play");
    }

    @Override
    public boolean validate(String number, Status status) {
       return status == Status.START ? this.checkNumber(number) : this.checkCommand(number);
    }

    private boolean checkNumber(String number) {
        System.out.println("check number");
        return true;
    }

    private boolean checkCommand(String number) {
        System.out.println("check command");
        return true;
    }

    /**
     *
     * @param baseball
     * Description : 세자리 서로다른 숫자 배열을 만든다.
     */
    private void setNumbers(Baseball baseball) {
        HashSet<String> hashSet = new HashSet<>();
        while(hashSet.size() != BALL_CNT) {
            hashSet.add(String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
        }
        baseball.setNumbers(hashSet.toArray(new String[hashSet.size()]));
    }


}
