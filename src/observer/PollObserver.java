package observer;

//////contract for anything that want to be notified about poll events
public interface PollObserver {
    void update(String message);
}