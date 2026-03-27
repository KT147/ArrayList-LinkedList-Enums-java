package dev.lpa;

import java.util.ArrayList;

public class Challenge1 {
    public static void main(String[] args) {

    }
}

class MobilePhone{
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        for (Contact existing : myContacts) {
            if (existing.getName().equalsIgnoreCase(contact.getName())) {
                return false;
            }
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact existing = myContacts.get(i);

            if (existing.getName().equalsIgnoreCase(oldContact.getName())) {
                myContacts.set(i, newContact);
                return true;
            }
        }

        return false;
    }

    public boolean removeContact(Contact contact) {
        for (Contact existing : myContacts) {
            if (existing.getName().equalsIgnoreCase(contact.getName())) {
                myContacts.remove(existing);
                return true;
            }
        } return false;
    }

    private int findContact(Contact contact) {
        for (Contact existing : myContacts) {
            if (existing.getName().equalsIgnoreCase(contact.getName())) {
                return myContacts.indexOf(existing);
            }
        } return -1;
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index >= 0) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");

        myContacts.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        for (int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " -> " + c.getPhoneNumber());
        }
    }
}

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}
