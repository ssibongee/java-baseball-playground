package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.BallStatus.*;
import static org.assertj.core.api.Assertions.*;

public class BallTest {

    private Ball computer;

    @BeforeEach
    void setUp() {
        computer = new Ball(1, 4);
    }

    @Test
    @DisplayName("입력받은 숫자가 1~9 사이의 값인지 테스트")
    void isValidNumber() {
        assertThat(Ball.isValid(1)).isTrue();
        assertThat(Ball.isValid(9)).isTrue();
        assertThat(Ball.isValid(0)).isFalse();
        assertThat(Ball.isValid(10)).isFalse();
    }

    @Test
    @DisplayName("컴퓨터와 플레이어 숫자의 위치와 값이 모두 일치하지 않을 경우 NOTHING")
    void nothing() {
        assertThat(computer.play(new Ball(2, 5))).isEqualTo(NOTHING);
    }

    @Test
    @DisplayName("컴퓨터와 플레이어 숫자의 값이 일치할 경우 BALL")
    void ball() {
        assertThat(computer.play(new Ball(2, 4))).isEqualTo(BALL);
    }

    @Test
    @DisplayName("컴퓨터와 플레이어 숫자의 위치와 값이 모두 일치할 경우 STRKIE")
    void strike() {
        assertThat(computer.play(new Ball(1, 4))).isEqualTo(STRIKE);
    }
}
