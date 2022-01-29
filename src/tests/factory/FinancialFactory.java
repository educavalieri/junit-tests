package tests.factory;

import entities.Financing;

public class FinancialFactory {

    public static Financing createFinancing(Double totalAmount, Double income, Integer months){
        return new Financing(totalAmount, income, months);

    }

}
