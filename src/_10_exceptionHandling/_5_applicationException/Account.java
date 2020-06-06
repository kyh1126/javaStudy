package _10_exceptionHandling._5_applicationException;

public class Account {
    private long balance;

    public long getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) throws BalanceInsufficientException {
        if (balance < money) {
            throw new BalanceInsufficientException("잔고 부족:" + (money - balance) + " 모자람");
        }
        balance -= money;
    }
}
