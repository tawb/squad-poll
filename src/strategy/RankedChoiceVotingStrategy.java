package strategy;

import domain.Poll;
import domain.PollOption;

import java.util.HashMap;
import java.util.Map;

public class RankedChoiceVotingStrategy implements VotingStrategy {

    @Override
    public PollOption decide(Poll poll) {
        Map<String, Integer> tally = new HashMap<>();

        for (String optionId : poll.getVotes().values()) {
            tally.merge(optionId, 1, Integer::sum);
        }

        int totalVotes = poll.getVotes().size();
        int majorityThreshold = totalVotes / 2 + 1;

        for (PollOption option : poll.getOptions()) {
            int votes = tally.getOrDefault(option.getId(), 0);
            if (votes >= majorityThreshold) {
                return option;
            }
        }

        return null;
    }
}