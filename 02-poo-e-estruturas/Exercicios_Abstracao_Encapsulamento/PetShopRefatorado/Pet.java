package PetShopRefatorado;

public class Pet {
    private final String nome;
    private final String raca;
    private boolean limpo;

    public Pet(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
        this.limpo = false;
    }

    public void limpar() {
        this.limpo = true;
    }

    public boolean isLimpo() {
        return limpo;
    }

    @Override
    public String toString() {
        return nome + " (" + raca + ")";
    }
}
