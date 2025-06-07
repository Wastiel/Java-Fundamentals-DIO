package Carro;

public class Carro {

    private boolean ligado;
    private int marcha;
    private int velocidade;
    final int[][] faixas = {
            {1, 1, 20},    // marcha, velocidade mínima, velocidade máxima
            {2, 21, 40},
            {3, 41, 60},
            {4, 61, 80},
            {5, 81, 100},
            {6, 101, 120}
    };
    private int alternancia;

    public Carro(){
        this.ligado = false;
        this.marcha = 0;
        this.velocidade = 0;
    }

    public boolean setDesligado(boolean ligado) {
        if(!ligado && marcha == 0 && velocidade == 0){
            this.ligado = false;
            return true;
        }else{
            return false;
        }

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

    /*
    public boolean setVelocidade(int velocidade){
        if(velocidade == 1 && this.velocidade < 120){
            this.velocidade += velocidade;
            return true;
        } else if(velocidade == -1 && this.velocidade > 0){
            this.velocidade += velocidade;
            return true;
        }
        return false;
    }
     */

    public boolean setVelocidade(int velocidade){
        if(caixaMarcha()){
            this.velocidade += velocidade;
            return true;
        } else {
            return false;
        }
    }

    private boolean caixaMarcha() {
        for (int[] faixa : faixas) {
            if (this.marcha == faixa[0] && this.velocidade >= faixa[1] && this.velocidade <= faixa[2]) {
                return true;
            }
        }
        return false;
    }

    public boolean constanciaMarcha(int marcha){
        marcha += this.marcha;
        if ( marcha < 0 || marcha > 6) {
            return false;
        } else {
            this.marcha += marcha;
            this.velocidade += 20;
            return true;
        }
    }
    public boolean setMarcha(int marcha){
        alternancia = marcha;
        marcha += this.marcha;
        if ( marcha < 0 || marcha > 6) {
            return false;
        } else {
            this.marcha = marcha;
            this.velocidade = 19 * this.marcha ;
            return true;
        }
    }

    public boolean virarEsquerdaDireita(){
        if (this.velocidade > 1 && this.velocidade < 40){
            return true;
        }else {
            return false;
        }
    }

    public int getMarcha() {
        return this.marcha;
    }
}
