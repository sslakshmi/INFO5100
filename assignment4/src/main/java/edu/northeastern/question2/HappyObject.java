package edu.northeastern.question2;

public class HappyObject extends MoodyObject {
    protected String getMood() {
        return "happy";
    }

    @Override
    protected void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    @Override
    public String toString() {
        return "Subject laughs a lot";
    }
}
