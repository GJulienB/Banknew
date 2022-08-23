
public class ATMOutput {

    public static void main(String[] args) {
        startText();
        CustomerSecurity.insertCustomerNumber();
        Customer customer = CustomerSecurity.createCustomer(CustomerSecurity.validCustomerNumber);
        CustomerSecurity.insertPin(customer);
        Account account = new Account(customer.getBalance());
        account.showMenu();


    }

    public static void startText() {
        System.out.println("B A N K O M A T EOS-Bank Standort: Hamburg");
        System.out.print("Hallo, herzlich willkommen" + "! Bitte geben Sie Ihre Kundennummer an: ");
    }

}










