package decorator;

import composite.PollComponent;
import flyweight.*;import flyweight.*;
public class EndingSoonDecorator extends PollDecorator {
    public EndingSoonDecorator(PollComponent wrapped) {
        super(wrapped);
    }

    @Override
    public String describe() {
        return IconFactory.get("⏰").getSymbol() + " " + wrapped.describe();
    }
}