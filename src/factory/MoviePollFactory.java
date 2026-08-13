package factory;
import flyweight.*;
public class MoviePollFactory extends PollFactory{
    @Override
    protected String categoryPrefix() {
        return IconFactory.get("🎬").getSymbol();
    }
}
