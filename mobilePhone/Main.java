package mobilePhone;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0032 2342 23");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("Enter your choice(6 to list all the available actions)");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Shutting Down ....!");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;
            }
        }
    }

    public static void addContact(){
        System.out.println("Enter new name: ");
        String newName = sc.nextLine();
        System.out.println("Enter new phone number: ");
        String phoneNumber = sc.nextLine();
        Contacts contact = Contacts.createNewContact(newName, phoneNumber);
        if(mobilePhone.addNewContact(contact))
            System.out.println("New Contact added: Name: " + contact.getName() + " Phone: " + contact.getMobileNumber());
        else
            System.out.println("Cannot add, " + newName + " already saved!");
    }

    public static void updateContact(){
        System.out.println("Enter name of existing contact: ");
        String oldName = sc.nextLine();
        Contacts oldContact = mobilePhone.queryContact(oldName);
        if (oldContact == null) {
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Enter new name: ");
        String newName = sc.nextLine();
        System.out.println("Enter new number: ");
        String newNumber = sc.nextLine();
        Contacts newContact = Contacts.createNewContact(newName, newNumber);
        if(mobilePhone.updateContact(oldContact, newContact))
            System.out.println("Contact Updated Successfully!");
        else
            System.out.println("Error in updating the record!");
    }

    private static void removeContact(){
        System.out.println("Enter the contact name to be deleted: ");
        String name = sc.nextLine();
        Contacts oldContact = mobilePhone.queryContact(name);
        if(oldContact == null){
            System.out.println("Contact not found!");
            return;
        }
        if (mobilePhone.removeContact(oldContact)){
            System.out.println("Successfully deleted!");
        }
        else{
            System.out.println("Error in deleting the contact!");
        }
    }

    public static void queryContact(){
        System.out.println("Enter the contact name: ");
        String name = sc.nextLine();
        Contacts contact = mobilePhone.queryContact(name);
        if(contact == null){
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Name: " + contact.getName() + " Phone Number: " + contact.getMobileNumber());
    }

    public static  void printActions(){
        System.out.println("\nAvailable Actions\npress: ");
        System.out.println("0 - to shutdown\n" +
                           "1 - to print contacts\n" +
                           "2 - to add a new contact\n" +
                           "3 - to update an existing contact\n" +
                           "4 - to remove an existing contact\n" +
                           "5 - query if a contact exists\n" +
                           "6 - to print a list of availabe actions\n");
        System.out.println("Choose your action ");
    }

    public static void startPhone(){
        System.out.println("Starting Phone......");
    }
}
