package iterator;

import domain.PollOption;
import java.util.List;

/////concrete iterator that walk through a poll options list
public class PollOptionIterator implements PollIterator {
    private final List<PollOption> options;
    private int position = 0;

    public PollOptionIterator(List<PollOption> options) {
        this.options = options;
    }

    @Override
    public boolean hasNext() {
        return position < options.size();
    }

    @Override
    public PollOption next() {
        PollOption option = options.get(position);
        position++;
        return option;
    }
}