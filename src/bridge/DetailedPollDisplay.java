package bridge;

import domain.Poll;
import domain.PollOption;

public class DetailedPollDisplay extends PollDisplay {
    public DetailedPollDisplay(DisplayRenderer renderer) {
        super(renderer);
    }
//prints detailed poll
    @Override
    public void show(Poll poll) {
        renderer.writeLine("Question: " + poll.getQuestion());
        renderer.writeLine("Status: " + poll.getStatus());
        for (PollOption option : poll.getOptions()) {
            renderer.writeLine("  - " + option.getLabel());
        }
    }
}