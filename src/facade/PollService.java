package facade;

import registry.PollRegistry;
import uifactory.ConsolePollUIFactory;
import uifactory.PollUIFactory;
public class PollService {
    private final PollRegistry registry = PollRegistry.getInstance();
    private final PollUIFactory uiFactory = new ConsolePollUIFactory();
}