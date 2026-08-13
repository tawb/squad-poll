package decorator;

import composite.PollComponent;
import flyweight.*;

public class HotPollDecorator extends PollDecorator {
    public HotPollDecorator(PollComponent wrapped) {
        super(wrapped);
    }

    @Override
    public String describe() {
        return IconFactory.get("🔥").getSymbol() + " " + wrapped.describe();
    }
}