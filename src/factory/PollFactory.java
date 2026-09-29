package factory;
import domain.Poll;
import domain.PollOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public abstract class PollFactory {
    protected abstract String categoryPrefix();//only for this package and any subclasses
    public final Poll createPoll(String question, List<String> optionLabels) {
        List<PollOption> options = IntStream.range(0, optionLabels.size())
                .mapToObj(i -> new PollOption("opt" + i, optionLabels.get(i)))
                .collect(Collectors.toList());
        Poll poll = new Poll(categoryPrefix() + " " + question, options);
        return poll;
    }


}