package interpreter;
import mediator.SquadSession;

public class VoteInterpreter implements Interpreter{
    @Override
    public void interpret(String input, SquadSession session) {
        String[] parts = input.trim().split("\\s+");

        if (parts.length != 3 || !parts[0].equalsIgnoreCase("vote")) {
            System.out.println("invalid command, expected format=> vote <name> <option>");
            return;
        }

        String friendName = parts[1];
        String optionId = parts[2];

        session.castVote(friendName, optionId);
    }
}
