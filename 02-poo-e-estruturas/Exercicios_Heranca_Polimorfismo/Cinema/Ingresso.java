package Cinema;

public class Ingresso {

    protected double valorBase;
    private String nomeFilme;
    private String tipoExibicao;

    public Ingresso(double valorBase, String nomeFilme, String tipoExibicao){
        this.valorBase = valorBase;
        this.nomeFilme = nomeFilme;
        this.tipoExibicao = tipoExibicao;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getTipoExibicao() {
        return tipoExibicao;
    }

    public void setTipoExibicao(String tipoExibicao) {
        this.tipoExibicao = tipoExibicao;
    }




}
