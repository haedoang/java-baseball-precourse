package baseball.ui;

import baseball.vo.Status;

/**
 * date : 2021.10.04
 * Author : haedong kim
 * Description : BaseUI
 */
public interface BaseUI {

    void init();

    void start();

    void stop();

    String input(String msg, Status status);
}
