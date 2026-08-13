package adapter;

import domain.Poll;
import domain.PollOption;
import java.util.ArrayList;
import java.util.List;

public class SurveyFormAdapter implements PollSource {
    private final OldSurveyForm legacy;

    public SurveyFormAdapter(OldSurveyForm legacy) {
        this.legacy = legacy;
    }

    @Override
    public Poll toPoll() {
        String[] rawChoices = legacy.getChoicesRaw().split(";");
        List<PollOption> options = new ArrayList<>();
        int i = 0;
        for (String choice : rawChoices) {
            options.add(new PollOption("opt" + i, choice.trim()));
            i++;
        }
        return new Poll(legacy.getPrompt(), options);
    }
}