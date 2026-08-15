package memento;

import java.util.ArrayList;
import java.util.List;

///////store a history of poll snapshots without knowing their contents
public class PollHistory {
    private final List<PollMemento> snapshots = new ArrayList<>();

    public void save(PollMemento memento) {
        snapshots.add(memento);
    }

    public PollMemento getLast() {
        if (snapshots.isEmpty()) {
            return null;
        }
        return snapshots.remove(snapshots.size() - 1);
    }
}