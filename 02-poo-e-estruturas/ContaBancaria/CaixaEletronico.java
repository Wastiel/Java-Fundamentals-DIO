package ContaBancaria;

public class CaixaEletronico {

    private ContaBancaria contaBancaria;

    public void criarConta(Double valorInicial){
        contaBancaria = new ContaBancaria(valorInicial);
    }
    public void depositar(double deposito){

        contaBancaria.setSaldo(contaBancaria.getSaldo() + deposito);
        if(contaBancaria.getSaldo()>0 && contaBancaria.getChequeEspecial() < 0){
            contaBancaria.setChequeEspecial(0);
            if(contaBancaria.getSaldo() > contaBancaria.getUsochequeEspecial() * (contaBancaria.getTaxa()/100) ){
                contaBancaria.setUsochequeEspecial(0);
                contaBancaria.setSaldo(contaBancaria.getSaldo() - contaBancaria.getUsochequeEspecial() * (contaBancaria.getTaxa()/100));
            }
        } else if (contaBancaria.getChequeEspecial() < 0 && contaBancaria.getSaldo()>0) {
            contaBancaria.setChequeEspecial(contaBancaria.getChequeEspecial() + deposito);
        }

    }
    public void sacar(double saque){
        if(contaBancaria.getSaldo() - saque < (contaBancaria.getLimiteChequeEspecial())){
            System.out.println("O valor não pode ser sacado por falta de saldo e estouro do limite");
        } else{
            contaBancaria.setSaldo(contaBancaria.getSaldo() - saque);
            if(contaBancaria.getSaldo() < 0){
                contaBancaria.setChequeEspecial(contaBancaria.getSaldo());
                contaBancaria.setUsochequeEspecial(saque + contaBancaria.getUsochequeEspecial());
            }
        }
    }
    public void pagarBarra(double valorBoleto){
        if(contaBancaria.getSaldo() - valorBoleto < (contaBancaria.getLimiteChequeEspecial())){
            System.out.println("O Boleto não pode ser pago por falta de saldo e estouro do limite");
        } else{
            contaBancaria.setSaldo(contaBancaria.getSaldo() - valorBoleto);
            if(contaBancaria.getSaldo() < 0){
                contaBancaria.setChequeEspecial(contaBancaria.getSaldo());
                contaBancaria.setUsochequeEspecial(valorBoleto + contaBancaria.getUsochequeEspecial());
            }
        }
    }
    public void chequeEmUso(){
        System.out.println("Seu Limite do cheque especial é: " + contaBancaria.getLimiteChequeEspecial());
        System.out.println("Seu chequeEspecial em uso é: " + contaBancaria.getChequeEspecial());
        System.out.println("Seu chequeEspecial acumulado é: " + contaBancaria.getUsochequeEspecial());
    }

    public void saldo(){
        System.out.println("Seu saldo é: " + (contaBancaria.getSaldo() <= 0 ? 0 : contaBancaria.getSaldo()));
        System.out.println("Limite Especial em uso: " + (contaBancaria.getChequeEspecial() > -1 ? 0 : contaBancaria.getChequeEspecial()));
    }
}
