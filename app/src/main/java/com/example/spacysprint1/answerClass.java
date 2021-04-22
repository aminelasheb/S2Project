package com.example.spacysprint1;


public class answerClass {
    private int qc ,optionA, optionB, optionC, optionD, questionid, answerid;

    public answerClass(int qC ,int questionide, int optiona, int optionb, int optionc, int optiond, int answeride) {
        questionid = questionide;
        optionA = optiona;
        optionB = optionb;
        optionC = optionc;
        optionD = optiond;
        answerid = answeride;
        qc=qC ;

    }

    public int getQc() {
        return qc;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionid() {
        return questionid;
    }

    public int getAnswerid() {
        return answerid;
    }


}

