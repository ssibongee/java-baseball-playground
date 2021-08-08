package baseball;

import java.util.*;

import static baseball.Ball.*;

public class RandomGenerator {

    public static List<Integer> getRandomNumbers() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < MAX_LENGTH) {
            set.add(random.nextInt(9) + 1);
        }
        return new ArrayList<>(set);
    }
}
