package ContaBancaria;

public class CaixaEletronico {

    private ContaBancaria contaBancaria;

    public void criarConta(double valorInicial) {
        contaBancaria = new ContaBancaria(valorInicial);
    }

    public void depositar(double valor) {
        contaBancaria.depositar(valor);
        System.out.printf("Depósito realizado com sucesso! Saldo atual: R$ %.2f\n", contaBancaria.getSaldoReal());
    }

    public void sacar(double valor) {
        if (contaBancaria.sacar(valor)) {
            System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valor);
        } else {
            System.out.println("Não foi possível realizar o saque. Saldo insuficiente e limite do cheque especial excedido.");
        }
    }

    public void pagarBoleto(double valor) {
        if (contaBancaria.sacar(valor)) {
            System.out.printf("Boleto de R$ %.2f pago com sucesso!\n", valor);
        } else {
            System.out.println("Não foi possível pagar o boleto. Saldo insuficiente e limite do cheque especial excedido.");
        }
    }

    public void exibirChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f\n", contaBancaria.getLimiteChequeEspecial());
        System.out.printf("Cheque especial usado (valor negativo): R$ %.2f\n", contaBancaria.getChequeEspecialUsado());
        System.out.printf("Total já utilizado do cheque especial: R$ %.2f\n", contaBancaria.getUsoChequeEspecial());
    }

    public void exibirSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f\n", contaBancaria.getSaldoDisponivel());
        System.out.printf("Saldo real (pode ser negativo): R$ %.2f\n", contaBancaria.getSaldoReal());
    }
}
