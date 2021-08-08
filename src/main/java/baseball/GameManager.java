package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static baseball.Ball.*;
import static baseball.RandomGenerator.*;

public class GameManager {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BaseBall computer = new BaseBall(getRandomNumbers());

    public void start() {
        BillBoard.start();
        while (!play()) {

        }
        BillBoard.success();
        BillBoard.end();
    }

    public boolean play() {
        BaseBall player = new BaseBall(reader());
        PlayResult result = computer.play(player.getBalls());
        BillBoard.showResult(result);
        return result.getStrike() == MAX_LENGTH;
    }

    public List<Integer> reader() {
        List<Integer> balls = new ArrayList<>();
        try {
            String input = in.readLine().replace(" ", "");
            String[] numbers = input.split("");
            for (String number : numbers) {
                balls.add(Integer.parseInt(number));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balls;
    }


}
