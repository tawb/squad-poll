package observer;

//// simple observer representing one friend who receives notifications
public class FriendObserver implements PollObserver {
    private final String friendName;

    public FriendObserver(String friendName) {
        this.friendName = friendName;
    }

    @Override
    public void update(String message) {
        System.out.println(friendName + " received notification: " + message);
    }
}