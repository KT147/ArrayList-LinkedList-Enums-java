package dev.lpa;

import java.util.ArrayList;

public class BankChallenge {

    public static void main(String[] args) {

        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
    }
}

class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
    }

    public boolean addBranch(String branchName) {
        branches.add(branchName);
    }

    public boolean addCustomer(String branchName, String customer, double initialTransaction) {

    }

    public boolean addCustomerTransaction(String branchName, String customer, double initialTransaction) {

    }

    public void findBranch(String branchName) {

    }

    public boolean listCustomers(String branchName, boolean printTransactions) {

    }
}

class Branch{
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name, ArrayList<Customer> customers) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

//    public boolean newCustomer(String customerName, double initialTransaction) {
//
//    }
//
//    public boolean addCustomerTransaction(String customerName, double transaction) {
//
//    }
//
//    public
}

class Customer {

}