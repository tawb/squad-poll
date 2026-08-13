package state;

import domain.PollStatus;

public class PollStateFactory {
    public static PollState getState(PollStatus status) {
        switch (status) {
            case OPEN: return new OpenState();
            case CLOSED: return new ClosedState();
            case TIEBREAKER: return new TiebreakerState();
            default: throw new IllegalArgumentException("Unknown status: " + status);
        }
    }
}
//////that responsabile about create pollstate objects to
/////use them to know the state of the poll