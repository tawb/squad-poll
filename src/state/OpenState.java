package state;

import domain.Poll;
import domain.PollStatus;

public class OpenState implements PollState {
    @Override
    public void vote(Poll poll, String friendName, String optionId) {
        poll.castVote(friendName, optionId);
    }

    @Override
    public void close(Poll poll) {
        poll.setStatus(PollStatus.CLOSED);
    }

    @Override
    public PollStatus getStatus() {
        return PollStatus.OPEN;
    }
}