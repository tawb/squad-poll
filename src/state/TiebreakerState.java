package state;

import domain.Poll;
import domain.PollStatus;
////tiebreakerState represent the poll when voting has ended in a tie
////and the app is running the escalation process (spin,sudden death,veto)
////to determine a winner no new votes are accepte in this state
public class TiebreakerState implements PollState {
    @Override
    public void vote(Poll poll, String friendName, String optionId) {
        System.out.println("Voting ended — poll is in tiebreaker mode.");
    }

    @Override
    public void close(Poll poll) {
        poll.setStatus(PollStatus.CLOSED);
    }

    @Override
    public PollStatus getStatus() {
        return PollStatus.TIEBREAKER;
    }
}