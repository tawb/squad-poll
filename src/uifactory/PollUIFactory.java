package uifactory;

public interface PollUIFactory {
    PollPrompter createPrompter();
    ResultRenderer createRenderer();
}