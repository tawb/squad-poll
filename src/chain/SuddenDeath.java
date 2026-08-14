package chain;

import domain.PollOption;
import java.util.List;

/////placeholder for a quick revote among tied options
public class SuddenDeath extends Tiebreaker {
    @Override
    public PollOption resolve(List<PollOption> tiedOptions) {
        System.out.println("Running sudden-death round...");
        ////in a full implementation this would trigger a new quick vote
        /////for now pass along if it can't resolve on its own
        return next != null ? next.resolve(tiedOptions) : null;
    }
}