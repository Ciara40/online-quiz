package domain;

/**
 * Created by usha on 4/16/2017.
 */
public class AnsweredQuestion {
    private String questionDetail;
    private String correctAns;
    private String selectedAns;
    private boolean correctness;

    public AnsweredQuestion(String questionDetail, String correctAns, String selectedAns, boolean correctness) {
        this.questionDetail = questionDetail;
        this.correctAns = correctAns;
        this.selectedAns = selectedAns;
        this.correctness = correctness;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public String getSelectedAns() {
        return selectedAns;
    }

    public boolean getCorrectness() {
        return correctness;
    }

    @Override
    public String toString() {
        return "AnsweredQuestion{" +
                "questionDetail='" + questionDetail + '\'' +
                ", correctAns='" + correctAns + '\'' +
                ", selectedAns='" + selectedAns + '\'' +
                ", correctness='" + correctness + '\'' +
                '}';
    }
}
