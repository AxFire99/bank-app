import java.util.ArrayList;
import java.util.Collection;

/**
 *The Client class represents a client from the bank
 */
public class Client {
    private String name;
    private int age;
    private double debt;
    private int nChildren;
    private final ArrayList<Account> bankAccounts = new ArrayList<Account>();

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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public int getnChildren() {
        return nChildren;
    }

    public void setnChildren(int nChildren) {
        this.nChildren = nChildren;
    }

    /**
     * @param accounts Amount of accounts the client has.
     * @return <code>true</code> if the account is added successfully;
     * @throws ArrayStoreException if the account was already added to the client.
     */
    public Boolean addAccount(Account... accounts) {
        for(Account account : accounts){
            if(!bankAccounts.contains(account)){
                bankAccounts.add(account);
            }else {
                throw new ArrayStoreException("this account already was added to this client");
            }
        }
        return true;
    }

    public ArrayList<Account> getBankAccounts() {
        return bankAccounts;
    }
}