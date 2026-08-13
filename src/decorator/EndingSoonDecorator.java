package decorator;

import composite.PollComponent;

public class EndingSoonDecorator extends PollDecorator {
    public EndingSoonDecorator(PollComponent wrapped) {
        super(wrapped);
    }

    @Override
    public String describe() {
        return "⏰ " + wrapped.describe();
    }
}