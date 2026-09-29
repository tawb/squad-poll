package adapter;

public class OldSurveyForm {
    private final String prompt;
    private final String choicesRaw; // semicolon-separated,e.g "Pizza;Sushi;Tacos"

    public OldSurveyForm(String prompt, String choicesRaw) {
        this.prompt = prompt;
        this.choicesRaw = choicesRaw;
    }

    public String getPrompt() { return prompt; }
    public String getChoicesRaw() { return choicesRaw; }
}