package tests.entities;
import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import tests.factory.AccountFactory;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTests{


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
        Assertions.assertEquals(expectedValue, account.getBalance());

    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount(){

        //ARRANGE
        double expectedValue = 100.0;
        Account account = new Account(1L, expectedValue);
        double amount = -200.0;

        //ACT
        account.deposit(amount);

        //ASSERT
        Assertions.assertEquals(expectedValue, account.getBalance());
    }

    @Test
    public void factoryDepositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount(){
        //Arrange
        double amount = 200.0;
        double expectedValue = 196.0;
        Account account = AccountFactory.createEmptyAccount();

        //Act
        account.deposit(amount);

        //Assert
        Assertions.assertEquals(expectedValue, account.getBalance());
    }

    @Test
    public void factoryDepositShouldDoNothingWhenNegativeAmount() {
        //Arrange
        double expectedValue = 200.0;
        double amount = -200.0;
        Account account = AccountFactory.createAccount(200.0);

        //Act
        account.deposit(amount);

        //Assert
        Assertions.assertEquals(expectedValue, account.getBalance());
    }

    @Test
    public void fullWithdrawShouldRescuelAll(){
        //Arrange
        double expectedValue = 0.0;
        double actualBalance = 200.0;

        //Act
        Account account = AccountFactory.createAccount(actualBalance);
        double rescue = account.fullWithdraw();

        //Assert
        Assertions.assertEquals(actualBalance, rescue);
    }

    @Test
    public void fullWithdrawShouldClearBalance(){
        //Arrange
        double balance = 200.0;
        double finalBalance = 0.0;

        //Act
        Account account = AccountFactory.createAccount(balance);
        account.fullWithdraw();

        //Assert
        Assertions.assertTrue(finalBalance == account.getBalance());
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance(){
        //Arrange
        double actualBalance = 800.0;
        double withdrawSolicitation = 400.0;
        double finalBalance = 400.0;

        //Act
        Account account = AccountFactory.createAccount(actualBalance);
        account.withdraw(withdrawSolicitation);
        double balanceWithdraw = account.getBalance();

        //Assert
        //AssertJUnit.assertEquals(finalBalance, account.getBalance());
        Assertions.assertEquals(finalBalance, balanceWithdraw);

    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance(){

        double actualBalance = 800.0;
        double withdrawSolicitation = 801.0;

        //Assert and Act
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = AccountFactory.createAccount(actualBalance);
            account.withdraw(withdrawSolicitation);
        });
    }

}
