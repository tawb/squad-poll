package decorator;

import composite.PollComponent;


public class HotPollDecorator extends PollDecorator {
    public HotPollDecorator(PollComponent wrapped) {
        super(wrapped);
    }

    @Override
    public String describe() {
        return "🔥 " + wrapped.describe();
    }
}