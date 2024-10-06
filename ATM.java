import java.util.Scanner;
import java.util.InputMismatchException;

public class ATM {
    private String accountNumber;
    private double balance;
    private Scanner scanner;

    public ATM(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = getValidAmount();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful. New balance: %.2f%n", balance);
        }
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = getValidAmount();
        balance += amount;
        System.out.printf("Deposit successful. New balance: %.2f%n", balance);
    }

    public void checkBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = getValidChoice();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private double getValidAmount() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid amount: ");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private int getValidChoice() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid choice: ");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static void main(String[] args) {
        // Create a bank account
        ATM atm = new ATM("1234567890", 1000);

        // Run the ATM machine
        atm.run();
    }
}
