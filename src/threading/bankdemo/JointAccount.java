package threading.bankdemo;


public class JointAccount {
    public static void function() {
        Runnable jointAccount = new Account(100);
        Thread johnThread = new Thread(jointAccount);
        Thread anitaThread = new Thread(jointAccount);
        johnThread.setName("John's Thread");
        anitaThread.setName("Anita's Thread");
        johnThread.start();
        anitaThread.start();
    }
}

class Account implements Runnable {
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public void run() {
        withdraw(75);
        if (amount <= 0) {
            System.out.println("OverWithdrawn");
        }
    }

    private synchronized void withdraw(int i) {
        if (amount >= i) {
            System.out.printf("%s is about to withdraw\n",Thread.currentThread().getName());
            amount -= i;
            System.out.printf("%s has withdrawn\n",Thread.currentThread().getName());
        }else {
            System.out.println("Insufficient Balance");
        }
    }
}

