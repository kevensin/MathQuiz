package com.example.keven.mathquiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    public TextView[] textTitleQuestions = new TextView[5];
    public TextView[] textQuestions = new TextView[5];
    public String[] questions = {"Which options give me 3?\nCheck the following which you believe to be true"
            , "What is 2+2?\nType in the answer below"
            , "What is 9-2\nClick an option below"
            , "Fill in the blank below"
            , "Is the below true or false\n1 + 2 + 4 + 3 = 9"};

    public CheckBox[] optionsQuestion1 = new CheckBox[4];
    public String[] stringOptionsQuestion1 = {"1+2", "1+1+1", "3+1", "3+0"};
    public boolean[] optionsQuestion1State = new boolean[4];
    public boolean checked;

    public EditText editTextAnswerQuestion2;
    public String stringAnswerQuestion2;
    public int intAnswerQuestion2;

    public Button[] optionsQuestion3 = new Button[4];
    public int[] intOptionsQuestion3 = {3, 7, 1, 4};
    public boolean[] optionsEnabledQuestion3 = new boolean[4];

    public EditText editTextAnswerQuestion4;
    public TextView beforeEditTextQuestions4, afterEditTextQuestion4;
    public String stringAnswerQuestion4;
    public int intAnswerQuestion4;

    public Button[] optionsQuestion5 = new Button[2];
    public boolean[] optionsEnabledQuestion5 = new boolean[2];
    public String[] stringOptionsQuestion5 = {"true", "false"};

    public boolean question1Correct, question2Correct, question3Correct, question4Correct, question5Correct;
    public int question1Score, question2Score, question3Score, question4Score, question5Score, questionsFinalScore = 0;
    public Button buttonFinalGrade;
    public TextView textFinalGrade;
    public ImageView finalImage;
    public Resources res;

    public LinearLayout[] layout = new LinearLayout[5];
    public Button[] buttonChangeQuestion = new Button[4];
    public String stringChangeQuestion = "To problem ";
    public Button[] buttonOpenProblem = new Button[5];
    public boolean openProblemState1=true, openProblemState2, openProblemState3,
            openProblemState4,openProblemState5 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);

        textTitleQuestions[0] = findViewById(R.id.textTitleProblem1);
        textTitleQuestions[1] = findViewById(R.id.textTitleProblem2);
        textTitleQuestions[2] = findViewById(R.id.textTitleProblem3);
        textTitleQuestions[3] = findViewById(R.id.textTitleProblem4);
        textTitleQuestions[4] = findViewById(R.id.textTitleProblem5);

        textQuestions[0] = findViewById(R.id.textQuestionProblem1);
        textQuestions[1] = findViewById(R.id.textQuestionProblem2);
        textQuestions[2] = findViewById(R.id.textQuestionProblem3);
        textQuestions[3] = findViewById(R.id.textQuestionProblem4);
        textQuestions[4] = findViewById(R.id.textQuestionProblem5);
        for (int i = 0; i < textTitleQuestions.length; i++) {
            textTitleQuestions[i].setText("Problem " + (i + 1));
            textQuestions[i].setText(questions[i]);
        }


        optionsQuestion1[0] = findViewById(R.id.checkBox1Problem1);
        optionsQuestion1[1] = findViewById(R.id.checkBox2Problem1);
        optionsQuestion1[2] = findViewById(R.id.checkBox3Problem1);
        optionsQuestion1[3] = findViewById(R.id.checkBox4Problem1);
        for (int i = 0; i < optionsQuestion1.length; i++)
            optionsQuestion1[i].setText(stringOptionsQuestion1[i]);

        editTextAnswerQuestion2 = findViewById(R.id.edtTxtQuestion2);
        editTextAnswerQuestion2.setText("" + 0);

        optionsQuestion3[0] = findViewById(R.id.button1Question3);
        optionsQuestion3[1] = findViewById(R.id.button2Question3);
        optionsQuestion3[2] = findViewById(R.id.button3Question3);
        optionsQuestion3[3] = findViewById(R.id.button4Question3);
        for (int i = 0; i < optionsQuestion3.length; i++)
            optionsQuestion3[i].setText("" + intOptionsQuestion3[i]);


        beforeEditTextQuestions4 = findViewById(R.id.textQuestionProblem4_piece1);
        beforeEditTextQuestions4.setText("5 - ");
        editTextAnswerQuestion4 = findViewById(R.id.edtTxtQuestion4);
        editTextAnswerQuestion4.setText("" + 0);
        afterEditTextQuestion4 = findViewById(R.id.textQuestionProblem4_piece2);
        afterEditTextQuestion4.setText(" = 2");

        optionsQuestion5[0] = findViewById(R.id.option1Question5);
        optionsQuestion5[1] = findViewById(R.id.option2Question5);
        for (int i = 0; i < optionsQuestion5.length; i++)
            optionsQuestion5[i].setText(stringOptionsQuestion5[i]);

        layout[0] = findViewById(R.id.layout1);
        layout[1] = findViewById(R.id.layout2);
        layout[2] = findViewById(R.id.layout3);
        layout[3] = findViewById(R.id.layout4);
        layout[4] = findViewById(R.id.layout5);
        layout[0].setVisibility(View.VISIBLE);
        for (int i = 1; i < layout.length; i++) layout[i].setVisibility(View.GONE);

        buttonChangeQuestion[0] = findViewById(R.id.buttonToQuestion2);
        buttonChangeQuestion[1] = findViewById(R.id.buttonToQuestion3);
        buttonChangeQuestion[2] = findViewById(R.id.buttonToQuestion4);
        buttonChangeQuestion[3] = findViewById(R.id.buttonToQuestion5);
        for(int i=0;i<buttonChangeQuestion.length;i++)buttonChangeQuestion[i].setText(stringChangeQuestion + (i+2));

        buttonOpenProblem[0] = findViewById(R.id.openProblem1);
        buttonOpenProblem[1] = findViewById(R.id.openProblem2);
        buttonOpenProblem[2] = findViewById(R.id.openProblem3);
        buttonOpenProblem[3] = findViewById(R.id.openProblem4);
        buttonOpenProblem[4] = findViewById(R.id.openProblem5);
        buttonOpenProblem[0].setText("close");
        for(int i=1;i<buttonOpenProblem.length;i++)buttonOpenProblem[i].setText("open");


        buttonFinalGrade = findViewById(R.id.buttonFinalizeQuiz);
        textFinalGrade = findViewById(R.id.textFinalScore);
        finalImage = findViewById(R.id.imageFinalScore);
        res = getResources();

        buttonFinalGrade.setText("FINISH");
        buttonFinalGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getQuestion1States() == true) question1Score = 1;
                else question1Score = 0;
                if (getQuestion2State() == true) question2Score = 1;
                else question2Score = 0;
                if (getQuestion3State() == true) question3Score = 1;
                else question3Score = 0;
                if (getQuestion4State() == true) question4Score = 1;
                else question4Score = 0;
                if (getQuestion5State() == true) question5Score = 1;
                else question5Score = 0;
                questionsFinalScore = question1Score + question2Score + question3Score
                        + question4Score + question5Score;
                if(questionsFinalScore<=2)finalImage.setImageDrawable(res.getDrawable(R.drawable.image_4));
                else if(questionsFinalScore==3)finalImage.setImageDrawable(res.getDrawable(R.drawable.image_2));
                else finalImage.setImageDrawable(res.getDrawable(R.drawable.image_3));
                textFinalGrade.setText("Yout got " + questionsFinalScore + "/5 correct");
            }
        });
    }

    public void openProblems(View v)
    {
            switch (v.getId())
            {
                case R.id.buttonToQuestion2:
                    openProblemState1=false;
                    buttonOpenProblem[0].setText("open");
                    openProblemState2=true;
                    buttonOpenProblem[1].setText("close");
                    layout[1].setVisibility(View.VISIBLE);
                    layout[0].setVisibility(View.GONE);
                    layout[1].setVisibility(View.VISIBLE);
                    break;
                case R.id.buttonToQuestion3:
                    openProblemState2=false;
                    buttonOpenProblem[1].setText("open");
                    openProblemState3=true;
                    buttonOpenProblem[2].setText("close");
                    layout[1].setVisibility(View.GONE);
                    layout[2].setVisibility(View.VISIBLE);
                    break;
                case R.id.buttonToQuestion4:
                    openProblemState3=false;
                    buttonOpenProblem[2].setText("open");
                    openProblemState4=true;
                    buttonOpenProblem[3].setText("close");
                    layout[2].setVisibility(View.GONE);
                    layout[3].setVisibility(View.VISIBLE);
                    break;
                case R.id.buttonToQuestion5:
                    openProblemState4=false;
                    buttonOpenProblem[3].setText("open");
                    openProblemState5=true;
                    buttonOpenProblem[4].setText("close");
                    layout[3].setVisibility(View.GONE);
                    layout[4].setVisibility(View.VISIBLE);
                    break;
                case R.id.openProblem1:
                    if(openProblemState1==true)
                    {
                        layout[0].setVisibility(View.GONE);
                        buttonOpenProblem[0].setText("open");
                        openProblemState1=false;
                    }
                    else
                    {
                        openProblemState1=true;
                        buttonOpenProblem[0].setText("close");
                        layout[0].setVisibility(View.VISIBLE);
                    }
                        break;
                case R.id.openProblem2:
                    if(openProblemState2==true)
                    {
                        layout[1].setVisibility(View.GONE);
                        buttonOpenProblem[1].setText("open");
                        openProblemState2=false;
                    }
                    else
                    {
                        openProblemState2=true;
                        buttonOpenProblem[1].setText("close");
                        layout[1].setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.openProblem3:
                    if(openProblemState3==true)
                    {
                        layout[2].setVisibility(View.GONE);
                        buttonOpenProblem[2].setText("open");
                        openProblemState3=false;
                    }
                    else
                    {
                        openProblemState3=true;
                        buttonOpenProblem[2].setText("close");
                        layout[2].setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.openProblem4:
                    if(openProblemState4==true)
                    {
                        layout[3].setVisibility(View.GONE);
                        buttonOpenProblem[3].setText("open");
                        openProblemState4=false;
                    }
                    else
                    {
                        openProblemState4=true;
                        buttonOpenProblem[3].setText("close");
                        layout[3].setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.openProblem5:
                    if(openProblemState5==true)
                    {
                        layout[4].setVisibility(View.GONE);
                        buttonOpenProblem[4].setText("open");
                        openProblemState5=false;
                    }
                    else
                    {
                        openProblemState5=true;
                        buttonOpenProblem[4].setText("close");
                        layout[4].setVisibility(View.VISIBLE);
                    }
                    break;

            }
    }

    public void onCheckBoxClicked(View view) {
        boolean correctAll = false;
        checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox1Problem1:
                if (checked) optionsQuestion1State[0] = true;
                else optionsQuestion1State[0] = false;
                break;
            case R.id.checkBox2Problem1:
                if (checked) optionsQuestion1State[1] = true;
                else optionsQuestion1State[1] = false;
                break;
            case R.id.checkBox3Problem1:
                if (checked) optionsQuestion1State[2] = true;
                else optionsQuestion1State[2] = false;
                break;
            case R.id.checkBox4Problem1:
                if (checked) optionsQuestion1State[3] = true;
                else optionsQuestion1State[3] = false;
                break;
        }
        if (optionsQuestion1State[0] == true && optionsQuestion1State[1] == true && optionsQuestion1State[2] == false && optionsQuestion1State[3] == true)
            correctAll = true;
        setQuestion1States(correctAll);


    }

    public void setQuestion1States(boolean correctAll) {
        if (correctAll == true) this.question1Correct = true;
        else this.question1Correct = false;

    }

    public boolean getQuestion1States() {
        return this.question1Correct;
    }

    public boolean getQuestion2State() {
        stringAnswerQuestion2 = editTextAnswerQuestion2.getText().toString();
        intAnswerQuestion2 = Integer.parseInt(stringAnswerQuestion2);
        if (intAnswerQuestion2 == 4) question2Correct = true;
        else question2Correct = false;
        return this.question2Correct;
    }

    public void onClickOptionsQuestion3(View v) {
        boolean correctAnswer = false;
        switch (v.getId()) {
            case R.id.button1Question3:
                correctAnswer = false;
                optionsEnabledQuestion3[0] = false;
                optionsEnabledQuestion3[1] = true;
                optionsEnabledQuestion3[2] = true;
                optionsEnabledQuestion3[3] = true;
                break;
            case R.id.button2Question3:
                correctAnswer = true;
                optionsEnabledQuestion3[0] = true;
                optionsEnabledQuestion3[1] = false;
                optionsEnabledQuestion3[2] = true;
                optionsEnabledQuestion3[3] = true;
                break;
            case R.id.button3Question3:
                correctAnswer = false;
                optionsEnabledQuestion3[0] = true;
                optionsEnabledQuestion3[1] = true;
                optionsEnabledQuestion3[2] = false;
                optionsEnabledQuestion3[3] = true;
                break;
            case R.id.button4Question3:
                correctAnswer = false;
                optionsEnabledQuestion3[0] = true;
                optionsEnabledQuestion3[1] = true;
                optionsEnabledQuestion3[2] = true;
                optionsEnabledQuestion3[3] = false;
                break;
        }
        for (int i = 0; i < optionsQuestion3.length; i++)
            optionsQuestion3[i].setEnabled(optionsEnabledQuestion3[i]);
        setQuestion3State(correctAnswer);
    }

    public void setQuestion3State(boolean correct) {
        if (correct == true) this.question3Correct = true;
        else this.question3Correct = false;
    }

    public boolean getQuestion3State() {
        return this.question3Correct;
    }

    public boolean getQuestion4State() {
        stringAnswerQuestion4 = editTextAnswerQuestion4.getText().toString();
        intAnswerQuestion4 = Integer.parseInt(stringAnswerQuestion4);
        if (intAnswerQuestion4 == 3) question4Correct = true;
        else question4Correct = false;
        return this.question4Correct;
    }

    public void onClickOptionsQuestion5(View v) {
        boolean correctAnswer = false;
        switch (v.getId()) {
            case R.id.option1Question5:
                optionsEnabledQuestion5[0]=false;
                optionsEnabledQuestion5[1]=true;
                correctAnswer = false;
                break;
            case R.id.option2Question5:
                optionsEnabledQuestion5[0]=true;
                optionsEnabledQuestion5[1]=false;
                correctAnswer = true;
                break;
        }
        for(int i=0;i<optionsQuestion5.length;i++)optionsQuestion5[i].setEnabled(optionsEnabledQuestion5[i]);
        setQuestion5State(correctAnswer);
    }

    public void setQuestion5State(boolean correct)
    {
        if(correct==true)this.question5Correct = true;
        else this.question5Correct = false;
    }

    public boolean getQuestion5State()
    {
        return this.question5Correct;
    }


}
