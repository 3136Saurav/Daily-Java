package mobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    String myNumber;
    ArrayList<Contacts> contacts = new ArrayList<>();

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        contacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contact){
        if(findContact(contact) >= 0){
            System.out.println("Contact is already saved!");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int position = findContact(oldContact);
        if(position < 0){
            System.out.println(oldContact.getName() + " is not found!");
            return false;
        }
        this.contacts.set(position, newContact);
        return true;
    }

    public boolean onFile(Contacts contact){
        int position = findContact(contact);
        return position >= 0;
    }

    public boolean removeContact(Contacts contact){
        int position = findContact(contact);
        if(position < 0){
            System.out.println(contact.getName() + " is not found!");
            return false;
        }
        contacts.remove(position);
        System.out.println(contact.getName() + " is removed successfully!");
        return true;
    }

    private int findContact(Contacts contact){
        return this.contacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i=0; i<this.contacts.size(); i++){
            Contacts contact = this.contacts.get(i);
            if(contact.getName().equals(contactName))
                return i;
        }
        return -1;
    }

    public String queryContact(Contacts contact){
        if(findContact(contact) >= 0)
            return contact.getName();
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >= 0)
            return this.contacts.get(position);
        return null;
    }

    public void printContacts(){
        for(int i=0; i<this.contacts.size(); i++){
            System.out.println((i+1) + ". " +
                               this.contacts.get(i).getName() + " -> " +
                               this.contacts.get(i).getMobileNumber());
        }
    }
}
