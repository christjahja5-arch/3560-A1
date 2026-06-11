package ivote;

import java.util.List;

//accepts one or more answers

public class MultipleChoiceQuestion extends Question {

    public MultipleChoiceQuestion(String promptText, List<String> candidateAnswers) {
        super(promptText, candidateAnswers, QuestionType.MULTIPLE_CHOICE);
    }

  //atleast one option and no duplicates are chosen
    public boolean isValidAnswer(List<String> chosen) {
        if (chosen == null || chosen.isEmpty()) return false;
        long distinctCount = chosen.stream().distinct().count();
        if (distinctCount != chosen.size()) return false;
        //every selected option must be in the list
        return getCandidateAnswers().containsAll(chosen);
    }
}
