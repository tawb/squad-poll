import domain.Poll;
import factory.FoodPollFactory;
import builder.PollBuilder;
import java.util.List;
//////testing
public class Main {
    public static void main(String[] args) {
        Poll foodPoll = new FoodPollFactory().createPoll("Where to eat?", List.of("Pizza", "Sushi", "Tacos"));

        System.out.println(foodPoll.getQuestion());
        for (var option : foodPoll.getOptions()) {
            System.out.println(" - " + option.getLabel());
        }
        Poll moviePoll = new PollBuilder()
                .question("Movie night?")
                .addOption("Dune 3")
                .addOption("Barbie 2")
                .build();

        System.out.println(moviePoll.getQuestion());
        for (var option : moviePoll.getOptions()) {
            System.out.println(" - " + option.getLabel());
        }
    }
}