package entities;

public class Financing {

    private Double totalAmount;
    private Double income;
    private Integer months;

    public Financing(Double totalAmount, Double income, Integer months) {
        validateFinancing(totalAmount, income, months);
        this.totalAmount = totalAmount; // value total financing
        this.income = income;           // client income
        this.months = months;           // total month financing

        // rule: o valor da prestação (quote) não pode ser maior que metade da renda mensal do cliente (income)
        // totalAmount : valor total financiado
        // income : renda mensal do client
        // months : total de meses
        // entry : valor da entrada = 20% o valor do total financiado (entry = totalAmonunt * 0.2)
        // quote : valor mensal do financiamento ( quote = totalAmount - entry / months)

    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        validateFinancing(totalAmount, income, months);
        this.totalAmount = totalAmount;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        validateFinancing(totalAmount, income, months);
        this.income = income;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        validateFinancing(totalAmount, income, months);
        this.months = months;
    }

    public Double entry(){
        return totalAmount * 0.2;
    }

    public Double quota(){
        return (totalAmount - entry()) / months;
    }


    public void validateFinancing(Double totalAmount, Double income, Integer months){
        if (totalAmount * 0.8 / months > income / 2.0){
            throw new IllegalArgumentException("A parcela não pode ser maior que a renda");
        }

    }

}
