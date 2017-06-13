package com.brian;

import java.util.ArrayList;

/**
 * Created by Brian on 6/13/2017.
 */
public class Phone {
    ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void printContacts(){
        if(contacts.size() == 0){
            System.out.println("You have no contacts :(");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println(i+" - "+contacts.get(i).getName()+ " ("+contacts.get(i).getPhoneNumber()+")");
            }
        }
    }

    public void addContact(String name, String phoneNumber){
        Contact newContact = new Contact(name, phoneNumber);
        if(checkForContact(name)){
            System.out.println("That contact already exists!");
        } else {
            contacts.add(newContact);
        }
    }

    public boolean checkForContact(String name){
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public void modifyContactAll(String name, String newName, String newNumber){
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("That contact does not exist!");
        } else {
            contacts.get(index).setName(newName);
            contacts.get(index).setPhoneNumber(newNumber);
            System.out.println("The updated contact is "+contacts.get(index).getName()
                    + " at #"+contacts.get(index).getPhoneNumber());
        }
    }

    public void modifyContactName(String name, String newName){
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("That contact does not exist!");
        } else {
            contacts.get(index).setName(newName);
            System.out.println("The updated contact is "+contacts.get(index).getName()
                    + " at #"+contacts.get(index).getPhoneNumber());
        }
    }

    public void modifyContactNumber(String name, String newNumber){
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("That contact does not exist!");
        } else {
            contacts.get(index).setPhoneNumber(newNumber);
            System.out.println("The updated contact is "+contacts.get(index).getName()
                    + " at #"+contacts.get(index).getPhoneNumber());
        }
    }

    public void removeContact(String name){
        int before = contacts.size();
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                contacts.remove(i);
                break;
            }
        }
        if(before == contacts.size()){
            System.out.println("That contact does not exist!");
        } else {
            System.out.println(name+" removed");
        }
    }
}
