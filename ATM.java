import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static int balance = 5000; // Initial balance
    private static int pin = 1234; // Default PIN (for demonstration purposes)
    private static ArrayList<String> transactionHistory = new ArrayList<>(); // Transaction history

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Main loop for the ATM operations
        while (true) {
            System.out.println("** Automated Teller Machine **\n ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an operation: ");

            // Get the user's choice of operation
            int choice = sc.nextInt();

            // Perform the selected operation
            switch (choice) {
                case 1:
                    withdraw(sc); // Call the withdraw method
                    break;
                case 2:
                    deposit(sc); // Call the deposit method
                    break;
                case 3:
                    checkBalance(); // Call the checkBalance method
                    break;
                case 4:
                    changePIN(sc); // Call the changePIN method
                    break;
                case 5:
                    showTransactionHistory(); // Call the showTransactionHistory method
                    break;
                case 6:
                    System.out.println("Thank you for using our ATM!"); // Exit message
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid input
            }
        }
    }

    // Method to withdraw money from the ATM
    private static void withdraw(Scanner sc) {
        System.out.print("Enter the amount to withdraw: ");
        int amount = sc.nextInt();
        if (balance >= amount) { // Check if there is enough balance
            balance -= amount;
            transactionHistory.add("Withdrawal: $" + amount); // Add transaction to history
            System.out.println("Withdrawal successful. Collect your cash.");
        } else {
            System.out.println("Insufficient balance."); // Inform user of insufficient balance
        }
    }

    // Method to deposit money into the ATM
    private static void deposit(Scanner sc) {
        System.out.print("Enter the amount to deposit: ");
        int amount = sc.nextInt();
        balance += amount; // Add amount to balance
        transactionHistory.add("Deposit: $" + amount); // Add transaction to history
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    // Method to check the current balance
    private static void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Method to change the PIN
    private static void changePIN(Scanner sc) {
        System.out.print("Enter your current PIN: ");
        int currentPIN = sc.nextInt();
        if (currentPIN == pin) { // Check if the entered PIN matches the current PIN
            System.out.print("Enter your new PIN: ");
            int newPIN = sc.nextInt();
            pin = newPIN; // Update the PIN
            transactionHistory.add("PIN changed"); // Add transaction to history
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect current PIN. PIN change failed."); // Inform user of incorrect PIN
        }
    }

    // Method to show the transaction history
    private static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) { // Check if there are no transactions
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) { // Print each transaction
                System.out.println(transaction);
            }
        }
    }
}
