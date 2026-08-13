package state;

import domain.Poll;
import domain.PollStatus;

public interface PollState {
    void vote(Poll poll, String friendName, String optionId);
    void close(Poll poll);
    PollStatus getStatus();
}