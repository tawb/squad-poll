package builder;

import domain.Poll;
import domain.PollOption;
import java.util.ArrayList;
import java.util.List;

public class PollBuilder {
    private String question;
    private final List<PollOption> options = new ArrayList<>();
    private int optionCounter = 0;
    public PollBuilder question(String question) {
        this.question = question;
        return this;
    }

    public PollBuilder addOption(String label) {
        options.add(new PollOption("opt" + optionCounter, label));
        optionCounter++;
        return this;
    }
    public Poll build() {
        if (question == null || options.size() < 2) {
            throw new IllegalStateException("Poll needs a question and at least 2 options");
        }
        return new Poll(question, options);
    }
}