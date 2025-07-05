package Tributavel;

public class Alimentacao implements Tributavel {
    private double valor;

    public Alimentacao(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        return valor * 0.01;
    }
}
