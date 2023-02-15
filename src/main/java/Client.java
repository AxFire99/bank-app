import java.util.HashSet;
import java.util.Set;

/**
 *The Client class represents a client from the bank
 */
public class Client {
    private final String name;
    private final int age;
    private final double debt;
    private final int nChildren;
    private final Set<Account> bankAccounts = new HashSet<>();

    /**
     * @param name Name of the client.
     * @param age Age of the client.
     * @param debt Amount of money the client owns the bank.
     * @param nChildren Amount of children the client has.
     */
    public Client(String name, int age, double debt, int nChildren) {
        this.name = name;
        this.age = age;
        this.debt = debt;
        this.nChildren = nChildren;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getDebt() {
        return debt;
    }
    public int getnChildren() {
        return nChildren;
    }

    public Boolean addAccount(Account account) {
        return this.bankAccounts.add(account);
    }

    public Set<Account> getBankAccounts() {
        return bankAccounts;
    }
}