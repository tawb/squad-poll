package visitor;

import domain.Poll;

public interface PollVisitor {
    void visit(Poll poll);
}