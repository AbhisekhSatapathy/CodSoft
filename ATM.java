import java.util.Scanner; 
 
public class ATM
{ 
    private BankAccount account; 
    private Scanner scanner; 
 
    // Constructor 
    public ATM(BankAccount account)
    { 
        this.account = account; 
        this.scanner = new Scanner(System.in); 
    } 
 
    // Method to start the ATM 
    public void start()
    { 
        System.out.println("Welcome to the ATM."); 
        while (true)
        { 
            displayMenu(); 
            int choice = scanner.nextInt(); 
            scanner.nextLine(); // Consume newline 
 
            switch (choice)
            { 
                case 1: 
                    deposit(); 
                    break; 
                case 2: 
                    withdraw(); 
                    break; 
                case 3: 
                    checkBalance(); 
                    break; 
                case 4: 
                    System.out.println("Thank you for using this ATM"); 
                    return; 
                default: 
                    System.out.println("Invalid choice. Please enter a number from 1 to 4."); 
                    break; 
            } 
        } 
    } 
 
    // Method to display the ATM menu 
    private void displayMenu()
    { 
        System.out.println("\nATM Menu:"); 
        System.out.println("1. Deposit"); 
        System.out.println("2. Withdraw"); 
        System.out.println("3. Check Balance"); 
        System.out.println("4. Exit"); 
        System.out.print("Enter your choice: "); 
    } 
 
    // Method to deposit money into the account 
    private void deposit()
    { 
        System.out.print("Enter amount to deposit: "); 
        double amount = scanner.nextDouble(); 
        account.deposit(amount); 
    } 
 
    // Method to withdraw money from the account 
    private void withdraw()
    { 
        System.out.print("Enter amount to withdraw: "); 
        double amount = scanner.nextDouble(); 
        account.withdraw(amount); 
    } 
 
    // Method to check the balance of the account 
    private void checkBalance()
    { 
        double balance = account.checkBalance(); 
        System.out.println("Current balance: " + balance); 
    } 
 
    // Close the scanner when done 
    public void closeScanner()
    { 
        scanner.close(); 
    } 
 
    public static void main(String[] args)
    { 
        // Example usage 
        BankAccount userAccount = new BankAccount(1000); // Starting balance of 1000 
        ATM atm = new ATM(userAccount); 
        atm.start(); 
        atm.closeScanner(); 
    } 
}
