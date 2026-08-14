package chain;
//////abstract class instead of interface it let all handlers share the
//////same "next" pointer and setNext() logic without repeating it in each one
import domain.PollOption;
import java.util.List;

/////base handler in the tiebreaker chain ,each handler tries to resolve
/////the tie, or passes it to the next handler if it cant
public abstract class Tiebreaker {
    protected Tiebreaker next;

    public void setNext(Tiebreaker next) {
        this.next = next;
    }

    public abstract PollOption resolve(List<PollOption> tiedOptions);
}