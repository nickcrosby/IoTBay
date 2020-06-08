/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;


public class Payment {

        //Payment data fields
        private int paymentID;
        private String account_Name;
        private int account_Number;
        private String payment_Method;
        private String date;
        private int total_amount;
        private String expDate;

        //Initialise constructor with Payment fields
    public Payment(int paymentID, String account_Name, int account_Number, String payment_Method, String date, int total_amount, String expDate) {
        this.paymentID = paymentID;
        this.account_Name = account_Name;
        this.account_Number = account_Number;
        this.payment_Method = payment_Method;
        this.date = date;
        this.total_amount = total_amount;
        this.expDate = expDate;
    }

    //Create Getters and Setters for Payment
    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getAccount_Name() {
        return account_Name;
    }

    public void setAccount_Name(String account_Name) {
        this.account_Name = account_Name;
    }

    public int getAccount_Number() {
        return account_Number;
    }

    public void setAccount_Number(int account_Number) {
        this.account_Number = account_Number;
    }

    public String getPayment_Method() {
        return payment_Method;
    }

    public void setPayment_Method(String payment_Method) {
        this.payment_Method = payment_Method;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

}

