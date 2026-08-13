package state;

import domain.Poll;
import domain.PollStatus;

public class ClosedState implements PollState {
    @Override
    public void vote(Poll poll, String friendName, String optionId) {
        System.out.println("Poll \"" + poll.getQuestion() + "\" is closed. Vote rejected.");
    }

    @Override
    public void close(Poll poll) {
        System.out.println("Poll is already closed.");
    }

    @Override
    public PollStatus getStatus() {
        return PollStatus.CLOSED;
    }
}