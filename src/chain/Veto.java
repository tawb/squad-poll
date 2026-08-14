package chain;

import domain.PollOption;
import java.util.List;

/////leader pick the winner manually always resolves
public class Veto extends Tiebreaker {
    @Override
    public PollOption resolve(List<PollOption> tiedOptions) {
        System.out.println("Leader is deciding via veto...");
        if (!tiedOptions.isEmpty()) {
            return tiedOptions.get(0); ////leader choice simplify as first option
        }
        return null;
    }
}