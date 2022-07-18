package com.ciobanoiutheodorviorel.tema1;

public class Account {
    private int accountNo;
    private double amount;
    private String nationalId;

    public Account(){
        amount = 0;
        nationalId = "0";
    }

    public void deposit(double amount){
        this.amount += amount;
    }

    public void withdraw(double amount) throws NotEnoughMoneyException {
        if (this.amount < amount)
            throw new NotEnoughMoneyException("Not enough money in the account");

        this.amount -= amount;
    }

    public void linkToNationalId(String nationalId) throws InvalidNationalIdException {
        this.nationalId = nationalId;
        if(!checkId())
            throw new InvalidNationalIdException("National Id is invalid");

    }

    public boolean checkId(){
        //Checks the National Id using its standards
        //It only checks for Romanian CNP standards

        if(nationalId.length() != 13){
            return false;
        }
        int firstNoId = nationalId.charAt(0) - 48;
        if(firstNoId != 1 && firstNoId != 2 && firstNoId != 5 && firstNoId != 6){
            //First digit must be either 1, 2 ,5 or 6
            return false;
        }
        return true;
        //return checkControlDigit(); // Comment this line and uncomment "return true;" if you don't want to check the Control Digit
    }
    public boolean checkControlDigit(){

        //Check the valability for the control digit (last digit in NationalId)
        //This algorithm is (i hope) the official method to check the control digit

        String controlNumber = "279146358279";
        int sum = 0;
        for(int i=0; i<12 ; i++){
            int digit1 = nationalId.charAt(i) -48;
            int digit2 = controlNumber.charAt(i) - 48;
            sum += digit1*digit2;
        }
        int control = sum%11;
        if(control == 10) control = 1;
        return (control+48) == nationalId.charAt(12);
    }

    //GETTERS AND SETTERS

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

}

