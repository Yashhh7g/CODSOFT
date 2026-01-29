public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
            return false;
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
            return false;
        } else {
            balance -= amount;
            System.out.println("✅ Please collect your cash.");
            return true;
        }
    }
}

