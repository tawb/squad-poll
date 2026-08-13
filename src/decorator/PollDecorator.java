package decorator;

import composite.PollComponent;

public abstract class PollDecorator implements PollComponent {
    protected final PollComponent wrapped;

    protected PollDecorator(PollComponent wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public boolean isFullyClosed() {
        return wrapped.isFullyClosed();
    }
}