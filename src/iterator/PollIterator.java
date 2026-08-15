package iterator;

import domain.PollOption;

public interface PollIterator {
    boolean hasNext();
    PollOption next();
}