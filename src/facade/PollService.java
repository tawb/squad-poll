package facade;

import registry.PollRegistry;
import uifactory.ConsolePollUIFactory;
import uifactory.PollUIFactory;
import domain.Poll;
import factory.PollFactory;
import java.util.List;
import builder.PollBuilder;
import domain.PollStatus;
public class PollService {
    private final PollRegistry registry = PollRegistry.getInstance();
    private final PollUIFactory uiFactory = new ConsolePollUIFactory();
    public Poll createPoll(PollFactory factory, String question, List<String> options) {
        Poll poll = factory.createPoll(question, options);
        registry.register(poll);
        return poll;
    }
    public Poll createFreeformPoll(String question, String... options) { //the string ...:It lets the caller pass in any number of separate String arguments
        PollBuilder builder = new PollBuilder().question(question);
        for (String option : options) {
            builder.addOption(option);
        }
        Poll poll = builder.build();
        registry.register(poll);
        return poll;
    }
    // TODO:  i will uncomment once state branch is merged in
    // public void vote(String pollId, String friendName, String optionId) {
    //     registry.find(pollId).ifPresent(poll -> poll.vote(friendName, optionId));
    // }
    public void close(String pollId) {
        registry.find(pollId).ifPresent(poll -> poll.setStatus(PollStatus.CLOSED));
    }
}