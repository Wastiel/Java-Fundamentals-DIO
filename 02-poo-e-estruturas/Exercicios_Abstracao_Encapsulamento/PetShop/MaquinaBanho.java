package PetShop;

public class MaquinaBanho {

    private int agua;
    private int shampoo;
    private Pet pet;
    private boolean emUso = false;
    private final int limiteAgua = 30;
    private final int limiteShampoo = 10;
    private boolean utilizada = false;


    public void setEmUso(boolean emUso) {
        this.emUso = emUso;
    }
    public boolean isUtilizada() {
        return utilizada;
    }

    public void setUtilizada(boolean utilizada) {
        this.utilizada = utilizada;
    }

    public void abastecerShampoo(){
        this.shampoo += 2;
    }
    public int getShampoo(){
        return this.shampoo;
    }
    public void abastecerAgua(){
        this.agua += 2;
    }
    public int getAgua(){
        return this.agua;
    }

    public boolean limparMaquina(){
        if(shampoo < 3 || agua < 1){
            return false;
        } else {
            shampoo += -3;
            agua += -1;
            this.utilizada = false;
            return true;
        }
    }

    public boolean isEmUso(){
        return this.emUso;
    }

    public boolean colocarPet(String nome, String raca){
        if(!isEmUso()){
            pet = new Pet(nome, raca);
            emUso = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean darBanho(){
        if(shampoo < 2 || agua < 10 ){
            return false;
        } else{
            pet.setLimpo(true);
            this.agua -= 10;
            this.shampoo -= 2;
            return true;
        }
    }

    public boolean retirarMaquina(){
        if(this.emUso){
            this.emUso = false;
            this.utilizada = pet.isLimpo();
            return true;
        }else{
            return false;
        }
    }
}
