public class BankAccount
{ 
    private double balance; 
 
    // Constructor 
    public BankAccount(double balance)
    { 
        this.balance = balance; 
    } 
 
    // Method to deposit money into the account 
    public void deposit(double amount)
    { 
        balance += amount; 
        System.out.println("Deposit successful. New balance: " + balance); 
    } 
 
    // Method to withdraw money from the account 
    public void withdraw(double amount)
    { 
        if (balance >= amount)
        { 
            balance -= amount; 
            System.out.println("Withdrawal successful. New balance: " + balance); 
        }
        else
        { 
            System.out.println("Insufficient funds. Withdrawal failed."); 
        } 
    } 
 
    // Method to check the current balance 
    public double checkBalance()
    { 
        return balance; 
    } 
} 
