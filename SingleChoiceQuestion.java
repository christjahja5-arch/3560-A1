package ivote;

import java.util.List;

//only accepts 1 answer
public class SingleChoiceQuestion extends Question {

    public SingleChoiceQuestion(String promptText, List<String> candidateAnswers) {
        super(promptText, candidateAnswers, QuestionType.SINGLE_CHOICE);
    }

   
    public boolean isValidAnswer(List<String> chosen) {
        if (chosen == null || chosen.size() != 1) return false;
        return getCandidateAnswers().contains(chosen.get(0));
    }
}
