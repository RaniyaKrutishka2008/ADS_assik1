package Assik2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BankAccount {
    int accountNumber;
    String username;
    int balance;
    BankAccount next;

    public BankAccount(int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
        this.next = null;
    }
}

class BankingSystem {
    BankAccount head;
    Stack<String> history = new Stack<>();
    Queue<String> billQueue = new LinkedList<>();
    Queue<BankAccount> accountRequests = new LinkedList<>();

    // Task 1
    void addAccount(BankAccount account) {
        BankAccount newAccount = new BankAccount(account.accountNumber, account.username, account.balance);
        newAccount.next = head;
        head = newAccount;
        System.out.println("Account added successfully");
    }

    void displayAllAccounts() {
        BankAccount current = head;
        int i = 1;
        System.out.println("Accounts List:");
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }
        while (current != null) {
            System.out.println(i + ". " + current.username + " – Balance: " + current.balance);
            current = current.next;
            i++;
        }
    }

    void searchAccount(String username) {
        BankAccount current = head;
        while (current != null) {
            if (current.username.equalsIgnoreCase(username)) {
                System.out.println("Account found: " + current.username + ", Balance: " + current.balance);
                return;
            }
            current = current.next;
        }
        System.out.println("Account not found");
    }

    // Task 2
    void depositMoney(String username, int amount) {
        BankAccount current = head;
        while (current != null) {
            if (current.username.equalsIgnoreCase(username)) {
                current.balance += amount;
                System.out.println("Deposit: " + amount);
                System.out.println("New balance: " + current.balance);
                history.push("Deposit " + amount + " to " + username);
                return;
            }
            current = current.next;
        }
        System.out.println("Account not found");
    }

    void withdrawMoney(String username, int amount) {
        BankAccount current = head;
        while (current != null) {
            if (current.username.equalsIgnoreCase(username)) {
                if (current.balance >= amount) {
                    current.balance -= amount;
                    System.out.println("Withdraw: " + amount);
                    System.out.println("New balance: " + current.balance);
                    history.push("Withdraw " + amount + " from " + username);
                } else {
                    System.out.println("Insufficient funds");
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Account not found");
    }

    // Task 3
    void undoLastTransaction() {
        if (!history.isEmpty()) {
            String removed = history.pop();
            System.out.println("Undo → " + removed + " removed");
        } else {
            System.out.println("No history to undo");
        }
    }

    void showLastTransaction() {
        if (!history.isEmpty()) {
            System.out.println("Last transaction: " + history.peek());
        } else {
            System.out.println("No recent transactions");
        }
    }

    // Task 4
    void addBill(String bill) {
        billQueue.add(bill);
        history.push("Bill payment request: " + bill); // Added to history
        System.out.println("Added: " + bill);
    }

    void processNextBill() {
        if (!billQueue.isEmpty()) {
            String bill = billQueue.poll();
            System.out.println("Processing: " + bill);
        } else {
            System.out.println("No bills to process");
        }
    }

    void displayBillQueue() {
        System.out.println("Remaining:");
        if (billQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (String bill : billQueue) {
            System.out.println(bill);
        }
    }

    // Task 5
    void submitRequest(BankAccount account) {
        accountRequests.add(account);
        System.out.println("Account added to processing");
    }

    void processRequest() {
        if (!accountRequests.isEmpty()) {
            BankAccount account = accountRequests.poll();
            addAccount(account);
        } else {
            System.out.println("No pending account requests");
        }
    }

    void displayPendingRequests() {
        System.out.println("Pending account requests:");
        if (accountRequests.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (BankAccount account : accountRequests) {
            System.out.println("- " + account.username);
        }
    }
}

public class Assik2_ {
    static void bankMenu(Scanner sc, BankingSystem bank) {
        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1 - Submit account request");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Add Bill Payment Request");
            System.out.println("5 - View All Accounts");
            System.out.println("6 - Show Last Transaction (Stack peek)");
            System.out.println("7 - Undo Last Transaction (Stack pop)");
            System.out.println("8 - Back");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Account number: ");
                    int num = sc.nextInt();
                    System.out.print("Username: ");
                    String name = sc.next();
                    System.out.print("Balance: ");
                    int bal = sc.nextInt();
                    bank.submitRequest(new BankAccount(num, name, bal));
                    break;
                case 2:
                    System.out.print("Username: ");
                    String depUser = sc.next();
                    System.out.print("Amount: ");
                    int depAmount = sc.nextInt();
                    bank.depositMoney(depUser, depAmount);
                    break;
                case 3:
                    System.out.print("Username: ");
                    String witUser = sc.next();
                    System.out.print("Amount: ");
                    int witAmount = sc.nextInt();
                    bank.withdrawMoney(witUser, witAmount);
                    break;
                case 4:
                    sc.nextLine(); // Clear buffer
                    System.out.print("Bill name (e.g., Electricity Bill): ");
                    String billName = sc.nextLine();
                    bank.addBill(billName);
                    break;
                case 5:
                    bank.displayAllAccounts();
                    break;
                case 6:
                    bank.showLastTransaction();
                    break;
                case 7:
                    bank.undoLastTransaction();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void atmMenu(Scanner sc, BankingSystem bank) {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Back");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String username = sc.next();
                    bank.searchAccount(username);
                    break;
                case 2:
                    System.out.print("Username: ");
                    String witUser = sc.next();
                    System.out.print("Amount: ");
                    int amount = sc.nextInt();
                    bank.withdrawMoney(witUser, amount);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void adminMenu(Scanner sc, BankingSystem bank) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1 - View account requests queue");
            System.out.println("2 - Process account request");
            System.out.println("3 - View bill payment queue");
            System.out.println("4 - Process next bill");
            System.out.println("5 - Back");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bank.displayPendingRequests();
                    break;
                case 2:
                    bank.processRequest();
                    break;
                case 3:
                    bank.displayBillQueue();
                    break;
                case 4:
                    bank.processNextBill();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        // Task 6. Create program that Creates array BankAccount[3]
        System.out.println("--- Task 6: Predefined Physical Array ---");
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount(1, "Assel", 100);
        accounts[1] = new BankAccount(2, "Zhansaya", 200);
        accounts[2] = new BankAccount(3, "Dilyara", 300);

        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].username + ": " + accounts[i].balance);
        }
        System.out.println("-----------------------------------------\n");

        Scanner sc = new Scanner(System.in);
        BankingSystem bank = new BankingSystem();
        for (int i = 0; i < accounts.length; i++) {
            bank.addAccount(accounts[i]);
        }

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: bankMenu(sc, bank); break;
                case 2: atmMenu(sc, bank); break;
                case 3: adminMenu(sc, bank); break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}