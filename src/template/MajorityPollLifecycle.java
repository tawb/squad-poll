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

            List<PollOption> tiedOptions = new ArrayList<>(poll.getOptions());
            winner = spin.resolve(tiedOptions);
        } else {
            System.out.println("Winner: " + winner.getLabel());
        }

        return winner;
    }
}