package entities;

import java.time.LocalDate;

public class Payment {

    private int paymentID;
    private int contractID;
    private LocalDate date;
    private double amount;
    private String method;
    private int paymentYear;
    private double total;
    private int count;

    public Payment(int paymentID, int contractID, LocalDate date, double amount, String method) {
        this.paymentID = paymentID;
        this.contractID = contractID;
        this.date = date;
        this.amount = amount;
        this.method = method;
    }
    public Payment(int contractID, LocalDate date, double amount, String method) {
        this.contractID = contractID;
        this.date = date;
        this.amount = amount;
        this.method = method;
    }

    public Payment(int paymentYear, double total) {
        this.paymentYear = paymentYear;
        this.total = total;
    }

    public Payment( double amount,int paymentID) {
       this.paymentID = paymentID;
       this.amount = amount;
    }

    public Payment(int count, String method) {
        this.method = method;
        this.count = count;
    }


    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String printSum() {
        return "Year = " + paymentYear + "      Total = " + total;
    }

    public String printAVG() {
        return "Year = " + paymentYear + "      Average = " + total;
    }

    public String printMin(){
        return "Payment ID = " + paymentID + "          Amount  = " + amount ;
    }

    public String printMax(){
        return "Payment ID = " + paymentID + "          Amount = " + amount ;
    }

    public String printmethodFreq(){
        return "method = " + method + "         number of times used = " + count ;
    }
}
