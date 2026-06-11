package ivote;

import java.util.*;

public class SimulationDriver {

    //random answers
    static Random random = new Random();

    public static void main(String[] args) {

        VotingService service = new VotingService();

        //single choice question 
        System.out.println("Single Choice Question");
        Question q1 = new SingleChoiceQuestion(
                "What is the fastest animal in the world?",
                List.of("A. cheetah", "B. falcon", "C. dolphin", "D. deer")
        );
        runScenario(service, q1, 20);

        //mcq
        System.out.println("Multiple Choice Question");
        Question q2 = new MultipleChoiceQuestion(
                "Which of the following are car brands?",
                List.of("A. BMW", "B. Toyota", "C. Orchid", "D. Lexus")
        );
        runScenario(service, q2, 18);
    }

    //simulate the different question scenarios creating student subissions and displaying the results
    static void runScenario(VotingService service, Question question, int studentCount) {
        service.configure(question);

        List<String> options = question.getCandidateAnswers();

        for (int i = 1; i <= studentCount; i++) {
            Student student = new Student("S" + i);
            List<String> chosen;

            if (question.getQuestionType() == QuestionType.SINGLE_CHOICE) {
                chosen = List.of(options.get(random.nextInt(options.size())));
            } else {
                List<String> shuffled = new ArrayList<>(options);
                Collections.shuffle(shuffled);
                chosen = shuffled.subList(0, 1 + random.nextInt(shuffled.size()));
            }

            service.submit(student, chosen);
        }

        service.printStatistics();
    }
}