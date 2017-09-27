package com.example.per6.quiz;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by per6 on 9/15/17.
 */

public class Questioning implements Parcelable {
    private String questionText;
    private boolean answer;

    public Questioning(String questionText, int questionId, boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    protected Questioning(Parcel in) {
        questionText = in.readString();
        answer = in.readByte() != 0;
    }

    public static final Creator<Questioning> CREATOR = new Creator<Questioning>() {
        @Override
        public Questioning createFromParcel(Parcel in) {
            return new Questioning(in);
        }

        @Override
        public Questioning[] newArray(int size) {
            return new Questioning[size];
        }
    };


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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(questionText);
        parcel.writeByte((byte) (answer ? 1 : 0));
    }
}
