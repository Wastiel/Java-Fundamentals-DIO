package Cinema;

public class MeiaEntrada extends Ingresso{

    public MeiaEntrada(double valorBase, String nomeFilme, String tipoExibicao) {
        super(valorBase, nomeFilme, tipoExibicao);
    }

    @Override
    public double getValorBase(){
        return this.valorBase /2;
    }
}
