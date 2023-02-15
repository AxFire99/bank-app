import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankTests {

    public Client client;
    public Client clientDebt;

    @BeforeEach
    void setUp () {
        client = new Client( "Diogo" , 18 , 0 , 0 );
        clientDebt = new Client( "Nuno" , 30 , 1500 , 2 );
    }

    @Test
    @DisplayName ("Test the client details")
    void testClientDetails () {
        assertAll(
                () -> assertEquals( "Diogo" , client.getName( ) ) ,
                () -> assertEquals( 18 , client.getAge( ) ) ,
                () -> assertEquals( 0 , client.getDebt( ) ) ,
                () -> assertEquals( 0 , client.getnChildren( ) ) ,
                () -> assertEquals( 0 , client.getBankAccounts( ).size( ) )
        );
    }

    @Test
    @DisplayName ("Test the association of the bank account to the client")
    void testAddAccountToClient () {
        Account account = new Account( );
        client.addAccount( account );
        assertAll(
                () -> assertEquals( 1 , client.getBankAccounts( ).size( ) ) ,
                () -> assertTrue( client.getBankAccounts( ).contains( account ) )
        );
    }

    @ParameterizedTest
    @ValueSource (doubles = {5 , 10 , 20 , 50})
    @DisplayName ("Test the deposit of money in the user account")
    void testDeposit ( double money ) {
        Account account = new Account( );
        client.addAccount( account );
        assertAll(
                () -> assertEquals( 1 , client.getBankAccounts( ).size( ) ) ,
                () -> assertTrue( client.getBankAccounts( ).contains( account ) ) ,
                () -> assertTrue( account.deposit( money ) ) ,
                () -> assertEquals( money , account.getBalance( ) )
        );

    }

    @ParameterizedTest
    @CsvSource ({"50, 10, 40" , "100, 40, 60"})
    @DisplayName ("Test the withdrawal of money in the user account")
    void testWithdrawal ( double moneyAccount , double moneyWithdrawal , double excpedtedMoney ) {
        Account account = new Account( moneyAccount );
        client.addAccount( account );
        assertAll(
                () -> assertEquals( 1 , client.getBankAccounts( ).size( ) ) ,
                () -> assertTrue( client.getBankAccounts( ).contains( account ) ) ,
                () -> assertTrue( account.withdrawal( moneyWithdrawal ) ) ,
                () -> assertEquals( excpedtedMoney , account.getBalance( ) )
        );

    }


    @Test
    @DisplayName ("Test if the client cannot withdrawal more money than the money she/he has.")
    void testWithdrawalNegative () {
        Account account = new Account( 10 );
        client.addAccount( account );
        assertAll(
                () -> assertEquals( 1 , client.getBankAccounts( ).size( ) ) ,
                () -> assertTrue( client.getBankAccounts( ).contains( account ) ) ,
                () -> assertThrows( ArithmeticException.class , () -> account.withdrawal( 15 ) )
        );
    }

    @Test
    @DisplayName ("Test that the user can ask for a loan")
    void testAskOkForLoan () {
        assertTrue( ClientAssessment.assess( client ) );
    }

    @Test
    @DisplayName ("Test that the user cannot ask for a loan")
    void testAskRefusedForLoan () {
        assertFalse( ClientAssessment.assess( clientDebt ) );
    }

}