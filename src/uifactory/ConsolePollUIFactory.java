//Abstract Factory
package uifactory;
public class ConsolePollUIFactory implements PollUIFactory {
    @Override
    public PollPrompter createPrompter() {
        return new ConsolePrompter();
    }

    @Override
    public ResultRenderer createRenderer() {
        return new ConsoleResultRenderer();
    }
}
//if i have other types rather than the console then i make new classes that implement
// the prompter and the renderer, and a new factory class that implements poll ui factory
// and overrides create prompter and create renderer to return them
//later in the code i dont have to worry about the prompter/ renderer not matching because
// i have this implementation