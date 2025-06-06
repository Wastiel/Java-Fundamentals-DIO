package Carro;

public class Direcao {

    private Carro carro;

    public void criarrCarro(){
        carro = new Carro();
    }

    public void velocimetro(){
        System.out.println("Velocidade: "+ carro.getVelocidade());
        System.out.println("Marcha: "+ carro.getMarcha());
        System.out.println("Est� Ligado: "+ carro.isLigado());
    }

    public boolean chaveIgnicao(){
        return carro.isLigado();
    }

    public void ligarCarro(){
        if(carro.isLigado()){
            System.out.println("Carro j� est� ligado");
        }else{
            carro.setLigado();
            System.out.println("Carro ligado com sucesso");
        }
    }

    public void desligarCarro(){
        if(!carro.setDesligado(false))
        {System.out.println("o carro est� em movimento e n�o pode ser desligado.. Velocidade: " + carro.getVelocidade() );}
            else
        {System.out.println("o carro foi desligado..: Velcoidade: " + carro.getVelocidade() );}
    }

    public void virar(){
        if(!carro.virarEsquerdaDireita()) System.out.println("o carro n�o tem velocidade necess�rio para virar... Velocidade: " + carro.getVelocidade() );
        else
            System.out.println("O carro virou para Direita/Esquerda" );
    }

    public void trocarMarcha(int marcha){
        if(!carro.setMarcha(marcha))
        {System.out.println("Marcha n�o pode ser trocada...");}
        else
        {System.out.println("Marcha trocada com sucesso.." + carro.getMarcha());}
    }

    public void acelerarDesacelerar(int acelerarDesacelerar){

        if(carro.setVelocidade(acelerarDesacelerar))
            {System.out.println("Carro acelerado/desacelerado com sucesso");}
        else{
            System.out.println("N�o foi possivel acelerar/desacelerar o carro, verifique a marcha");
        }
    }
}

