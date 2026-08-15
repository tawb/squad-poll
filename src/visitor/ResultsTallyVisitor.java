package visitor;

import domain.Poll;
import domain.PollOption;

import java.util.HashMap;
import java.util.Map;

public class ResultsTallyVisitor implements PollVisitor {

    @Override
    public void visit(Poll poll) {
        ///////empty map to count votes per option before display results
        Map<String, Integer> tally = new HashMap<>();
        /////loop through every vote cast ignoring who voted only which option

        for (String optionId : poll.getVotes().values()) {
            //////increment this option count by 1 or start at 1 if its new

            tally.merge(optionId, 1, Integer::sum);
        }

        /////print poll question as the results header
        System.out.println("Results for: " + poll.getQuestion());

/////loop through all options (not just ones with votes) so 0-vote options still show
        for (PollOption option : poll.getOptions()) {
            ////default to 0 if this option got no votes at all
            int votes = tally.getOrDefault(option.getId(), 0);
            System.out.println("- " + option.getLabel() + " (" + option.getId() + "): " + votes + " votes");
        }
    }
}