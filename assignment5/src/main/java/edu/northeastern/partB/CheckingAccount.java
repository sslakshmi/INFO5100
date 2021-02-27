package edu.northeastern.partB;

public class CheckingAccount extends Account {
    // static data members
    static private double MinBalance = 100;
    static private double Fee = 10;



    // NO instance data members

    // methods
    public CheckingAccount(String fname, String lname, double cb) {
        super(fname, lname, cb);
    }

    /**
     * This method overrides the method with the same name inherited from the super class Account.
     * -- First call the super class' method (with the given parameter). Then call ChargeFee() of this class to possibly
     * charge a fee (if the resulting balance went down below the MinBalance).
     * -- Then returns the resulting CurBalance
     *
     * @param debitAmount
     * @return
     */
    @Override
    public double DebitTransaction(double debitAmount){
        super.DebitTransaction(debitAmount);
        if(this.CurBalance < MinBalance){
            ChargeFee();
        }
        return this.CurBalance;
    }

    /**
     * -- This is a private method. It is called internally by the debit and credit transaction methods.
     * -- This method subtracts Fee from CurBalance if the current CurBalance is below (<) MinBalance.
     */
    private void ChargeFee() {
        this.CurBalance -= Fee;
    }

    /**
     * -- This method overrides the method with the same name inherited from the super class Account.
     * -- First call the super class' method (with the given parameter). Then call ChargeFee() of this class to possibly
     * charge a fee (if the resulting balance is still below the MinBalance).Adds the transaction amount to the account
     * and possibly charges a transaction fee.
     * -- Then returns the resulting CurBalance.
     *
     * @param creditAmount
     * @return
     */
    public double CreditTransaction(double creditAmount){
        super.CreditTransaction(creditAmount);
        if(this.CurBalance < MinBalance){
            ChargeFee();
        }
        return this.CurBalance;
    }


    // Simple Unit Test
    public static void main(String[] args)
    {
        CheckingAccount ch1 = new CheckingAccount("Steve", "Jobs", 50); // he was poor once before
        System.out.println(ch1);

        ch1.DebitTransaction(0.25); // he was cheap back then too
        System.out.println(ch1);    // should be $39.75 (= $49.75 - $10 fee)

        ch1.CreditTransaction(7.00); // small expense check
        System.out.println(ch1);     // should be $36.75 (= $39.75 + $7.00 - $10 fee)

        ch1.CreditTransaction(1000000); // a huge bonus!!
        System.out.println(ch1); // should be $1000036.75
    }

  /* Output of the unit test

  Account name: Steve Jobs, Account Type: CheckingAccount, Balance: $50.00
  Account name: Steve Jobs, Account Type: CheckingAccount, Balance: $39.75
  Account name: Steve Jobs, Account Type: CheckingAccount, Balance: $36.75
  Account name: Steve Jobs, Account Type: CheckingAccount, Balance: $1000036.75
  */
}
