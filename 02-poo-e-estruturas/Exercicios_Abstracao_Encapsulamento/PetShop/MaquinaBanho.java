package PetShop;

public class MaquinaBanho {

    private int agua;
    private int shampoo;
    private Pet pet;
    private boolean emUso;
    private final int limiteAgua = 30;
    private final int limiteShampoo = 10;


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
        if(shampoo < 3 && agua < 1){
            return false;
        } else {
            shampoo += -3;
            agua += -1;
            return true;
        }
    }

    public boolean isEmUso(){
        return this.emUso;
    }

    public boolean colocarPet(String nome, String raca){
        if(!isEmUso()){
            pet = new Pet(nome, raca);
            return true;
        }else{
            return false;
        }
    }

    public boolean darBanho(){
        if(shampoo < 2 && agua < 10 && !isEmUso()){
            return false;
        } else{
            this.agua -= 10;
            this.shampoo -= 2;
            return true;
        }
    }




}
