package ContaBancaria;

public class ContaBancaria {

    private double saldo;
    private final double limiteChequeEspecial;
    private final double taxa;
    private double chequeEspecialUsado; // valor negativo ou zero
    private double usoChequeEspecial;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        this.limiteChequeEspecial = depositoInicial < 500 ? -50 : -(depositoInicial / 2);
        this.taxa = 0.20;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        if (this.saldo > 0 && this.chequeEspecialUsado < 0) {
            this.chequeEspecialUsado = 0;

            double juros = usoChequeEspecial * taxa;
            if (this.saldo > juros) {
                this.saldo -= juros;
                this.usoChequeEspecial = 0;
            }
        } else if (this.chequeEspecialUsado < 0 && this.saldo > 0) {
            this.chequeEspecialUsado += valor;
        }
    }

    public boolean sacar(double valor) {
        if (this.saldo - valor < limiteChequeEspecial) {
            return false;
        }

        this.saldo -= valor;

        if (this.saldo < 0) {
            this.chequeEspecialUsado = this.saldo;
            this.usoChequeEspecial += valor;
        }

        return true;
    }

    public double getSaldoReal() {
        return this.saldo;
    }

    public double getSaldoDisponivel() {
        return this.saldo > 0 ? this.saldo : 0;
    }

    public double getChequeEspecialUsado() {
        return chequeEspecialUsado;
    }

    public double getUsoChequeEspecial() {
        return usoChequeEspecial;
    }

    public double getTaxa() {
        return taxa;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}
