package Tributavel;

public class Saude implements Tributavel {
    private double valor;

    public Saude(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        return valor * 0.015;
    }
}
