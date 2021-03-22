package edu.northeastern;

import java.util.Scanner;

public class Question1_App {

    public static void main(String[] args) {
        //TODO- Ask new user/ current user - Is this shown again after selecting EXIT from menu. If so, what should be
        //the mechanism to exit from the app completely?
        //TODO - What is current user?


        //=======================================================================================
        Scanner scanner = new Scanner(System.in);
        int userType = 0, currentUserOperation;
        int userSelection;
        boolean quit = false;
        User user;
        UserData userData = null;
        String name, address, phoneNumber, password;
        int age, bankAccountNumber;
        int userChoice = 0;
        double currentBalance;

        //=======================================================================================

        //Initialise ATM
        Atm atm = new Atm(100000);

        //CLI
        System.out.println();
        int width = 36;
        int textPadding = 13;
        int inputPadding = 2;
        String welcome = "WELCOME";
        int leftPadding = (width - welcome.length()) / 2;
        System.out.println(String.format("%-" + leftPadding + "s%s", "", welcome));

        login:
        do {
            System.out.println("=".repeat(width));
            System.out.println("Please select any option from below:");
            System.out.println("1. New User");
            System.out.println("2. Current User");
            System.out.println("3. Exit");
            System.out.println("=".repeat(width));
            //TODO - Add exception handling
            try {
                userType = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again!");
                continue login;
            }
            scanner.nextLine();

            switch (userType) {

                case 1:
                    //NEW USER
                    try {
                        String textFormat = "%-" + textPadding + "s%-" + inputPadding + "s";
                        System.out.print(String.format(textFormat, "Name", ":"));
                        name = scanner.nextLine();
                        System.out.print(String.format(textFormat, "Age", ":"));
                        age = Integer.parseInt(scanner.nextLine());
                        System.out.print(String.format(textFormat, "Address", ":"));
                        address = scanner.nextLine();
                        System.out.print(String.format(textFormat, "Phone Number", ":"));
                        phoneNumber = scanner.nextLine();
                        System.out.print(String.format(textFormat, "Password", ":"));
                        password = scanner.nextLine();

                        user = new User(name, age, address, phoneNumber);
                        //generate bank account number
                        bankAccountNumber = user.generateAccountNumber();
                        userData = new UserData(user, password, 0.0);
                        atm.addUser(userData);

                        System.out.println("\nPlease use Bank Account Number and Password to sign-in later.");
                        System.out.println("Please make a note of your Account Number.\nBank Account Number : " + bankAccountNumber);
                        System.out.println("\n\t  Account Details\t");
                        System.out.println("-".repeat(28));
                        System.out.println(user.displayUserDetails());
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("Invalid input. Please try again!\n\n");
                        continue login;
                    }
                    break;

                case 2:
                    //CURRENT USER
                    currentUser:
                    while (true) {
                        System.out.println("=".repeat(width));
                        System.out.println("1. Enter bank account number and password");
                        System.out.println("2. Forgot password");
                        System.out.println("3. Previous menu");
                        System.out.println("=".repeat(width));
                        try {
                            currentUserOperation = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Invalid selection. Please try again!");
                            continue currentUser;
                        }

                        switch (currentUserOperation) {
                            case 1:
                                //Enter bank account number and password
                                try {
                                    System.out.println("Enter bank account number");
                                    int accNumber = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Enter password");
                                    password = scanner.nextLine();
                                    userData = atm.checkCurrentUser(accNumber, password);
                                    if (userData == null) {
                                        System.out.println("Invalid account number or password. Please try again.");
                                        continue currentUser;
                                    }
                                } catch (NumberFormatException numberFormatException) {
                                    System.out.println("Invalid input. Please try again!");
                                    continue currentUser;
                                }
                                break;

                            case 2:
                                //Forgot password
                                try {
                                    System.out.println("Enter name");
                                    name = scanner.nextLine();
                                    System.out.println("Enter age");
                                    age = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Enter phone number");
                                    phoneNumber = scanner.nextLine();
                                    userData = atm.getUserData(name, age, phoneNumber);
                                    if (userData == null) {
                                        System.out.println("Invalid user details. Please try again");
                                        continue currentUser;
                                    } else {
                                        System.out.print("NEW PASSWORD : ");
                                        password = scanner.nextLine();
                                        userData.setPassword(password);
                                        System.out.println("PASSWORD UPDATED!");
                                    }
                                } catch (NumberFormatException numberFormatException) {
                                    System.out.println("Invalid input. Please try again!");
                                    continue currentUser;
                                }
                                break;

                            case 3:
                                continue login;
                        }
                        break;
                    }
                    break;
                case 3:
                    //SIGN OUT
                    return;

                default:
                    System.out.println("Invalid entry. Please try again.");
                    continue login;
            }

            operations:
            while (true) {
                //Banking Options
                System.out.println("=".repeat(width));
                System.out.println("1. Check Current Balance");
                System.out.println("2. Deposit money");
                System.out.println("3. Withdraw money");
                System.out.println("4. View Recent Transactions");
                System.out.println("5. Change Password");
                System.out.println("6. Sign Out");
                System.out.println("=".repeat(width));
                System.out.println();
                System.out.print("Enter Your Choice : ");
                try {
                    userChoice = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again!");
                    continue operations;
                }
                scanner.nextLine();

                switch (userChoice) {

                    case 1:
                        System.out.println("Current Balance : $" + userData.getAccountBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit : ");
                        double depositAmount = 0;
                        try {
                            depositAmount = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Invalid amount. Please try again");
                            continue operations;
                        }
                        currentBalance = userData.deposit(depositAmount);
                        if (currentBalance > 0) {
                            atm.addToAvailableAmountInMachine(depositAmount);
                            System.out.println("Successfully Deposited. \nCurrent Balance : $" + currentBalance);
                        } else {
                            System.out.println("Not enough balance to deduct transaction fee.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw : ");
                        double withdrawalAmount = 0;
                        try {
                            withdrawalAmount = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Invalid amount. Please try again");
                            continue operations;
                        }
                        if (withdrawalAmount > atm.getAvailableAmountInMachine()) {
                            System.out.println("ATM balance is low!");
                            break;
                        }

                        currentBalance = userData.withdraw(withdrawalAmount);
                        if (currentBalance > 0) {
                            atm.subtractFromAvailableAmountInMachine(withdrawalAmount);
                            System.out.println("Withdrawal completed successfully. \nCurrent Balance : $" + currentBalance);
                        } else {
                            System.out.println("Not enough balance to perform cash withdrawal.");
                        }
                        break;

                    case 4:
                        String transactions = "Last 10 transactions";
                        leftPadding = (width - transactions.length()) / 2;
                        System.out.println(String.format("%-" + leftPadding + "s", transactions));
                        System.out.println("-".repeat(width));
                        System.out.println(userData.getLastTenTransactions());
                        System.out.println("-".repeat(width));
                        break;

                    case 5:
                        System.out.print("NEW PASSWORD : ");
                        password = scanner.nextLine();
                        userData.setPassword(password);
                        System.out.println("PASSWORD UPDATED!");
                        break;

                    case 6:
                        System.out.println("Signed Out!");
                        continue login;
                }
            }
        } while (userType != 0);
    }
}
