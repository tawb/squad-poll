package memento;

import java.util.HashMap;
import java.util.Map;

////////a snapshot of a poll votes and status at one point in time
public class PollMemento {
    private final Map<String, String> votesSnapshot;
    private final String statusSnapshot;

    public PollMemento(Map<String, String> votes, String status) {
        ///////copy the map so future changes to the original dont affect this snapshot
        this.votesSnapshot = new HashMap<>(votes);
        this.statusSnapshot = status;
    }

    public Map<String, String> getVotesSnapshot() {
        return votesSnapshot;
    }

    public String getStatusSnapshot() {
        return statusSnapshot;
    }
}