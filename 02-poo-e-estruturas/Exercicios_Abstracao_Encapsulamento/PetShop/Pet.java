package PetShop;

public class Pet {

    private String nome;
    private String raca;
    private boolean limpo;

    public Pet(String nome, String raca){
        this.nome = nome;
        this.raca = raca;
        this.limpo = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    public boolean isLimpo() {
        return limpo;
    }
}
