package com.ciobanoiutheodorviorel.tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidNationalIdException, IOException, NotEnoughMoneyException {
        mesajProf();
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //Used BufferedReader because Scanner didn't work with strings for some reason :/
        System.out.println("Select how many accounts you like to set: ");
        int n = in.nextInt();

        ArrayList<Account> testAccount = new ArrayList<>();

        for(int i=0 ; i<n ; i++){  //Creates N accounts
            Account newAccount = new Account();
            testAccount.add(newAccount);
            System.out.println("Please set the NationalId and ammount for account number " + (i+1) + ": ");
            System.out.print("National ID: ");
            String currentId = reader.readLine();
            testAccount.get(i).linkToNationalId(currentId);
            System.out.print("Amount: ");
            double currAmount = in.nextDouble();
            testAccount.get(i).deposit(currAmount);
            testAccount.get(i).setAccountNo(i);
        }

        message();
        int currentCase = in.nextInt();
        while(currentCase != 0){
            int currAccount;
            switch (currentCase){
                case 1:
                    //Case 1: deposit amount in a given account

                    System.out.println("What is your account number? ");
                    currAccount = in.nextInt() - 1;
                    System.out.println("How much would you like to deposit? ");
                    double currDeposit = in.nextInt();
                    testAccount.get(currAccount).deposit(currDeposit);
                    interogate(testAccount.get(currAccount));
                    break;
                case 2:
                    //Case 2: withdraw amount from a given account

                    System.out.println("What is your account number? ");
                    currAccount = in.nextInt() - 1;
                    System.out.println("How much would you like to withdraw? ");
                    double currWithdraw = in.nextInt();
                    testAccount.get(currAccount).withdraw(currWithdraw);
                    interogate(testAccount.get(currAccount));
                    break;
                case 3:
                    //Case 3: Change National Id for a given account

                    System.out.println("What is your account number? ");
                    currAccount = in.nextInt() - 1;
                    System.out.println("Please state the new National Id: ");
                    String newNationalId = reader.readLine();
                    testAccount.get(currAccount).linkToNationalId(newNationalId);
                    interogate(testAccount.get(currAccount));
                    break;
                case 4:
                    //Case 4: Interrogate account (gives National Id and the amount left in the account)
                    System.out.println("What is your account number? ");
                    currAccount = in.nextInt() - 1;
                    interogate(testAccount.get(currAccount));
                    break;
                default:
                    break;
            }


            message();
            currentCase = in.nextInt();
        }
    }

    public static void message(){
        //Message for when the program is in idle.

        System.out.println("All set good");
        System.out.println("Please select what you want to do next: ");
        System.out.println("Press 1 to deposit in an account");
        System.out.println("Press 2 to withdraw from an account");
        System.out.println("Press 3 to change the National Id for an account");
        System.out.println("Press 4 to interogate an account");
        System.out.println("Press 0 to exit");
    }
    public static void interogate(Account account){
        //Special function to print in console the account interrogation

        System.out.println("The National Id of this account: " + account.getNationalId());
        System.out.println("The amount in this account: " + account.getAmount());
    }

    public static void mesajProf(){
        System.out.println("In interiorul programului main este implementat un algoritm de testare");
        System.out.println("Programul este recursiv. Prima oara o sa intrebe numarul de conturi ce doresc a fi introduse initial\n");
        System.out.println("Atentie! CNP-ul este verificat dupa marime, daca prima cifra este corecta si DUPA CIFRA DE CONTROL, adica cam trebuie introdus un CNP valid");
        System.out.println("Daca doresti sa testezi functionalitatea codului fara verificarea acestei parti, poti sa mergi in com.ciobanoiutheodorviorel.tema1.Account.java si sa inlocuiesti");
        System.out.println("La linia 42 in loc de return checkControlDigit() doar in return true\n");
        System.out.println("Dupa introducerea celor N conturi dorite, va puteti juca cu fiecare cont in parte sa vedeti functionalitatea");
        System.out.println("Cand doriti sa terminati programul, se apasa 0\n\n");

    }
}
