package edu.northeastern.question2;

public class Q2Tester {
    public static void main(String[] args) {
        PsychiatristObject psychiatristObject = new PsychiatristObject();
        MoodyObject happyObject = new HappyObject();
        MoodyObject sadObject = new SadObject();

        psychiatristObject.examine(happyObject);
        System.out.println();
        psychiatristObject.observe(happyObject);

        System.out.println();
        psychiatristObject.examine(sadObject);
        System.out.println();
        psychiatristObject.observe(sadObject);
    }
}
