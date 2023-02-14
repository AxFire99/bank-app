public class Client {
    private String name;
    private int age;
    private double debt;
    private int numberChildren;

    public Client(String name, int age, double debt, int numberChildren) {
        this.name = name;
        this.age = age;
        this.debt = debt;
        this.numberChildren = numberChildren;
    }

    public String getName() {
        return name;
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

    public int getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(int numberChildren) {
        this.numberChildren = numberChildren;
    }
}
