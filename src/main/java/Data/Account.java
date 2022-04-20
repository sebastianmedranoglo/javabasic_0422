package Data;

import java.time.LocalDateTime;

public class Account {
    private final int accountNumber;
    private final LocalDateTime openingDate;
    private double balance;
    private static int accountCounter=1;

    public Account(){
        this.accountNumber=accountCounter;
        this.openingDate=LocalDateTime.now();
        this.balance=0;
        accountCounter++;
    }
    public Account(double balance){
        this.accountNumber=accountCounter;
        this.openingDate=LocalDateTime.now();
        this.balance=balance;
        accountCounter++;
    }

    public LocalDateTime getOpeningDate(){
        return this.openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public boolean withdraw(double amount ){
        double totalAmount;
        if(amount>1000){
            totalAmount=200+(amount*0.15)+amount;
        }else{
            totalAmount=200+amount;
        }
        if(totalAmount>this.balance){
            return false;
        }else{
            this.balance-=totalAmount;
            return true;
        }
    }

    public void addMoney(double amount){
        this.balance+=amount;
    }
    public boolean transferWithdraw(double amount){
        if(balance<(amount+100)){
            return false;
        }else{
            balance-=(amount+100);
            return true;
        }
    }


}
