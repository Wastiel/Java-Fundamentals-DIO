package Tributavel;

public class Vestuario implements Tributavel {
    private double valor;

    public Vestuario(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        return valor * 0.025;
    }
}
