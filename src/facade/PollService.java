package facade;

import registry.PollRegistry;
import uifactory.ConsolePollUIFactory;
import uifactory.PollUIFactory;
import domain.Poll;
import factory.PollFactory;
import java.util.List;
public class PollService {
    private final PollRegistry registry = PollRegistry.getInstance();
    private final PollUIFactory uiFactory = new ConsolePollUIFactory();
    public Poll createPoll(PollFactory factory, String question, List<String> options) {
        Poll poll = factory.createPoll(question, options);
        registry.register(poll);
        return poll;
    }
}