package PetShopRefatorado;

public class MaquinaBanho {
    private static final int MAX_AGUA = 30;
    private static final int MAX_SHAMPOO = 10;
    private static final int CONSUMO_AGUA_BANHO = 10;
    private static final int CONSUMO_SHAMPOO_BANHO = 2;
    private static final int CONSUMO_AGUA_LIMPEZA = 3;
    private static final int CONSUMO_SHAMPOO_LIMPEZA = 1;
    private static final int ABASTECIMENTO_POR_VEZ = 2;

    private int agua = 0;
    private int shampoo = 0;
    private Pet pet = null;
    private boolean suja = false;

    public boolean colocarPet(Pet novoPet) {
        if (pet != null) return false;
        if (suja) return false;

        this.pet = novoPet;
        this.suja = true;
        return true;
    }

    public boolean darBanho() {
        if (pet == null) return false;
        if (agua < CONSUMO_AGUA_BANHO || shampoo < CONSUMO_SHAMPOO_BANHO) return false;

        agua -= CONSUMO_AGUA_BANHO;
        shampoo -= CONSUMO_SHAMPOO_BANHO;
        pet.limpar();
        suja = false;
        return true;
    }

    public boolean retirarPet() {
        if (pet == null) return false;
        // Se não foi limpo, continua suja
        if (!pet.isLimpo()) suja = true;
        pet = null;
        return true;
    }

    public boolean limparMaquina() {
        if (agua < CONSUMO_AGUA_LIMPEZA || shampoo < CONSUMO_SHAMPOO_LIMPEZA) return false;

        agua -= CONSUMO_AGUA_LIMPEZA;
        shampoo -= CONSUMO_SHAMPOO_LIMPEZA;
        suja = false;
        return true;
    }

    public boolean abastecerAgua() {
        if (agua + ABASTECIMENTO_POR_VEZ > MAX_AGUA) return false;
        agua += ABASTECIMENTO_POR_VEZ;
        return true;
    }

    public boolean abastecerShampoo() {
        if (shampoo + ABASTECIMENTO_POR_VEZ > MAX_SHAMPOO) return false;
        shampoo += ABASTECIMENTO_POR_VEZ;
        return true;
    }

    public int getAgua() {
        return agua;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean isEmUso() {
        return pet != null;
    }

    public boolean isSuja() {
        return suja;
    }

    public Pet getPet() {
        return pet;
    }
}
