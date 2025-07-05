package Mensageiro;

public class ServicoRedesSociais implements Mensageiro {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("📲 Postando em Redes Sociais: " + mensagem);
    }
}
