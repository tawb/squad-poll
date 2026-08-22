package chain;

import domain.PollOption;
import java.util.List;
import java.util.Random;

////pick a random option from the tied ones
public class Spin extends Tiebreaker {
    private final Random random = new Random();
    @Override
    public PollOption resolve(List<PollOption> tiedOptions) {
        System.out.println("Spinning the wheel...");
        if (!tiedOptions.isEmpty()) {
            int index = random.nextInt(tiedOptions.size());
            PollOption winner = tiedOptions.get(index);
            System.out.println("Wheel landed on: " + winner.getLabel());
            return winner;
        }
        return null;
    }
}
