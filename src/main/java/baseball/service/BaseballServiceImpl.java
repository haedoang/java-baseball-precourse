package baseball.service;

import baseball.vo.Baseball;
import baseball.vo.Status;

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

    private void setNumbers(Baseball baseball) {
        System.out.println("setNumbers method");
        baseball.setNumbers(new String[3]);
    }


}
