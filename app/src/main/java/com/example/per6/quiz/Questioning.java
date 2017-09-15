package com.example.per6.quiz;

/**
 * Created by per6 on 9/15/17.
 */

public class Questioning {
    private String questionText;
    private boolean answer;

    public Questioning(String questionText, int questionId, boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean isAnswer() {
        return answer;
    }

    /**
     * @param userAnswer what the user selected
     * @return true if answers match, false otherwise
     */
    public boolean checkAnswer (boolean userAnswer) {
        return answer == userAnswer;
    }
}
