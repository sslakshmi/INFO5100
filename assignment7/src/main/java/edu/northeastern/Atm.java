package edu.northeastern;

import java.util.HashMap;
import java.util.Map;

public class Atm {
    private double availableAmountInMachine;
    public static final double TRANSACTION_FEE = 2;
    private Map<Integer, UserData> userData;

    public Atm(double availableAmountInMachine) {
        this.availableAmountInMachine = availableAmountInMachine;
        this.userData = new HashMap<>();
    }

    public void addToAvailableAmountInMachine(double amount ){
        this.availableAmountInMachine += amount;
    }

    public void subtractFromAvailableAmountInMachine(double amount ){
        this.availableAmountInMachine -= amount;
    }

    public double getAvailableAmountInMachine() {
        return availableAmountInMachine;
    }

    public void addUser(UserData userDetails){
        int accountNumber = userDetails.getUser().generateAccountNumber();
        userData.put(accountNumber,userDetails);
    }

    public UserData checkCurrentUser(int accNumber, String password){
        UserData userData = this.userData.getOrDefault(accNumber, null);
        if(userData != null && userData.getPassword().equals(password)){
            return userData;
        }
        return null;
    }

    public UserData getUserData(String name, int age, String phoneNumber) {
        UserData userData = null;
        for (Map.Entry<Integer, UserData> entry : this.userData.entrySet()) {
            UserData value = entry.getValue();
            User user = value.getUser();
            if (user != null && name.equals(user.getName()) && age == user.getAge() && phoneNumber.equals(user.getPhoneNumber())) {
                userData = value;
            }
        }
        return userData;
    }
}
