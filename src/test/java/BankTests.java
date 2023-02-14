import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTests {
    @Test
    void testAddAccountToClient(){
        Client client = new Client("Diogo",26,15000,0);
        Account account1 = new Account(1,15);
        Account account2 = new Account(2,25);
        assertAll(
                ()-> assertTrue(client.addAccount(account1)),
                () -> assertTrue(client.getBankAccounts ().contains (account1)),
                () -> assertTrue(client.getBankAccounts ().contains (account1)),
                () -> assertThrows (ArrayStoreException.class, ()-> client.addAccount(account1))
        );
    }
    @Test
    void testCreditApproval(){
        Client client = new Client("Diogo",18,0,0);
        assertTrue(ClientAssessment.assess(client));
    }
}