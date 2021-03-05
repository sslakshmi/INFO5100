package edu.northeastern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Number number = new Number();
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        do {
            try{
                System.out.println("Enter numerator:");
                int numerator = scanner.nextInt();
                System.out.println("Please enter denominator: ");
                int denominator = scanner.nextInt();
                int quotient = number.count(numerator,denominator);
                System.out.println("Result: "+ numerator + "/" + denominator+ " = "+quotient);
                continueLoop = false;
            }
            catch (InputMismatchException inputMismatchException){
                System.out.println("Exception: "+ inputMismatchException);
                scanner.nextLine();
                System.out.println("You must enter integers. Please try again!\n\n");
            }
            catch (ArithmeticException ae){
                System.out.println("Caught arithmetic exception: " + ae);
                System.out.println("Zero is an invalid denominator. Please try again!\n\n");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        } while (continueLoop);
    }
}
