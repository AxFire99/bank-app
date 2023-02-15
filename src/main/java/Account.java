/**
 *
 */
public class Account {
    private double balance;

    public Account () {
        this.balance = 0;
    }

    public Account ( double balance ) {
        this.balance = balance;
    }

    public boolean withdrawal ( double money ) throws ArithmeticException {
        if ( this.balance >= money ) {
            this.balance -= money;
            return true;
        }
        throw new ArithmeticException( "Not enough money" );
    }

    public boolean deposit ( double money ) {
        this.balance += money;
        return true;
    }

    public double getBalance () {
        return balance;
    }
}
