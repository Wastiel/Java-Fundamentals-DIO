package Mensageiro;

public class ServicoWhatsApp implements Mensageiro {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("💬 Enviando WhatsApp: " + mensagem);
    }
}