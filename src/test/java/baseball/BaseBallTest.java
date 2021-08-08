package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BaseBallTest {

    private BaseBall computer;

    @BeforeEach
    void setUp() {
        computer = new BaseBall(Arrays.asList(4, 5, 6));
    }

    @Test
    @DisplayName("스트라이크 1 볼 1")
    void strike_1_ball_1() {
        BaseBall player = new BaseBall(Arrays.asList(4, 6, 7));
        PlayResult result = computer.play(player.getBalls());

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크 0 볼 0")
    void nothing() {
        BaseBall player = new BaseBall(Arrays.asList(1, 2, 3));
        PlayResult result = computer.play(player.getBalls());

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 3")
    void ball_3() {
        BaseBall player = new BaseBall(Arrays.asList(5, 6, 4));
        PlayResult result = computer.play(player.getBalls());

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크 3")
    void strike_3() {
        BaseBall player = new BaseBall(Arrays.asList(4, 5, 6));
        PlayResult result = computer.play(player.getBalls());

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }
}
