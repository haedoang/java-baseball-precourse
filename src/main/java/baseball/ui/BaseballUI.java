package baseball.ui;

import baseball.service.BaseballService;
import baseball.service.BaseballServiceImpl;
import baseball.utils.Constants;
import baseball.vo.Baseball;
import baseball.vo.Status;
import nextstep.utils.Console;

public class BaseballUI implements BaseUI {
    Baseball baseball;
    BaseballService service;

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
        String input = this.input(Constants.MSG_INPUT_NUMBER, baseball.getStatus());
        String resultMsg = this.service.play(baseball, input);
        System.out.println(resultMsg);
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    @Override
    public String input(String msg, Status status) {
        System.out.print(msg);
        String input = Console.readLine();
        if(!this.service.validate(input, status)) {
            System.out.println("validate false");
            this.input(msg, status);
        }
        return input;
    }
}
