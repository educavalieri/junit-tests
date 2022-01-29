package tests.entities;
import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import tests.factory.FinancialFactory;


public class FinancingTests {

    @Test
    public void financingCorrectData(){
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 80;


        //Act
        Financing financing = new Financing(totalAmount, income, months);

        //
        Assertions.assertEquals(financing.getTotalAmount(), totalAmount);
        Assertions.assertEquals(financing.getIncome(), income );
        Assertions.assertEquals(financing.getMonths(), months);
    }

    @Test
    public void financingInCorrectData() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 20;

        //ACT and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = new Financing(totalAmount, income, months);
        });
    }

    @Test
    public void setCorrectTotalAmountShouldReturnCorrectValue() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 90;
        Double newTotalAmount = 110000.0;

        //ACT
        Financing financing = new Financing(totalAmount, income, months);
        financing.setTotalAmount(newTotalAmount);

        // and Assert
        Assertions.assertEquals(financing.getTotalAmount(), newTotalAmount);
    }
    @Test
    public void setInCorrectTotalAmountShouldReturnException() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 80;
        Double newTotalAmount = 110000.0;

        //ACT and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = new Financing(totalAmount, income, months);
            financing.setTotalAmount(newTotalAmount);
        });
    }

    @Test
    public void setCorrectIncomeShouldReturnCorrectValue() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 90;
        Double newIncome = 3000.0;

        //ACT
        Financing financing = new Financing(totalAmount, income, months);
        financing.setIncome(newIncome);

        // and Assert
        Assertions.assertEquals(financing.getIncome(), newIncome);
    }
    @Test
    public void setInCorrectIncomeShouldReturnException() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 80;
        Double newIncome = 1999.0;

        //ACT and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = new Financing(totalAmount, income, months);
            financing.setIncome(newIncome);
        });
    }

    @Test
    public void setCorrectMountsShouldReturnCorrectValue() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 80;
        Integer newMonths = 81;

        //ACT
        Financing financing = new Financing(totalAmount, income, months);
        financing.setMonths(newMonths);

        // and Assert
        Assertions.assertEquals(financing.getMonths(), newMonths);
    }
    @Test
    public void setInCorrectMountsShouldReturnException() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 80;
        Integer newMonths = 79;

        //ACT and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = new Financing(totalAmount, income, months);
            financing.setMonths(newMonths);
        });
    }

    @Test
    public void calculateCorrectEntry() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 80;
        Double calculateEntry = 20000.0;

        //ACT
        Financing financing = new Financing(totalAmount, income, months);

        // and Assert
        Assertions.assertEquals(financing.entry(), calculateEntry);
    }

    @Test
    public void calculateCorrectQuote() {
        // Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 80;
        Double calculateQuote = 1000.0;

        //ACT
        Financing financing = new Financing(totalAmount, income, months);

        // and Assert
        Assertions.assertEquals(financing.quota(), calculateQuote);
    }

    @Test
    public void testCreationFinancialFactory(){
        //Arrange
        Double totalAmount = 100000.0;
        Double income = 2000.0;
        Integer months = 80;

        //Act
        Financing financing = FinancialFactory.createFinancing(totalAmount, income, months);

        //Assert
        Assertions.assertEquals(financing.getMonths(), 80);
        Assertions.assertEquals(financing.getIncome(), 2000.0);
        Assertions.assertEquals(financing.getTotalAmount(), 100000.0);





    }




}
