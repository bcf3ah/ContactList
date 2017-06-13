package com.brian;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Phone phone = new Phone();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions(){
        System.out.println("0 - print instructions");
        System.out.println("1 - print contacts");
        System.out.println("2 - add contact");
        System.out.println("3 - modify contact");
        System.out.println("4 - remove contact");
        System.out.println("5 - search for a contact");
        System.out.println("6 - quit");
    }

    public static void printContacts(){
        phone.printContacts();
    }

    public static void addContact(){
        System.out.println("Please enter a new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the new contact's phone number: ");
        String phoneNumber = scanner.nextLine();
        phone.addContact(name, phoneNumber);
    }

    public static void modifyContact(){
        System.out.println("Enter the name of the contact you want to modify: ");
        String name = scanner.nextLine();
        if(phone.checkForContact(name)){
            System.out.println("Enter 1 to modify name. Enter 2 to modify number. Enter 3 to modify both.");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Please enter the new name: ");
                    String nextName = scanner.nextLine();
                    phone.modifyContactName(name, nextName);
                    break;
                case 2:
                    System.out.println("Please enter the new phone number: ");
                    String nextNumber = scanner.nextLine();
                    phone.modifyContactNumber(name, nextNumber);
                    break;
                case 3:
                    System.out.println("Please enter the new name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Please enter the new phone number: ");
                    String newNumber = scanner.nextLine();
                    phone.modifyContactAll(name, newName, newNumber);
                    break;
                default:
                    System.out.println("That wasn't an option. Logging you out.");
            }
        }
    }

    public static void removeContact(){
        System.out.println("Please enter the name of the contact you want to remove: ");
        phone.removeContact(scanner.nextLine());
    }

    public static void queryContact(){
        System.out.println("Enter the name of the contact you want to check: ");
        if(phone.checkForContact(scanner.nextLine())){
            System.out.println("Yes, that contact exists");
        } else {
            System.out.println("No, that contact does not exist");
        }
    }

}
