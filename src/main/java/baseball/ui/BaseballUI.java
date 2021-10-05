package baseball.ui;

import baseball.service.BaseballService;
import baseball.service.BaseballServiceImpl;
import baseball.utils.Constants;
import baseball.vo.Baseball;
import baseball.vo.Status;
import nextstep.utils.Console;

public class BaseballUI implements BaseUI {
    private Baseball baseball;
    private BaseballService service;

    public BaseballUI() {
        this.service = new BaseballServiceImpl();
    }
    @Override
    public void init() {
        baseball = this.service.createGame();
    }

    @Override
    public void start() {
        this.init();
        do {
            String input = this.input(Constants.MSG_INPUT_NUMBER, baseball.getStatus());
            String resultMsg = this.service.play(baseball, input);
            this.checkResultMessage(resultMsg);
        } while(baseball.getStatus() == Status.START);
        String input = this.input(Constants.MSG_INPUT_RESTART, baseball.getStatus());
        if(input.equals(Constants.COMMAND_CONTINUE)) this.start();
        if(input.equals(Constants.COMMAND_STOP)) this.stop();
    }

    @Override
    public void stop() {
        return;
    }

    @Override
    public String input(String msg, Status status) {
        System.out.print(status == Status.START ? msg : msg + "\n");
        String input = Console.readLine();
        if(!this.service.validate(input, status)) {
            this.input(msg, status);
        }
        return input;
    }

    public void checkResultMessage(String msg) {
        System.out.println(msg);
        if(msg.equals(Constants.MSG_THREE_STRIKE)) {
            System.out.println(Constants.MSG_HOMERUN);
            this.baseball.setStatus(Status.STOP);
        }
    }
}
