
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerSecurity {
    static String validCustomerNumber = "";

    public static Customer createCustomer(String validCustomerNumber) {
        ArrayList<ArrayList<String>> customerData = CustomerDatabase.getCustomerData();
        Customer customer = null;
        for (ArrayList<String> singleCustomer : customerData) {
            if (CustomerSecurity.validCustomerNumber.equals(singleCustomer.get(1))) {
                String name = singleCustomer.get(0);
                int customerNumber = Integer.parseInt(CustomerSecurity.validCustomerNumber);
                int pin = Integer.parseInt(singleCustomer.get(2));
                double balance = Double.parseDouble(singleCustomer.get(3));
                customer = new Customer(name, customerNumber, pin, balance);
            }

        }
        return customer;
    }


   public static boolean findCustomer(String input){
       boolean foundCustomer = false;
       ArrayList<ArrayList<String>> customerData = CustomerDatabase.getCustomerData();
       for (ArrayList<String> singleCustomer : customerData) {
           if(input.equals(singleCustomer.get(1))){
              foundCustomer = true;
              validCustomerNumber = input;
              break;
           }
       }
       return foundCustomer;
   }

    public static boolean findPin(String input){
        boolean foundPin = false;
        ArrayList<ArrayList<String>> customerData = CustomerDatabase.getCustomerData();
        for (ArrayList<String> singleCustomer : customerData) {
            if(input.equals(singleCustomer.get(2))){
                foundPin = true;
                break;
            }
        }
        return foundPin;
    }

    public static void insertCustomerNumber() {
        Scanner sc = new Scanner(System.in);
        String knummer = sc.nextLine();
        boolean isCustomer = findCustomer(knummer);
        if (isCustomer) {
            System.out.println("Richtige Kundennummer! Herzlich Willkommen");
        } else {
            System.out.println("Falsche Kontonummer bitte erneut eingeben!");
            insertCustomerNumber();

        }
    }

    public static void insertPin(Customer customer) {
        boolean wrongPin = true;

        for (int pinAttempts = 0; pinAttempts < 3 && wrongPin; pinAttempts++) {
            System.out.print("Bitte Pin eigeben: ");
            Scanner input = new Scanner(System.in);
            String inputPin = input.nextLine();
            int inputPinInt = Integer.parseInt(inputPin);

            if (inputPinInt == customer.getPin()) {
                System.out.println("");
                wrongPin = false;

            } else {
                System.out.println("Bitte Pin erneut eingeben!");

            }
        }
        if (wrongPin) {
            System.out.println("Sie haben 3/3 Versuche, ihr Konto ist gesperrt bitte kontaktieren Sie einen Mitarbeiter!");
            System.exit(0);
        }
    }


}

