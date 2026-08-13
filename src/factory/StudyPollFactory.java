package factory;
import flyweight.*;
public class StudyPollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return IconFactory.get("📚").getSymbol();
    }
}