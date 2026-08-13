package domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import state.PollStateFactory;
import state.PollState;
import java.util.UUID;//Universally Unique Identifier

public class Poll {
    private final String id;
    private final String question;
    private final List<PollOption> options;
    private final Map<String, String> votes;
    private PollStatus status;
    public Poll(String question, List<PollOption> options) {
        this.id = UUID.randomUUID().toString().substring(0, 8);//each id is 8 chars enough for our program
        this.question = question;
        this.options = options;
        this.votes = new HashMap<>();
        this.status = PollStatus.OPEN;
    }
    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<PollOption> getOptions() {
        return options;
    }

    public Map<String, String> getVotes() {
        return votes;
    }

    public PollStatus getStatus() {
        return status;
    }
    public void setStatus(PollStatus status) {
        this.status = status;
    }
    public void castVote(String friendName, String optionId) {
        votes.put(friendName, optionId);
    }
    public void vote(String friendName, String optionId) {
        PollState currentState = PollStateFactory.getState(status);
        currentState.vote(this, friendName, optionId);
    }
}
