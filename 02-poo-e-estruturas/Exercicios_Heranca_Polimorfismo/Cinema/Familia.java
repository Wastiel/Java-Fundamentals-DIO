package Cinema;

public class Familia extends Ingresso{

    private int quantidade;
    private double desconto;

    public Familia(double valorBase, String nomeFilme, String tipoExibicao, int quantidade) {
        super(valorBase, nomeFilme, tipoExibicao);
        this.quantidade = quantidade;
    }

    @Override
    public double getValorBase(){

        double valorTotal = quantidade * this.valorBase;
        if(quantidade>3){
            valorTotal = valorTotal - (valorTotal * 0.05);
        }

        return valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
