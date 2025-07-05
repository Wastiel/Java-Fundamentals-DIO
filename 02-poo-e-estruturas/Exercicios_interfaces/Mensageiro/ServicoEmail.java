package Mensageiro;

public class ServicoEmail implements Mensageiro {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("📧 Enviando E-mail: " + mensagem);
    }
}