package baseball.ui;

import baseball.vo.Status;

public interface BaseUI {

    void init();

    void start();

    void stop();

    String input(String msg, Status status);
}
