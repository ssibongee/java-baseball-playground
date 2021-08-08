package baseball;

import java.util.Objects;

import static baseball.BallStatus.*;

public class Ball {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int MAX_LENGTH = 3;

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("1에서 9사이의 숫자만 입력할 수 있습니다.");
        }

        this.position = position;
        this.number = number;
    }

    public static boolean isValid(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return STRIKE;
        }

        if (this.number == ball.getNumber()) {
            return BALL;
        }

        return NOTHING;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position &&
                number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
