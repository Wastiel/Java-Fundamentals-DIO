package Tributavel;

public class Cultura implements Tributavel {
    private double valor;

    public Cultura(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        return valor * 0.04;
    }
}
