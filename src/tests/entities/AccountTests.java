package tests.entities;
import entities.Account;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
        //AAA

        //ARRANGE
        double amount = 200.0;
        double expectedValue = 196.0;

        //ACT
        Account account = new Account(1L,0.0);
        account.deposit(amount);

        //ASSERT
        AssertJUnit.assertEquals(expectedValue, account.getBalance());

    }

}
