public class ClientAssessment {
    static final double age = 0.25;
    static final double debt = 0.45;
    static final double child = 0.30;

    public static boolean assess (Client client){
        double risk = 0;
        if (client.getAge()>=18)
            risk += age;
        if (client.getDebt()==0)
            risk += debt;
        if (client.getnChildren()<3)
            risk += child;
        return risk >= .60;
    }
}
