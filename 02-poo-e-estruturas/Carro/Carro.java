package Carro;

public class Carro {

    private boolean ligado;
    private int marcha;
    private int velocidade;

    public Carro(){
        this.ligado = false;
        this.marcha = 0;
        this.velocidade = 0;
    }

    public boolean setDesligado(boolean ligado) {
        if(!ligado && marcha == 0 && velocidade == 0){
            this.ligado = false;
            return true;
        }
        return false;
    }

    public void setLigado() {
        this.ligado = true;
    }

    public boolean isLigado(){
        return this.ligado;
    }

    public int getVelocidade(){
        return this.velocidade;
    }

    public boolean setVelocidade(int velocidade){
        if(velocidade == 1 && this.velocidade < 120){
            this.velocidade += velocidade;
            return true;
        } else if(velocidade == -1 && this.velocidade <1){
            this.velocidade += velocidade;
            return true;
        }
        return false;
    }

    public boolean setMarcha(int marcha){
        if(marcha > this.marcha + 1 && this.marcha > 6) return false;
        if(marcha < this.marcha - 1 && this.marcha < 0) return false;

        this.marcha += marcha;
        return true;
    }

    public boolean virarEsquerdaDireita(){
        if (this.velocidade > 1 && this.velocidade < 40){
            return true;
        }
        return false;
    }


    public int getMarcha() {
        return this.getMarcha();
    }
}
