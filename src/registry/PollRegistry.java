//singleton
package registry;

import domain.Poll;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
public class PollRegistry {

    private static PollRegistry instance;
    private final Map<String, Poll> polls = new HashMap<>();
    private PollRegistry() {
    }
    public static synchronized PollRegistry getInstance() {//synchronized prevents two parts to run this method at the exact same moment
        if (instance == null) {
            instance = new PollRegistry();
        }
        return instance;
    }
    public void register(Poll poll) {
        polls.put(poll.getId(), poll);
    }
    public Optional<Poll> find(String pollId) {//optional in case there is no poll that have this id
        return Optional.ofNullable(polls.get(pollId));
    }

}