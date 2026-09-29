package adapter;

import domain.Poll;

public interface PollSource {
    Poll toPoll();
}