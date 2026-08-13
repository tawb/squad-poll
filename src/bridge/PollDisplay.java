package bridge;

import domain.Poll;

public abstract class PollDisplay {
    protected final DisplayRenderer renderer;

    protected PollDisplay(DisplayRenderer renderer) {
        this.renderer = renderer;
    }

    public abstract void show(Poll poll);
}