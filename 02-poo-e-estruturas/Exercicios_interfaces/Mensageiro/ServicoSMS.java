package Mensageiro;

public class ServicoSMS implements Mensageiro {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("📱 Enviando SMS: " + mensagem);
    }
}

