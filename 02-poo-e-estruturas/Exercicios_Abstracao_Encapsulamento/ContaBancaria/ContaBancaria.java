package ContaBancaria;

public class ContaBancaria {

    private double saldo;
    private double limiteChequeEspecial;
    private static double taxa = 20.00;
    private double chequeEspecial;
    private double usochequeEspecial;

    public ContaBancaria(double debosito){
        this.saldo = debosito;
        this.limiteChequeEspecial =  debosito < 500 ? - 50 : - (debosito / 2);
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getUsochequeEspecial() {
        return usochequeEspecial;
    }

    public void setUsochequeEspecial(double usochequeEspecial) {
        this.usochequeEspecial = usochequeEspecial;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial(){
        return this.chequeEspecial;
    }

    public double getTaxa() {
        return taxa;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}
