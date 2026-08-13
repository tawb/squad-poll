package prototype;

import domain.Poll;
import domain.PollOption;
import java.util.ArrayList;
import java.util.List;

public class PollPrototype {

    public static Poll cloneAsTemplate(Poll source) {
        List<PollOption> clonedOptions = new ArrayList<>();
        for (PollOption option : source.getOptions()) {
            clonedOptions.add(new PollOption(option.getId(), option.getLabel()));
        }
        return new Poll(source.getQuestion(), clonedOptions);
    }
}