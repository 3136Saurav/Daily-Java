package bankPackage;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("INB");

        bank.addBranch("Punjab");
        bank.addCustomer("Punjab", "Harris", 432.32);
        bank.addCustomer("Punjab", "Ferro", 322.32);
        bank.addCustomer("Punjab", "Nova", 5456.2);
        bank.addCustomer("Punjab", "Jennie", 423.12);

        bank.listCustomers("Punjab", true);
    }
}
