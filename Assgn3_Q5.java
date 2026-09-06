import java.util.Scanner;

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {

    private int accountNumber;
    private String name;
    private double balance;

    public BankAccount(
            int accountNumber,
            String name,
            double balance) {

        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        System.out.println(
            "Deposit successful: Rs. " + amount
        );
    }

    public void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {

            throw new InsufficientBalanceException(
                "Insufficient balance."
            );
        }

        balance -= amount;

        System.out.println(
            "Withdrawal successful: Rs. " + amount
        );
    }
}

public class Main {

    static BankAccount findAccount(
            BankAccount[] accounts,
            int accountNumber)
            throws AccountNotFoundException {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber()
                    == accountNumber) {

                return account;
            }
        }

        throw new AccountNotFoundException(
            "Account " + accountNumber + " not found."
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount[] accounts = {

            new BankAccount(101, "Rahul", 5000),

            new BankAccount(102, "Priya", 10000),

            new BankAccount(103, "Aman", 7500)
        };

        try {

            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();

            BankAccount account =
                    findAccount(accounts, accountNumber);

            System.out.println(
                "Account found."
            );

            System.out.println(
                "Current Balance: Rs. "
                + account.getBalance()
            );

            System.out.print(
                "Enter deposit amount: "
            );

            double deposit = sc.nextDouble();

            account.deposit(deposit);

            System.out.print(
                "Enter withdrawal amount: "
            );

            double withdrawal = sc.nextDouble();

            account.withdraw(withdrawal);

            System.out.println(
                "Final Balance: Rs. "
                + account.getBalance()
            );

        }
        catch (AccountNotFoundException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
        catch (InvalidAmountException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
        catch (InsufficientBalanceException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
        finally {

            System.out.println(
                "Banking operation completed."
            );
        }

        sc.close();
    }
}
