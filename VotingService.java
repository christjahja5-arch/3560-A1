package ivote;

import java.util.*;

public class VotingService {

    //stores the question and then links the student ID with their submissions

    private Question currentQuestion;
    private Map<String, List<String>> submissions = new LinkedHashMap<>();

    //clears old submissions while setting the new one

    public void configure(Question question) {
        this.currentQuestion = question;
        this.submissions.clear();
        System.out.println("Configured with: " + currentQuestion.getPromptText());
    }

    //replaces the previous submissions

    public void submit(Student student, List<String> chosenAnswers) {
        if (!currentQuestion.isValidAnswer(chosenAnswers)) {
            System.out.println("Invalid answer from " + student.getStudentId());
            return;
        }
        submissions.put(student.getStudentId(), chosenAnswers);
    }

    //counts all of the voting submissions and then displays it
    public void printStatistics() {
        System.out.println("\nResults");
        System.out.println("Question: " + currentQuestion.getPromptText());
        System.out.println("Total submissions: " + submissions.size());

        Map<String, Integer> tally = new LinkedHashMap<>();
        for (String option : currentQuestion.getCandidateAnswers()) {
            tally.put(option, 0);
        }

        for (List<String> answers : submissions.values()) {
            for (String answer : answers) {
                tally.put(answer, tally.get(answer) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : tally.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " vote(s)");
        }
    }
}
