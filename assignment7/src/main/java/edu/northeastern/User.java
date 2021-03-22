package edu.northeastern;

public class User {
    private final String name;
    private final int age;
    private final String address;
    private final String phoneNumber;
    //TODO - what is the type for bankAccountNumber?
    private int bankAccountNumber;

    public User(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bankAccountNumber = 0;
    }

    /**
     * @return
     */
    public int generateAccountNumber() {
        //TODO - Don't overwrite existing acc no. - (Done)
        if (this.bankAccountNumber == 0) {
            bankAccountNumber = (int) ((Math.random() * 9000) + 1000);
        }
        return bankAccountNumber;
    }

    public String displayUserDetails() {
        int textPadding = 15;
        int inputPadding = 2;
        String textFormat = "%-" + textPadding + "s%-" + inputPadding + "s%s";
        StringBuilder userDetails = new StringBuilder();
        userDetails.append(String.format(textFormat, "Name", ":", name));
        userDetails.append("\n");
        userDetails.append(String.format(textFormat, "Age", ":", age));
        userDetails.append("\n");
        userDetails.append(String.format(textFormat, "Address", ":", address));
        userDetails.append("\n");
        userDetails.append(String.format(textFormat, "Phone Number", ":", phoneNumber));
        userDetails.append("\n");
        userDetails.append(String.format(textFormat, "Account Number", ":", bankAccountNumber));
        userDetails.append("\n");
        return userDetails.toString();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
