package template;
import domain.Poll;
import domain.PollOption;
import strategy.VotingStrategy;
import strategy.MajorityVotingStrategy;
import chain.Tiebreaker;
import chain.Spin;
import chain.SuddenDeath;
import chain.Veto;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class MajorityPollLifecycle extends PollTemplate {
    @Override
    protected PollOption resolveWinner(Poll poll) {
        VotingStrategy strategy = new MajorityVotingStrategy();
        PollOption winner = strategy.decide(poll);
        if (winner == null) {
            System.out.println("Tie detected escalating to tiebreaker chain...");
            Tiebreaker spin = new Spin();
            Tiebreaker suddenDeath = new SuddenDeath();
            Tiebreaker veto = new Veto();
            spin.setNext(suddenDeath);
            suddenDeath.setNext(veto);
            List<PollOption> tiedOptions = findTiedOptions(poll);
            winner = spin.resolve(tiedOptions);
        } else {
            System.out.println("Winner: " + winner.getLabel());
        }

        return winner;
    }
    private List<PollOption> findTiedOptions(Poll poll) {
        Map<String, Integer> tally = new HashMap<>();
        for (String optionId : poll.getVotes().values()) {
            tally.merge(optionId, 1, Integer::sum);
        }
        int highest = 0;
        for (int count : tally.values()) {
            if (count > highest) {
                highest = count;
            }
        }
        List<PollOption> tied = new ArrayList<>();
        for (PollOption option : poll.getOptions()) {
            int votes = tally.getOrDefault(option.getId(), 0);
            if (votes == highest && votes > 0) {
                tied.add(option);
            }
        }
        return tied;
    }
}