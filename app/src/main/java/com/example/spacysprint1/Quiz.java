package com.example.spacysprint1;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spacysprint1.R;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Quiz extends AppCompatActivity {

    private ImageView Questionimagee ;
    private TextView optionA, optionB, optionC, optionD;
    private TextView questionNumber, question, score;
    private TextView checkout1, checkout2;
    int currentIndex;
    int userscore = 0;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    int qn = 1;
    ProgressBar progressBar;

    int currentQuestion, currentOptionA, currentOptionB, currentOptionC, currentOptionD, currentAnswer;


    private answerClass[] questionBank = new answerClass[]{

            new answerClass(1, R.string.question1, R.string.question1_A, R.string.question1_B
                    , R.string.question1_C, R.string.question1_D, R.string.answer1),
            new answerClass(3,R.raw.b, R.string.question9_A, R.string.question9_B
                    , R.string.question9_C, R.string.question9_D, R.string.answer9),
            new answerClass(1,R.string.question2, R.string.question2_A, R.string.question2_B
                    , R.string.question2_C, R.string.question2_D, R.string.answer2),
            new answerClass(2,R.drawable.twooo,R.string.question6_A, R.string.question6_B
                    , R.string.question6_C, R.string.question6_D, R.string.answer6),
            new answerClass(1,R.string.question3, R.string.question3_A, R.string.question3_B
                    , R.string.question3_C, R.string.question3_D, R.string.answer3),
            new answerClass(1,R.string.question4, R.string.question4_A, R.string.question4_B
                    , R.string.question4_C, R.string.question4_D, R.string.answer4),
            new answerClass(2,R.drawable.threee,R.string.question7_A, R.string.question7_B
                    , R.string.question7_C, R.string.question7_D, R.string.answer7),
            new answerClass(1,R.string.question5, R.string.question5_A, R.string.question5_B
                    , R.string.question5_C, R.string.question5_D, R.string.answer5),
            new answerClass(2,R.drawable.lettera, R.string.question8_A, R.string.question8_B
                    , R.string.question8_C, R.string.question8_D, R.string.answer8),
            new answerClass(3,R.raw.nine, R.string.question10_A, R.string.question10_B
                    , R.string.question10_C, R.string.question10_D, R.string.answer10),



    };

    final int PROGRESS_BAR = (int) Math.ceil(100 / questionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


//        questionNumber.setText(qn+"/"+questionBank.length+"Question");
//        score.setText("Score :"+userscore+"/"+questionBank.length);


        optionA = findViewById(R.id.Option1);
        optionB = findViewById(R.id.Option2);
        optionC = findViewById(R.id.Option3);
        optionD = findViewById(R.id.Option4);

        question = findViewById(R.id.Question);
        Questionimagee=findViewById(R.id.imagee) ;
        questionNumber = findViewById(R.id.QuestionNumber);
        score = findViewById(R.id.score);
        progressBar = findViewById(R.id.progress_bar);
        checkout1 = findViewById(R.id.select_option);
        checkout2 = findViewById(R.id.CorrectAnswer);

        if (questionBank[currentIndex].getQc()==1)
        {
            if (Questionimagee.getVisibility()!=View.GONE) {Questionimagee.setVisibility(View.GONE);}
            if  (question.getVisibility()==View.GONE) {question.setVisibility(View.VISIBLE);}

            currentQuestion = questionBank[currentIndex].getQuestionid();
            question.setText(currentQuestion); }
        else if (questionBank[currentIndex].getQc()==2)  {
            if (Questionimagee.getVisibility()==View.GONE) {Questionimagee.setVisibility(View.VISIBLE);}
            if  (question.getVisibility()!=View.GONE) {question.setVisibility(View.GONE);}
            currentQuestion = questionBank[currentIndex].getQuestionid();

            Questionimagee.setImageResource(currentQuestion);

        }

        else {
            Questionimagee.setImageResource(R.drawable.play);
            if (Questionimagee.getVisibility()==View.GONE) {Questionimagee.setVisibility(View.VISIBLE);}
            if  (question.getVisibility()!=View.GONE) {question.setVisibility(View.GONE);}
            Questionimagee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Questionimagee.animate().rotationBy(360).setDuration(1000) ;
                    releaseMediaPlayer();
                    mMediaPlayer = MediaPlayer.create(Quiz.this, questionBank[currentIndex].getQuestionid());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            });


        }

        currentOptionA = questionBank[currentIndex].getOptionA();
        currentOptionB = questionBank[currentIndex].getOptionB();
        currentOptionC = questionBank[currentIndex].getOptionC();
        currentOptionD = questionBank[currentIndex].getOptionD();

        optionA.setText(currentOptionA);
        optionB.setText(currentOptionB);
        optionC.setText(currentOptionC);
        optionD.setText(currentOptionD);

        score.setText("Score :" + userscore + "/" + questionBank.length);
        questionNumber.setText(qn + "/" + questionBank.length + " Question");




        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(currentOptionA);
                updateQuestion();

            }
        });


        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(currentOptionB);
                updateQuestion();
            }
        });


        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(currentOptionC);
                updateQuestion();
            }
        });


        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(currentOptionD);
                updateQuestion();
            }
        });


    }

    private void updateQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.length;
        if (currentIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your score: " + userscore +"/"+questionBank.length);
            alert.setPositiveButton("Back to app ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            alert.setNegativeButton("Repeat Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    userscore = 0;
                    qn = 1;
                    progressBar.setProgress(0);
                    score.setText("Score :" + userscore + "/" + questionBank.length);
                    questionNumber.setText(qn + "/" + questionBank.length + " Question");


                }
            });
            alert.show() ;
        }
        currentOptionA = questionBank[currentIndex].getOptionA();
        currentOptionB = questionBank[currentIndex].getOptionB();
        currentOptionC = questionBank[currentIndex].getOptionC();
        currentOptionD = questionBank[currentIndex].getOptionD();

        if (questionBank[currentIndex].getQc()==1)
        {
            if (Questionimagee.getVisibility()!=View.GONE) {Questionimagee.setVisibility(View.GONE);}
            if  (question.getVisibility()==View.GONE) {question.setVisibility(View.VISIBLE);}

            currentQuestion = questionBank[currentIndex].getQuestionid();
            question.setText(currentQuestion); }
        else if (questionBank[currentIndex].getQc()==2) {
            if (Questionimagee.getVisibility()==View.GONE) {Questionimagee.setVisibility(View.VISIBLE);}
            if  (question.getVisibility()!=View.GONE) {question.setVisibility(View.GONE);}
            currentQuestion = questionBank[currentIndex].getQuestionid();

            Questionimagee.setImageResource(currentQuestion);

        }
        else {
            Questionimagee.setImageResource(R.drawable.play);
            if (Questionimagee.getVisibility()==View.GONE) {Questionimagee.setVisibility(View.VISIBLE);}
            if  (question.getVisibility()!=View.GONE) {question.setVisibility(View.GONE);}
            Questionimagee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Questionimagee.animate().rotationBy(360).setDuration(1000) ;
                    releaseMediaPlayer();
                    mMediaPlayer = MediaPlayer.create(Quiz.this, questionBank[currentIndex].getQuestionid());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            });


        }
        optionA.setText(currentOptionA);
        optionB.setText(currentOptionB);
        optionC.setText(currentOptionC);
        optionD.setText(currentOptionD);


        if (qn < questionBank.length) {
            qn = qn + 1;
            questionNumber.setText(qn + "/" + questionBank.length + "Question");
        }

        score.setText("Score :" + userscore + "/" + questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);

    }





    private void checkAnswer(int currentSelection) {

        int currentAnswer = questionBank[currentIndex].getAnswerid();
        checkout1.setText(currentSelection);
        checkout2.setText(currentAnswer);

        if (checkout1.getText().toString().trim().equals(checkout2.getText().toString().trim())) {
//            Toast toast = Toast.makeText(this, "Right ✅!", FancyToast.LENGTH_LONG);
//            toast.show();
            FancyToast.makeText(this, "Right ✅!", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
            userscore = userscore + 1;
        } else
//        {                 Toast toast = Toast.makeText(this, "Wrong ❌!", FancyToast.LENGTH_LONG);
//            toast.show();

            FancyToast.makeText(this, "Wrong ❌!", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }


}
