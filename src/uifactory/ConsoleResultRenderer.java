package uifactory;

import domain.Poll;
import domain.PollOption;

public class ConsoleResultRenderer implements ResultRenderer {
    @Override
    public void render(Poll poll) {
        System.out.println("== " + poll.getQuestion() + " ==");
        for (PollOption option : poll.getOptions()) {
            long count = poll.getVotes().values().stream()
                    .filter(v -> v.equals(option.getId()))
                    .count();
            System.out.println("  " + option.getLabel() + ": " + count + " votes");
        }
    }
}