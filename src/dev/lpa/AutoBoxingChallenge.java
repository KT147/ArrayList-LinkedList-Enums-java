package dev.lpa;

import java.util.ArrayList;

public class AutoBoxingChallenge {

    public static void main(String[] args) {
        Customer2 customer = new Customer2("Sass", 100);

        Bank2 bank = new Bank2("Chase");
        bank.addCustomer("Jane A", 500.00);
        System.out.println(bank);

        bank.addTransaction("Jane a", -20.25);

        bank.printStatement("Jane A");

    }


}

class Customer2 {
    private String name;
    private ArrayList<Double> transactions;

    public Customer2(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        credit(initialAmount);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }

    public void credit(double amount) {
        transactions.add(+amount);
    }

    public void debit(double amount) {
        transactions.add(-amount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}

class Bank2 {
    private String name;
    private ArrayList<Customer2> customers = new ArrayList<>(5000);

    public Bank2(String name) {
        this.name = name;
    }

    public void addCustomer(String customerName, double initialDeposit) {
        if (getCustomers(customerName) == null) {
            Customer2 customer = new Customer2(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("Customer added: " + customer);
        } else {
            System.out.println(customerName + " is already a customer");
        }
    }

    private Customer2 getCustomers(String customerName) {
        for (var customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        System.out.println("Customer was not found");
        return null;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    public void addTransaction(String name, double transactionAmount) {
        Customer2 customer = getCustomers(name);

        if (customer != null) {
            customer.getTransactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName) {

        Customer2 customer = getCustomers(customerName);
        if (customer == null) {
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Transactions: ");
        for (double d : customer.getTransactions()) {
            System.out.printf("€%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }

    }
}
