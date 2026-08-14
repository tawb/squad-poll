package strategy;

import domain.Poll;
import domain.PollOption;

import java.util.HashMap;
import java.util.Map;

public class MajorityVotingStrategy implements VotingStrategy {

    @Override
    public PollOption decide(Poll poll) {
        Map<String, Integer> tally = new HashMap<>();

        for (String optionId : poll.getVotes().values()) {
            tally.merge(optionId, 1, Integer::sum);
        }

        PollOption winner = null;
        int highest = 0;
        boolean tie = false;

        for (PollOption option : poll.getOptions()) {
            int votes = tally.getOrDefault(option.getId(), 0);

            if (votes > highest) {
                highest = votes;
                winner = option;
                tie = false;
            } else if (votes == highest && votes > 0) {
                tie = true;
            }
        }

        return tie ? null : winner;
    }
}