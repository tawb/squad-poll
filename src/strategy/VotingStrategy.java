package strategy;
import domain.Poll;
import domain.PollOption;
public interface VotingStrategy {
    PollOption decide(Poll poll);
}
