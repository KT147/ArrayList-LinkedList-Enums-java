package dev.lpa;

import java.lang.reflect.Array;
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
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null) {
            return false;
        }
        Branch branch = new Branch(branchName);
        branches.add(branch);
        return true;

    }

    public boolean addCustomer(String branchName, String customer, double initialTransaction) {
        Branch branch = findBranch(branchName);

        if (branch == null) {
            return false;
        }

        branch.newCustomer(customer, initialTransaction);
        return true;
    }

    public boolean addCustomerTransaction(String branchName, String customer, double initialTransaction) {
        Branch branch = findBranch(branchName);

        if (branch == null) {
            return false;
        }

        branch.addCustomerTransaction(customer, initialTransaction);
        return true;
    }

    private Branch findBranch(String branchName) {
        for (var branch : branches) {
            if (branch.getName().equalsIgnoreCase(branchName))
                return branch;
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);

        if (branch == null) {
            return false;
        }
        System.out.println("Customer details for branch " + branch.getName());

        int customerIndex = 1;
        for (Customer customer : branch.getCustomers()) {
            System.out.println("Customer: " + customer.getName() + "[" + customerIndex + "]");
            if (printTransactions) {
                System.out.println("Transactions");
                int transactionIndex = 1;
                for (Double amount : customer.getTransactions()) {
                    System.out.println("[" + transactionIndex + "] Amount " + amount);
                    transactionIndex++;
                }
            }
            customerIndex++;
        }
        return true;
    }
}

class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) != null) {
            return false;
        }

        Customer customer = new Customer(customerName, initialTransaction);
        customers.add(customer);
        return true;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {

        Customer customer = findCustomer(customerName);

        if (customer == null) {
            return false;
        }

        customer.addTransactions(transaction);

        return true;
    }

    private Customer findCustomer(String customerName) {
        for (var customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName))
                return customer;
        }
        return null;
    }
}

class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(transaction);

    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransactions(double transaction) {
        this.transactions.add(transaction);
    }
}