package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Ball.*;
import static baseball.BallStatus.*;

public class BaseBall {

    private final List<Ball> balls = new ArrayList<>();

    public BaseBall(List<Integer> numbers) {
        for (int i = 1; i <= MAX_LENGTH; i++) {
            balls.add(new Ball(i, numbers.get(i - 1)));
        }
    }

    public PlayResult play(List<Ball> playerBalls) {
        PlayResult result = new PlayResult();
        for (Ball ball : playerBalls) {
            result.report(play(ball));
        }
        return result;
    }

    private BallStatus play(Ball ball) {
        return balls.stream()
                .map(answer -> answer.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(NOTHING);
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
