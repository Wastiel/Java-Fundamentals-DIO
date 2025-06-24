package Sistema;

public class Atendente extends Pessoa {
    private double caixa;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.administrador = false;
        this.caixa = 0.0;
    }

    public void receberPagamento(double valor) {
        if (logado) {
            caixa += valor;
            System.out.println("Pagamento de R$" + valor + " recebido.");
        } else {
            System.out.println("Você precisa estar logado para registrar pagamentos.");
        }
    }

    public void fecharCaixa() {
        System.out.println("Fechando caixa. Valor final: R$" + caixa);
    }
}
