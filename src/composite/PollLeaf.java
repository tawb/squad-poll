package composite;

import domain.Poll;
import domain.PollStatus;

public class PollLeaf implements PollComponent {
    private final Poll poll;

    public PollLeaf(Poll poll) {
        this.poll = poll;
    }

    @Override
    public String describe() {
        return poll.getQuestion();
    }

    @Override
    public boolean isFullyClosed() {
        return poll.getStatus() == PollStatus.CLOSED;
    }
}