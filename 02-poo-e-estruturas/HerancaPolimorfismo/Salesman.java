package HerancaPolimorfismo;

public non-sealed class Salesman extends Employee{

    private double percentPerSold;
    private double souldAmount;

    public Salesman(String code,
                    String name,
                    String address,
                    String age,
                    double salary,
                    double percentPerSold,
                    double souldAmount) {
        super(code, name, address, age, salary);
        this.percentPerSold = percentPerSold;
        this.souldAmount = souldAmount;
    }

    public Salesman() {
    }

    @Override
    public String getCode(){
        return "SL" + this.code;
    }

    public double getPercentPerSold() {
        return percentPerSold;
    }

    public void setPercentPerSold(double percentPerSold) {
        this.percentPerSold = percentPerSold;
    }

    public double getSouldAmount() {
        return souldAmount;
    }

    public void setSouldAmount(double souldAmount) {
        this.souldAmount = souldAmount;
    }

    @Override
    public double getFullSalary(){
        return this.salary + (souldAmount * percentPerSold / 100);
    }

}
