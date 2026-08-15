package interpreter;
import mediator.SquadSession;
//////contract for interpreting a text command and executing it

public interface Interpreter {
    void interpret(String input, SquadSession session);
}