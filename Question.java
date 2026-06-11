package ivote;

import java.util.List;

public abstract class Question {

//displat the text to the students and then list all of the answer choices, and the type of question
    private String promptText;
    private List<String> candidateAnswers;
    private QuestionType questionType;

    
    public Question(String promptText, List<String> candidateAnswers, QuestionType questionType) {
        this.promptText = promptText;
        this.candidateAnswers = candidateAnswers;
        this.questionType = questionType;
    }

    //return question prompts and text

    public String getPromptText() { return promptText; }

    public List<String> getCandidateAnswers() { return candidateAnswers; }

    public QuestionType getQuestionType() { return questionType; }

    public abstract boolean isValidAnswer(List<String> chosen);
}