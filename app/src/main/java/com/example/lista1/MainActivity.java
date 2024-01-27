package com.example.lista1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private TextView question_number, question;
    private ProgressBar progressBar;
    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button next_button;
    private int score, index;


    @SuppressLint({"SuspiciousIndentation", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question_number = findViewById(R.id.questNum);
        question = findViewById(R.id.question);
        progressBar = findViewById(R.id.progress);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.radioButton1);
        option2 = findViewById(R.id.radioButton2);
        option3 = findViewById(R.id.radioButton3);
        option4 = findViewById(R.id.radioButton4);
        next_button = findViewById(R.id.button);

        if (question_number != null) {
            question_number.setText("Pytanie " + String.valueOf(index + 1) + "/10");
        }

        if (question != null)
            question.setText(QuestionsAnswers.Questions[index]);

        if ((option1 != null) && (option2 != null) && (option3 != null) && (option4 != null))
            option1.setText(QuestionsAnswers.Options[index][index]);
            option2.setText(QuestionsAnswers.Options[index][index + 1]);
            option3.setText(QuestionsAnswers.Options[index][index + 2]);
            option4.setText(QuestionsAnswers.Options[index][index + 3]);

        if (next_button != null) next_button.setOnClickListener(view -> {
            if (index < QuestionsAnswers.Questions.length-2) {
                index++;
                loadQuestion();
                points();
            }
            else {
                ending();
            }
        });
    }

    public void loadQuestion(){

        question_number.setText("Pytanie " + String.valueOf(index + 1) + "/10");
        question.setText(QuestionsAnswers.Questions[index]);
        option1.setText(QuestionsAnswers.Options[index][0]);
        option2.setText(QuestionsAnswers.Options[index][1]);
        option3.setText(QuestionsAnswers.Options[index][2]);
        option4.setText(QuestionsAnswers.Options[index][3]);

        int progressStatus = progressBar.getProgress() + 10;
        progressBar.setProgress(progressStatus);
    }
    public void points(){
        int selectedOptionId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedOption = findViewById(selectedOptionId);
        String selectedText = selectedOption.getText().toString();

        String correctAnswer = QuestionsAnswers.Answers[index];
        if (selectedText.equals(correctAnswer))
            score += 10;
    }
    public void ending(){

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }
}
