package command;

import domain.Poll;

public class CastVoteCommand implements VoteCommand {
    private final Poll poll;///which poll this vote belongs to
    private final String friendName;////who vote?
    private final String optionId;/////what they voted for
    private String previousOptionId;///this is memory for undo
    /// "what did they vote before this?"
//constructor
    public CastVoteCommand(Poll poll, String friendName, String optionId) {
        this.poll = poll;
        this.friendName = friendName;
        this.optionId = optionId;
    }

    @Override
    public void execute() {
        previousOptionId = poll.getVotes().get(friendName);
        poll.vote(friendName, optionId);
    }

    @Override
    public void undo() {
        if (previousOptionId != null) {
            poll.getVotes().put(friendName, previousOptionId);
        } else {
            poll.getVotes().remove(friendName);
        }
    }
}