package edu.northeastern.partB;

public class Account {
    // instance data members
    protected String FirstName, LastName; // two String members
    protected double CurBalance;

    // methods
    public Account(String fname, String lname, double cb) {
        FirstName = fname;
        LastName = lname;
        CurBalance = cb;
    }

    // Simple Unit Test
    public static void main(String[] args) {
        Account ac1 = new Account("John", "Smith", 100);
        System.out.println(ac1);

        ac1.DebitTransaction(30.25); // should be $69.75
        System.out.println(ac1);

        ac1.CreditTransaction(10.10);
        System.out.println(ac1); // should be $79.85
    }

    public String getAcctType() {
        return this.getClass().getName(); // returns the string of the class name
    }

    public double DebitTransaction(double debitAmount) {
        this.CurBalance -= debitAmount;
        return this.CurBalance;
    }

    public double CreditTransaction(double creditAmount) {
        this.CurBalance += creditAmount;
        return this.CurBalance;
    }

    public String toString() {
        return "Account name: " + FirstName + " " + LastName + ", Account Type: " + getAcctType() + ", Balance: " +
                String.format("$%.2f", CurBalance);
    }

  /* Output of the unit test

  Account name: John Smith, Account Type: Account, Balance: $100.00
  Account name: John Smith, Account Type: Account, Balance: $69.75
  Account name: John Smith, Account Type: Account, Balance: $79.85
  */

}
