package command;

public interface VoteCommand {
    void execute();
    void undo();
}
////the command pattern ==> wraps an action (voting) as an object with execute() and undo()
////instead of a plain method call that leaves no trace.