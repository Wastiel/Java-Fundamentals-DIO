package Carro;

public class Direcao {

    private Carro carro;

    public void criarrCarro(){
        carro = new Carro();
    }

    public void ligarCarro(){
        carro.setLigado();
        System.out.println("Carro ligado com sucesso");
    }

    public void desligarCarro(){
        if(!carro.setDesligado(false)) System.out.println("o carro está em movimento e não pode ser desligado.. Velocidade: " + carro.getVelocidade() );
            else
            System.out.println("o carro está em movimento e não pode ser desligado.. Velocidade: " + carro.getVelocidade() );
    }

    public void virar(){
        if(!carro.virarEsquerdaDireita()) System.out.println("o carro não tem velocidade necessário para virar... Velocidade: " + carro.getVelocidade() );
        else
            System.out.println("O carro virou para Direita/Esquerda" );
    }

    public void trocarMarcha(int marcha){
        if(!carro.setMarcha(marcha)) System.out.println("Marcha não pode ser trocada...");
        else System.out.println("Marcha trocada com sucesso.." + carro.getMarcha());
    }

    public void acelerarDesacelerar(int acelerarDesacelerar){

        if(!carro.setVelocidade(acelerarDesacelerar)) System.out.println("Carro acelerado com sucesso");
        else
            System.out.println("Não foi possivel acelerar o carro");

    }


}

