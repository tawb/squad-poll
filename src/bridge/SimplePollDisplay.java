package bridge;

import domain.Poll;

public class SimplePollDisplay extends PollDisplay {
    public SimplePollDisplay(DisplayRenderer renderer) {
        super(renderer);
    }

    @Override
    public void show(Poll poll) {
        renderer.writeLine(poll.getQuestion() + " — " + poll.getOptions().size() + " options");
    }
}