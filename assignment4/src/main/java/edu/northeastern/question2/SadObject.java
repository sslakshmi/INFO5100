package edu.northeastern.question2;

public class SadObject extends MoodyObject {
    protected String getMood() {
        return "sad";
    }

    @Override
    public void expressFeelings() {
        System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }

    @Override
    public String toString() {
        return "Subject cries a lot";
    }
}
