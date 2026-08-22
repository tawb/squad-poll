package mediator;

import domain.Poll;
import command.CastVoteCommand;
import observer.PollObserver;

////coordinate voting,state checks,and notifications in the correct order
public class SquadSession {
    private final Poll poll;

    public SquadSession(Poll poll) {
        this.poll = poll;
    }

    /////single entry point for casting a vote handles the full sequence
    public void castVote(String friendName, String optionId) {
        CastVoteCommand command = new CastVoteCommand(poll, friendName, optionId);
        command.execute();
        poll.notifyObservers(friendName + " voted for " + optionId);
    }

    public void addFriend(PollObserver observer) {
        poll.addObserver(observer);
    }
}