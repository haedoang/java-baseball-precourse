package baseball.vo;

/**
 * date : 2021.10.04
 * Author : haedong kim
 * Description : Baseball VO
 */
public class Baseball {
    private String[] numbers;
    private Status status;

    public Baseball() {
        this.status = Status.START;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public void setNumbers(String[] numbers) {
        this.numbers = numbers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
