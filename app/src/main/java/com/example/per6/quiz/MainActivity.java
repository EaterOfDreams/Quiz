package com.example.per6.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.per6.quiz.R.id.textView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button trueButton, falseButton, nextButton;
    TextView questionText;
    List<Questioning> questionBank;
    int index, score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        intitQuestionBank();
        setListeners();
    }


    private void intitQuestionBank() {
        questionBank = new ArrayList();
        index = 0;
        for (int i = 0; i < 4; i++)
            questionBank.add(new Questioning(getString(getResources().getIdentifier("q" + i, "string", getPackageName())), i, i % 2 == 0));
    }

    private void wireWidgets() {
        trueButton = (Button) findViewById(R.id.button_true);
        falseButton = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(R.id.button_next);
        questionText = (TextView) findViewById(textView);

    }

    private void setListeners(){
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionBank.get(index).checkAnswer(true)){
                    score++;
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                }

                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionBank.get(index).checkAnswer(false))
                    score++;
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionBank.get(++index);
                questionText.setText(questionBank.get(index).getQuestionText());
                trueButton.setEnabled(true);
                falseButton.setEnabled(true);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
