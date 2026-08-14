package template;

import domain.Poll;
import domain.PollOption;

//////define the fixed sequence for running a poll from open to result,
///////with resolveWinner() left customizable by subclasses
public abstract class PollTemplate {

    //////the fixed order cannot be changed by subclasses
    public final void runPollLifecycle(Poll poll) {
        openPoll(poll);
        collectVotes(poll);
        closePoll(poll);
        PollOption winner = resolveWinner(poll);
        notifyResult(poll, winner);
    }

    protected void openPoll(Poll poll) {
        System.out.println("Poll opened: " + poll.getQuestion());
    }

    protected void collectVotes(Poll poll) {
        System.out.println("Collecting votes...");
    }

    protected void closePoll(Poll poll) {
        poll.setStatus(domain.PollStatus.CLOSED);
        System.out.println("Poll closed.");
    }

    protected abstract PollOption resolveWinner(Poll poll);

    protected void notifyResult(Poll poll, PollOption winner) {
        poll.notifyObservers("Winner: " + winner.getLabel());
    }
}